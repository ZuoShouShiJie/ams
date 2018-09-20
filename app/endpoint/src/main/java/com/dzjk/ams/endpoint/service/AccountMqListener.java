package com.dzjk.ams.endpoint.service;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventContext;
import com.alipay.common.event.UniformEventMessageListener;
import com.basic.framework.core.model.Money;
import com.dzjk.ams.core.common.enums.ResultEnum;
import com.dzjk.ams.core.common.enums.Status;
import com.dzjk.ams.core.common.enums.Switch;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.MoneyUtils;
import com.dzjk.ams.dal.dao.AccountBorrowDAO;
import com.dzjk.ams.dal.dataobject.*;
import com.dzjk.ams.endpoint.action.account.AccountFacadeRestImpl;
import com.dzjk.ams.endpoint.action.account.AccountPlatFacadeRestImpl;
import com.dzjk.ams.facade.form.account.CreateAccountReqForm;
import com.dzjk.ams.facade.model.CreateCusBaseInfoVo;
import com.dzjk.ams.facade.model.CreateLoanDetailInfoVo;
import com.dzjk.product.facade.ProductSelectedService;
import com.dzjk.product.model.QueryProductByConditionRequest;
import com.dzjk.product.model.base.DefaultResponse;
import com.dzjk.product.model.vo.*;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by daixiaohu on 2018/3/8.
 */
public class AccountMqListener implements UniformEventMessageListener {

    @Resource
    ProductSelectedService productSelectedService;
    @Resource
    AccountFacadeRestImpl repayPlan;
    @Resource
    AccountPlatFacadeRestImpl platEarnings;
    @Resource
    private AccountBorrowDAO accountBorrowDAO;

    private static final Logger logger = LoggerFactory.getLogger(AccountMqListener.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void onUniformEvent(UniformEvent message, UniformEventContext context) throws Exception {
        final String topic = message.getTopic();
        final String eventcode = message.getEventCode();
        final String id = message.getId();
        final Object businessObject = message.getEventPayload();
        logger.info("Receive a message, TOPIC [{}] EVENTCODE [{}] id [{}] payload [{}]", new Object[]{topic,
                eventcode, id, businessObject});
        CreateAccountReqForm reqForm = (CreateAccountReqForm) businessObject;
        CreateCusBaseInfoVo cusBaseInfo = reqForm.getCusBaseInfo();
        CreateLoanDetailInfoVo loanDetailInfo = reqForm.getLoanDetailInfo();
        try {
            boolean processSuccess = processMessage(businessObject);
            if (!processSuccess) {
                //如果失败，修改账务表状态失效。
                if (cusBaseInfo != null && loanDetailInfo != null) {
                    String userId = reqForm.getUserId();
                    String boId = loanDetailInfo.getBoId();
                    AccountBorrowDO entity = new AccountBorrowDO();
                    entity.setUserId(userId);
                    entity.setBoId(boId);
                    entity.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                    entity.setStatus(Status.Invalid.getCode());
                    accountBorrowDAO.updateStatus(entity);
                }
                context.setContextDesc("process error cause");
                context.setRollbackOnly();
            }

        } catch (CommonException e) {
            if (cusBaseInfo != null && loanDetailInfo != null) {
                String userId = reqForm.getUserId();
                String boId = loanDetailInfo.getBoId();
                AccountBorrowDO entity = new AccountBorrowDO();
                entity.setUserId(userId);
                entity.setBoId(boId);
                entity.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                entity.setStatus(Status.Invalid.getCode());
                accountBorrowDAO.updateStatus(entity);
            }
            logger.error("Process a message, failure.",e);
        } catch (Exception e) {
            if (cusBaseInfo != null && loanDetailInfo != null) {
                String userId = reqForm.getUserId();
                String boId = loanDetailInfo.getBoId();
                AccountBorrowDO entity = new AccountBorrowDO();
                entity.setUserId(userId);
                entity.setBoId(boId);
                entity.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                entity.setStatus(Status.Invalid.getCode());
                accountBorrowDAO.updateStatus(entity);
            }
            logger.error("Process a message, failure." ,e);
            throw e;
        }
    }

    @Transactional
    private boolean processMessage(Object businessObject) {
        CreateAccountReqForm reqForm = (CreateAccountReqForm) businessObject;
        CreateCusBaseInfoVo cusBaseInfo = reqForm.getCusBaseInfo();
        CreateLoanDetailInfoVo loanDetailInfo = reqForm.getLoanDetailInfo();
        String repayPeriod = loanDetailInfo.getRepayPeriod();
        Integer period = Integer.valueOf(repayPeriod);
        String orgId = cusBaseInfo.getOrgId();
        String userId = reqForm.getUserId();
        String boId = loanDetailInfo.getBoId();
        try {
            String repayDate = loanDetailInfo.getRepayDate();
            String lendDate = loanDetailInfo.getLendDate();
            BigDecimal lendAmount = loanDetailInfo.getLendAmount();
            String repayRate = loanDetailInfo.getRepayRate();//正常利率
            //调产品接口，查询产品费率
            String mapCode = loanDetailInfo.getProductCode();
            logger.info("开始查询产品。。。。。");
            DefaultResponse<QueryProductMapByCodeVo> response = productSelectedService.queryProductMapByCode(mapCode,repayPeriod);
            logger.info("产品" + mapCode + "返回费率response：" + response);
            QueryProductByConditionVo byConditionVo = null;
            List<ProductFeeRateVo> productFeeRateVos = null;
            String proOrgId = "";
            if (response != null) {
                if (!response.isSuccess()) {
                    throw new CommonException(ResultEnum.ProductInfoIsNull, ResultEnum.ProductInfoIsNull.getMsg());
                }
                QueryProductMapByCodeVo productResp = response.getData();
                if (productResp != null) {
                    byConditionVo = productResp.getIntProduct();
                    if (byConditionVo!=null&&byConditionVo.getProductConfig()!=null&&byConditionVo.getProductConfig().getConfig()!=null&&byConditionVo.getProductConfig().getConfig().size()!=0){
                        logger.info("资产产品" + mapCode + "返回费率IntProduct：" + byConditionVo);
                        ProductBasicConfigVo configVo = byConditionVo.getProductConfig();
                        List<ProductBasicConfigVo.Config> configList =  configVo.getConfig();
                        ProductBasicConfigVo.Config config =configList.get(0);
                        productFeeRateVos=  config.getFeeRate();
                        proOrgId = byConditionVo.getOrgId();
                        logger.info("资产产品" + mapCode + "返回费率data：" + productFeeRateVos);
                        logger.info("资产产品" + mapCode + "返回机构号：" + proOrgId);
                    }else {
                        throw new CommonException(ResultEnum.ProductInfoIsNull, mapCode + ResultEnum.ProductInfoIsNull.getMsg());
                    }
                } else {
                    throw new CommonException(ResultEnum.ProductInfoIsNull, mapCode + ResultEnum.ProductInfoIsNull.getMsg());
                }
            }
            if (!proOrgId.equals(orgId)) {
                throw new CommonException(ResultEnum.OrgIdNoEqual, "orgId" + ResultEnum.OrgIdNoEqual.getMsg());
            }
            BigDecimal serviceRate = new BigDecimal(0);
            String interestRate = "";//正常利率
            String platServiceRate = "";//平台费率
            String platFeeName = "";
            String platFeeType = "";
            if (StringUtils.isBlank(repayRate)) {
                for (ProductFeeRateVo vo : productFeeRateVos) {
                    if ("11001".equals(vo.getFeeRateType())) {//正常利率
                        interestRate = vo.getFeeRate();
                    }
                    if ("12004".equals(vo.getFeeRateType())) { //平台服务费
                        platServiceRate = vo.getFeeRate();
                        platFeeName = vo.getRemark();
                        platFeeType = vo.getFeeRateType();
                    }
                    if ("12".equals(vo.getFeeRateType().substring(0, 2))) {
                        if (StringUtils.isNotBlank(vo.getFeeRate())) {
                            serviceRate = serviceRate.add(new BigDecimal(vo.getFeeRate()));
                        }

                    }
                }
            } else {
                for (ProductFeeRateVo vo : productFeeRateVos) {
                    if ("11001".equals(vo.getFeeRateType())) {//正常利率
                        vo.setFeeRate(repayRate);
                    }
                    if ("12004".equals(vo.getFeeRateType())) { //平台服务费
                        platServiceRate = vo.getFeeRate();
                        platFeeName = vo.getRemark();
                        platFeeType = vo.getFeeRateType();
                    }
                    if ("12".equals(vo.getFeeRateType().substring(0, 2))) {
                        if (StringUtils.isNotBlank(vo.getFeeRate())) {
                            serviceRate = serviceRate.add(new BigDecimal(vo.getFeeRate()));
                        }
                    }
                }
                interestRate = repayRate;
            }

            String feeRates = JSON.toJSONString(productFeeRateVos);
            //更新账务表,存产品利率
            AccountBorrowDO borrowDO = new AccountBorrowDO();
            borrowDO.setUserId(userId);
            borrowDO.setBoId(boId);
            borrowDO.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
            borrowDO.setRepayRate(feeRates);//
            BigDecimal interestAdvance = new BigDecimal(0);
            BigDecimal totalServiceFee = new BigDecimal(0); //累计服务费
            BigDecimal totalCapital = new BigDecimal(0);//累计还本金
            for (int j = 1; j < period + 1; j++) {
                interestAdvance = interestAdvance.add(MoneyUtils.getPerInterest(lendAmount, interestRate, period, j));
                totalCapital = totalCapital.add(MoneyUtils.getPerAmount(lendAmount, period));
                totalServiceFee = totalServiceFee.add((lendAmount.subtract(totalCapital).add(MoneyUtils.getPerAmount(lendAmount, period))).multiply(serviceRate).setScale(2, BigDecimal.ROUND_UP));
            }
            borrowDO.setInterestAdvance(interestAdvance);
            borrowDO.setServiceFeeAccu(new BigDecimal(0));
            Long l = repayPlan.updateAccount(borrowDO);
            logger.info("更新账务表userId:" + userId + ";boId:" + boId + ";orgId:" + cusBaseInfo.getOrgId() + ";interestAdvance:" + interestAdvance + ";l:" + l);
            logger.info("更新账务表成功");
            Date currentDate = DateUtils.currentDateTime();
            for (int i = 1; i < period + 1; i++) {
                BigDecimal interestAmount = MoneyUtils.getPerInterest(lendAmount, interestRate, period, i); //当期应该利息
                BigDecimal capitalAmount = MoneyUtils.getPerAmount(lendAmount, period);//当期应还本金
                BigDecimal totalCapitalAccu = new BigDecimal(0);//累计还本金
                BigDecimal totalInterestAccu = new BigDecimal(0);//累计还利息
                BigDecimal totalServiceFeeAccu = new BigDecimal(0); //累计服务费
                BigDecimal platTotalServiceFeeAccu = new BigDecimal(0); //平台累计服务费
                for (int j = 1; j < i + 1; j++) {
                    totalCapitalAccu = totalCapitalAccu.add(MoneyUtils.getPerAmount(lendAmount, period));
                    totalInterestAccu = totalInterestAccu.add(MoneyUtils.getPerInterest(lendAmount, interestRate, period, j));
                    totalServiceFeeAccu = totalServiceFeeAccu.add((lendAmount.subtract(totalCapitalAccu).add(capitalAmount)).multiply(serviceRate).setScale(2, BigDecimal.ROUND_UP));
                    if (StringUtils.isNotBlank(platServiceRate)){
                        platTotalServiceFeeAccu = platTotalServiceFeeAccu.add((lendAmount.subtract(totalCapitalAccu).add(capitalAmount)).multiply(new BigDecimal(platServiceRate)).setScale(2, BigDecimal.ROUND_UP));
                    }
                }
                //截止当期剩余还款金额
                BigDecimal totalCapitalLeft = lendAmount.subtract(totalCapitalAccu).setScale(2, BigDecimal.ROUND_UP);
                BigDecimal serviceFee = (lendAmount.subtract(totalCapitalAccu).add(capitalAmount)).multiply(serviceRate).setScale(2, BigDecimal.ROUND_UP);
                //还款计划
                AccountRepayPlanDO planDO = new AccountRepayPlanDO();
                planDO.setUserId(userId);
                planDO.setBoId(boId);
                planDO.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                planDO.setStatus(Status.Valid.getCode());
                planDO.setPeriodNum(String.valueOf(i));
                planDO.setPunishFee(new BigDecimal(0));
                if (StringUtils.isBlank(repayDate)) {
                    Date repayDates = DateUtils.stringToDate(lendDate, DateUtils.SIMPLE_DATE_PATTERN);
                    planDO.setRepayDate(DateUtils.addMonths(repayDates, i));
                } else {
                    String repay = lendDate.substring(0, 8) + repayDate;
                    Date repayDates = DateUtils.stringToDate(repay, DateUtils.SIMPLE_DATE_PATTERN);
                    planDO.setRepayDate(DateUtils.addMonths(repayDates, i));
                }
                planDO.setServiceFee(serviceFee);
                planDO.setOverdueDay("0");
                planDO.setCreatedTime(currentDate);
                planDO.setRepayStatus("0");
                planDO.setInterestAccu(totalInterestAccu);
//        planDO.setReturnAmount();
                String serviceFeeId = CommonUtils.getUUID();
                planDO.setServiceFeeId(serviceFeeId);
                planDO.setCapitalAmount(capitalAmount);
                planDO.setInterestAmount(interestAmount);
                planDO.setPunishFeeAccu(new BigDecimal(0));
                planDO.setServiceFeeAccu(totalServiceFeeAccu);
                planDO.setTotalCapitalAccu(totalCapitalAccu);
                if (totalCapitalLeft.compareTo(new BigDecimal(0)) == -1) {
                    totalCapitalLeft = new BigDecimal(0);
                }
                planDO.setTotalCapitalLeft(totalCapitalLeft);
                planDO.setCreatedTime(DateUtils.currentDateTime());
                repayPlan.createRepayPlan(planDO);
                for (ProductFeeRateVo vo : productFeeRateVos) {
                    String feeRateType = vo.getFeeRateType();
                    if (StringUtils.isNotBlank(feeRateType)) {
                        if ("1".equals(feeRateType.substring(0, 1))) {
                            BigDecimal feeRate = new BigDecimal(vo.getFeeRate());
                            //计划收取服务费
                            AccountRepayServiceFeeDO repayServiceFeeDO = new AccountRepayServiceFeeDO();
                            repayServiceFeeDO.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                            repayServiceFeeDO.setStatus(Status.Valid.getCode());
                            repayServiceFeeDO.setFeeName(vo.getRemark());
                            repayServiceFeeDO.setFeeType(vo.getFeeRateType());
                            repayServiceFeeDO.setFeeAmount((totalCapitalLeft.add(capitalAmount)).multiply(feeRate).setScale(2, BigDecimal.ROUND_UP));
                            repayServiceFeeDO.setServiceFeeId(serviceFeeId);
                            repayServiceFeeDO.setCreatedTime(currentDate);
                            repayPlan.createRepayServiceFee(repayServiceFeeDO);
                        }
                        if ("2".equals(feeRateType.substring(0, 1))) {
                            AccountRepayServiceFeeDO repayServiceFeeDO = new AccountRepayServiceFeeDO();
                            repayServiceFeeDO.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                            repayServiceFeeDO.setStatus(Status.Valid.getCode());
                            repayServiceFeeDO.setFeeName(vo.getRemark());
                            repayServiceFeeDO.setFeeType(vo.getFeeRateType());
                            repayServiceFeeDO.setFeeAmount(new BigDecimal(0));
                            repayServiceFeeDO.setServiceFeeId(serviceFeeId);
                            repayServiceFeeDO.setCreatedTime(currentDate);
                            repayPlan.createRepayServiceFee(repayServiceFeeDO);
                        }
                    }
                }
                //平台收益
                AccountEarningsDO plat = new AccountEarningsDO();
                plat.setBoId(boId);
                plat.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                plat.setStatus(Status.Valid.getCode());
                plat.setBoUserId("");
                plat.setUserId(userId);
                plat.setPeriodNum(String.valueOf(i));
                plat.setIsFullFee("1");
                if (StringUtils.isBlank(repayDate)) {
                    Date repayDates = DateUtils.stringToDate(lendDate, DateUtils.SIMPLE_DATE_PATTERN);
                    plat.setRepayDate(DateUtils.addMonths(repayDates, i));
                } else {
                    String repay = lendDate.substring(0, 8) + repayDate;
                    Date repayDates = DateUtils.stringToDate(repay, DateUtils.SIMPLE_DATE_PATTERN);
                    plat.setRepayDate(DateUtils.addMonths(repayDates, i));
                }
                plat.setOverdueDay("0");
                plat.setRepayStatus("0");
                plat.setCapitalAmount(capitalAmount);
                plat.setInterestAmount(interestAmount);
                plat.setServiceFeeId(serviceFeeId);
                plat.setServiceFeeAccu(platTotalServiceFeeAccu);
                plat.setCreatedTime(currentDate);
                platEarnings.createPlatEarnings(plat);
//平台收益费
                AccountEarningsServiceFeeDO platFee = new AccountEarningsServiceFeeDO();
                platFee.setOrgId(Long.valueOf(cusBaseInfo.getOrgId()));
                platFee.setStatus(Status.Valid.getCode());
                platFee.setFeeName(platFeeName);
                platFee.setFeeType(platFeeType);
                platFee.setFeeAmount((totalCapitalLeft.add(capitalAmount)).multiply(new BigDecimal(platServiceRate)).setScale(2, BigDecimal.ROUND_UP));
                platFee.setServiceFeeId(serviceFeeId);
                platFee.setCreatedTime(currentDate);
                platEarnings.createPlatEarningsServiceFee(platFee);
            }
            logger.info("还款计划表，平台收益表，服务费表插入成功");
            return true;
        } catch (CommonException e) {
            AccountBorrowDO entity = new AccountBorrowDO();
            entity.setUserId(userId);
            entity.setBoId(boId);
            entity.setOrgId(Long.valueOf(orgId));
            entity.setStatus(Status.Invalid.getCode());
            accountBorrowDAO.updateStatus(entity);
            logger.error("Process a message, failure." , e);
        } catch (Exception e) {
            AccountBorrowDO entity = new AccountBorrowDO();
            entity.setUserId(userId);
            entity.setBoId(boId);
            entity.setOrgId(Long.valueOf(orgId));
            entity.setStatus(Status.Invalid.getCode());
            accountBorrowDAO.updateStatus(entity);
            logger.error("Process a message, failure." , e);
        }
        return true;
    }
}

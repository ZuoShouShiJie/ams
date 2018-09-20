package com.dzjk.ams.endpoint.action.account;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.fastjson.JSON;
import com.dzjk.ams.core.common.enums.*;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.MoneyUtils;
import com.dzjk.ams.dal.dao.*;
import com.dzjk.ams.dal.dataobject.*;
import com.dzjk.ams.dal.paging.QueryPlatEarningsPage;
import com.dzjk.ams.dal.paging.QueryRepayPlanPage;
import com.dzjk.ams.endpoint.doValidate.account.AccountDoValidate;
import com.dzjk.ams.endpoint.service.MqService;
import com.dzjk.ams.endpoint.share.converter.AccountConvert;
import com.dzjk.ams.facade.api.account.AccountRestFacade;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.Customer.CustomerInfoForm;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.facade.model.*;
import com.dzjk.product.facade.ProductSelectedService;
import com.dzjk.product.model.base.DefaultResponse;
import com.dzjk.product.model.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author climb.s
 * @date 2018/2/6 10:00
 */

public class AccountFacadeRestImpl implements AccountRestFacade {
    private static final Logger logger = LoggerFactory.getLogger(AccountFacadeRestImpl.class);
    @Value("${TOPIC}")
    private String TOPIC;
    @Value("${EVENTCODE}")
    private String EVENTCODE;
    @Resource
    private MqService mqService;
    @Resource
    private CustomerFacadeRestImpl customerFacadeRest;
    @Resource
    private CustomerInfoDAO customerInfoDAO;
    @Resource
    private AccountBorrowDAO accountBorrowDAO;
    @Resource
    private AccountRepayPlanDAO accountRepayPlanDAO;
    @Resource
    AccountRepayServiceFeeDAO accountRepayServiceFeeDAO;
    @Resource
    private AccountEarningsDAO accountEarningsDAO;
    @Resource
    private AccountEarningsServiceFeeDAO accountEarningsServiceFeeDAO;
    @Resource
    ProductSelectedService productSelectedService;
    @Resource
    private AccountRepaySerialDAO accountRepaySerialDAO;

    /**
     * 账务查询
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<List<QueryAccountRespForm>> queryAccount(QueryAccountReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("账务查询request:" + form);
        try {
            AccountDoValidate.queryAccount(form);
            List<QueryAccountRespForm> respList = null;
            if (StringUtils.isNotBlank(form.getUserId())) {
                CustomerInfoDO customerInfoDO = customerInfoDAO.queryCustomerInfoByUserId(form.getUserId());
                if (customerInfoDO != null) {
                    List<AccountBorrowDO> list = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), form.getUserId());
                    if (list != null && list.size() > 0) {
                        respList = AccountConvert.accountListreConverter(customerInfoDO, list);
                    }
                }
            } else {
                CustomerInfoDO customerInfoDO = customerInfoDAO.queryCustomerInfo(form.getIdNo(), form.getIdType(), form.getUserName());
                if (customerInfoDO != null) {
                    List<AccountBorrowDO> list = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), customerInfoDO.getUserId());
                    if (list != null && list.size() > 0) {
                        respList = AccountConvert.accountListreConverter(customerInfoDO, list);
                    }
                }
            }
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            data.setData(respList);
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("账务查询异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("账务查询异常", e);
        }
        logger.info("账务查询返回:" + data);
        return data;
    }

    /**
     * 还款计划查询
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<QueryRepayPlanRespForm> queryRepayPlan(QueryRepayPlanReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("还款计划查询request:" + form);
        QueryRepayPlanRespForm respForm = new QueryRepayPlanRespForm();
        try {
            AccountDoValidate.queryRepayPlan(form);
            Integer count = null;
            List<QueryRepayPlanVo> queryRepayPlanVoList = null;
            LoanDetailInfoVo loanDetailInfoVo = null;
            List<AccountRepayExDO> accountRepayPlanDOS = new ArrayList<>();
            CustomerInfoDO customerInfoDO = null;
            if (StringUtil.isNotBlank(form.getUserId())) {
                customerInfoDO = customerInfoDAO.queryCustomerInfoByUserId(form.getUserId());
                if (customerInfoDO != null) {
                    QueryRepayPlanPage planPage = new QueryRepayPlanPage();
                    planPage.setBoId(form.getBoId());
                    planPage.setUserId(form.getUserId());
                    planPage.setOrgId(Long.valueOf(form.getOrgId()));
                    planPage.setCurrPageNo(form.getPageNo());
                    planPage.setLimit(form.getPageRec());
                    QueryRepayPlanPage planPage1 = accountRepayPlanDAO.queryRepayPlanById(planPage);
                    if (planPage1 != null) {
                        accountRepayPlanDOS = planPage1.getDatas();
                        count = planPage1.getTotal();
                        if (accountRepayPlanDOS != null) {
                            for (AccountRepayExDO planDO : accountRepayPlanDOS) {
                                BigDecimal serviceFee = new BigDecimal(0);
                                List<AccountRepayServiceFeeDO> feeDOS = accountRepayServiceFeeDAO.getRepayFee(Long.valueOf(form.getOrgId()), null, planDO.getServiceFeeId());
                                for (AccountRepayServiceFeeDO feeDO : feeDOS) {
                                    if (feeDO.getFeeAmount() != null) {
                                        serviceFee = serviceFee.add(feeDO.getFeeAmount());
                                    }
                                }
                                planDO.setAllServiceFee(serviceFee);
                                planDO.setFeeList(feeDOS);
                            }
                            queryRepayPlanVoList = AccountConvert.repayPlanListConverter(accountRepayPlanDOS);
                        }
                        loanDetailInfoVo = AccountConvert.customerConverter(customerInfoDO, form, count);
                    }
                }
            } else {
                customerInfoDO = customerInfoDAO.queryCustomerInfo(form.getIdNo(), form.getIdType(), form.getUserName());
                if (customerInfoDO != null && customerInfoDO.getUserId() != null) {
                    QueryRepayPlanPage planPage = new QueryRepayPlanPage();
                    planPage.setBoId(form.getBoId());
                    planPage.setUserId(customerInfoDO.getUserId());
                    planPage.setOrgId(Long.valueOf(form.getOrgId()));
                    planPage.setCurrPageNo(form.getPageNo());
                    planPage.setLimit(form.getPageRec());
                    QueryRepayPlanPage planPage1 = accountRepayPlanDAO.queryRepayPlanById(planPage);
                    if (planPage1 != null) {
                        accountRepayPlanDOS = planPage1.getDatas();
                        count = planPage1.getTotal();
                        if (accountRepayPlanDOS != null) {
                            for (AccountRepayExDO planDO : accountRepayPlanDOS) {
                                BigDecimal serviceFee = new BigDecimal(0);
                                List<AccountRepayServiceFeeDO> feeDOS = accountRepayServiceFeeDAO.getRepayFee(Long.valueOf(form.getOrgId()), null, planDO.getServiceFeeId());
                                for (AccountRepayServiceFeeDO feeDO : feeDOS) {
                                    if (feeDO.getFeeAmount() != null) {
                                        serviceFee = serviceFee.add(feeDO.getFeeAmount());
                                    }
                                }
                                planDO.setAllServiceFee(serviceFee);
                                planDO.setFeeList(feeDOS);
                            }
                            queryRepayPlanVoList = AccountConvert.repayPlanListConverter(accountRepayPlanDOS);
                        }
                        loanDetailInfoVo = AccountConvert.customerConverter(customerInfoDO, form, count);
                    }
                }
            }
            respForm.setLoanDetailInfo(loanDetailInfoVo);
            respForm.setDetailList(queryRepayPlanVoList);
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            data.setData(respForm);
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("还款计划查询异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("还款计划查询异常", e);
        }
        logger.info("还款计划查询返回:" + data);
        return data;
    }

    /**
     * 平台收益查询
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<QueryPlatEarningsRespForm> queryPlatEarnings(QueryPlatEarningsReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("平台收益查询request:" + form);
        QueryPlatEarningsRespForm respForm = new QueryPlatEarningsRespForm();
        try {
            AccountDoValidate.queryPlatEarnings(form);

            Integer count = null;
            List<QueryPlatEarningsVo> queryRepayPlanVoList = null;
            List<AccountEarningsExDO> accountEarningsExDOS = new ArrayList<>();
            String orgId = form.getOrgId();
            Long orgIds = null;
            if (StringUtils.isNotBlank(orgId)) {
                orgIds = Long.valueOf(orgId);
            }
            if (StringUtil.isNotBlank(form.getUserId())) {
                QueryPlatEarningsPage page = new QueryPlatEarningsPage();
                page.setBoId(form.getBoId());
                page.setUserId(form.getUserId());
                page.setOrgId(orgIds);
                page.setStartDate(DateUtils.getDateStart(form.getStartDate()));
                page.setEndDate(DateUtils.getDateEnd(form.getEndDate()));
                page.setLimit(form.getPageRec());
                page.setCurrPageNo(form.getPageNo());
                QueryPlatEarningsPage respPage = accountEarningsDAO.queryPlatEarnings(page);
                if (respPage != null) {
                    accountEarningsExDOS = respPage.getDatas();
                    count = respPage.getTotal();
                    if (accountEarningsExDOS != null) {
                        for (AccountEarningsExDO exDO : accountEarningsExDOS) {//每期费用，详情
                            BigDecimal serviceFee = new BigDecimal(0);
                            List<AccountEarningsServiceFeeDO> platFee = accountEarningsServiceFeeDAO.getEarningsFee(null, exDO.getServiceFeeId());
                            for (AccountEarningsServiceFeeDO feeDO : platFee) {
                                if (feeDO.getFeeAmount() != null) {
                                    serviceFee = serviceFee.add(feeDO.getFeeAmount());
                                }
                            }
                            exDO.setServiceFee(serviceFee);
                            exDO.setFeeDOS(platFee);
                        }
                    }
                }
            } else if (StringUtil.isNotBlank(form.getIdNo())) {
                CustomerInfoDO customerInfoDO = customerInfoDAO.queryCustomerInfo(form.getIdNo(), form.getIdType(), null);
                if (customerInfoDO != null && customerInfoDO.getUserId() != null) {
                    QueryPlatEarningsPage page = new QueryPlatEarningsPage();
                    page.setBoId(form.getBoId());
                    page.setUserId(form.getUserId());
                    page.setOrgId(orgIds);
                    page.setStartDate(DateUtils.getDateStart(form.getStartDate()));
                    page.setEndDate(DateUtils.getDateEnd(form.getEndDate()));
                    page.setLimit(form.getPageRec());
                    page.setCurrPageNo(form.getPageNo());
                    QueryPlatEarningsPage respPage = accountEarningsDAO.queryPlatEarnings(page);
                    if (respPage != null) {
                        accountEarningsExDOS = respPage.getDatas();
                        count = respPage.getTotal();
                        if (accountEarningsExDOS != null) {
                            for (AccountEarningsExDO exDO : accountEarningsExDOS) {
                                BigDecimal serviceFee = new BigDecimal(0);
                                List<AccountEarningsServiceFeeDO> platFee = accountEarningsServiceFeeDAO.getEarningsFee(null, exDO.getServiceFeeId());
                                for (AccountEarningsServiceFeeDO feeDO : platFee) {
                                    if (feeDO.getFeeAmount() != null) {
                                        serviceFee = serviceFee.add(feeDO.getFeeAmount());
                                    }
                                }
                                exDO.setServiceFee(serviceFee);
                                exDO.setFeeDOS(platFee);
                            }
                        }
                    }
                }
            }
            queryRepayPlanVoList = AccountConvert.platEarningsListConverter(accountEarningsExDOS);

            respForm.setPageNo(form.getPageNo());
            respForm.setPageRec(form.getPageRec());
            respForm.setPageCount(count);
            respForm.setQueryPlatEarnings(queryRepayPlanVoList);
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            data.setData(respForm);

        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("平台收益查询异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("平台收益查询异常", e);
        }
        logger.info("平台收益查询返回:" + data);
        return data;
    }

    /**
     * 借款前账务试算
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<AccountTrialRespForm> accountTrial(AccountTrialReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("借款前账务试算request:" + form);
        AccountTrialRespForm respForm = new AccountTrialRespForm();
        try {
            AccountDoValidate.accountTrial(form);
//调产品接口，查询产品费率
            String interestFeeRate = "";//正常利率
            BigDecimal serviceFeeRate = new BigDecimal(0);//正常服务费
            String mapCode = form.getProductCode();
            String orgId = form.getOrgId();
            String repayPeriod = form.getRepayPeriod();
            DefaultResponse<QueryProductMapByCodeVo> response = productSelectedService.queryProductMapByCode(mapCode, repayPeriod);
            logger.info("产品" + mapCode + "返回费率response：" + response);
            QueryProductByConditionVo byConditionVo = null;
            List<ProductFeeRateVo> productFeeRateVos = null;
            TrialLoanDetailInfoVo loanDetailInfo = null;
            List<TrialDetailListVo> detailList = null;
            String proOrgId = "";
            if (response != null) {
                if (!response.isSuccess()) {
                    throw new CommonException(ResultEnum.ProductInfoError, ResultEnum.ProductInfoError.getMsg());
                }
                QueryProductMapByCodeVo productResp = response.getData();
                if (productResp != null) {
                    byConditionVo = productResp.getIntProduct();
                    if (byConditionVo != null && byConditionVo.getProductConfig() != null && byConditionVo.getProductConfig().getConfig() != null && byConditionVo.getProductConfig().getConfig().size() != 0) {
                        logger.info("资产产品" + mapCode + "返回费率IntProduct：" + byConditionVo);
                        ProductBasicConfigVo configVo = byConditionVo.getProductConfig();
                        List<ProductBasicConfigVo.Config> configList = configVo.getConfig();
                        ProductBasicConfigVo.Config config = configList.get(0);
                        productFeeRateVos = config.getFeeRate();
                        proOrgId = byConditionVo.getOrgId();
                        logger.info("资产产品" + mapCode + "返回费率data：" + productFeeRateVos);
                        logger.info("资产产品" + mapCode + "返回机构号：" + proOrgId);
                    } else {
                        throw new CommonException(ResultEnum.ProductInfoIsNull, mapCode + ResultEnum.ProductInfoIsNull.getMsg());
                    }
                } else {
                    throw new CommonException(ResultEnum.ProductInfoIsNull, mapCode + ResultEnum.ProductInfoIsNull.getMsg());
                }
            }
            if (!orgId.equals(proOrgId)) {
                throw new CommonException(ResultEnum.OrgIdNoEqual, "orgId" + ResultEnum.OrgIdNoEqual.getMsg());
            }
            for (ProductFeeRateVo vo : productFeeRateVos) {
                if ("11001".equals(vo.getFeeRateType())) {
                    interestFeeRate = vo.getFeeRate();
                }
                if ("12".equals(vo.getFeeRateType().substring(0, 2))) {
                    if (StringUtils.isNotBlank(vo.getFeeRate())) {
                        serviceFeeRate = serviceFeeRate.add(new BigDecimal(vo.getFeeRate()));
                    }
                }
            }
            if (StringUtils.isNotBlank(form.getRepayRate())) {//覆盖产品利率
                interestFeeRate = form.getRepayRate();
            }
            if (serviceFeeRate != null) {
                String serviceFeeRates = String.valueOf(serviceFeeRate);
                logger.info("interestFeeRate:" + interestFeeRate);
                logger.info("serviceFeeRates:" + serviceFeeRates);
                loanDetailInfo = AccountConvert.queryTrialLoanDetail(form, interestFeeRate, serviceFeeRates);
                detailList = AccountConvert.queryTrialDetailList(form, interestFeeRate, serviceFeeRates);
            }

            respForm.setLoanDetailInfo(loanDetailInfo);
            respForm.setDetailList(detailList);
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            data.setData(respForm);
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("借款前账务试算异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("借款前账务试算异常", e);
        }
        logger.info("借款前账务试算返回:" + data);
        return data;
    }

    /**
     * 审贷建账
     *
     * @param form
     * @return
     */

    @Override
    @Transactional
    public ResponseData<CreateAccountRespForm> createAccount(CreateAccountReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("审贷建账request:" + form);
        CreateAccountRespForm respForm = new CreateAccountRespForm();
        try {
            AccountDoValidate.createAccount(form);
            CustomerInfoForm customerInfoForm = new CustomerInfoForm();
            CreateCusBaseInfoVo createVo = form.getCusBaseInfo();
            customerInfoForm.setIdNo(createVo.getIdNo());
            customerInfoForm.setIdType(createVo.getIdType());
            CustomerInfoDO customerInfoDO = customerFacadeRest.queryCustomerInfoByIdNo(customerInfoForm);
            boolean success = false;
            //新客户；
            if (customerInfoDO == null) {
                String userId = CommonUtils.getUUID();
                customerInfoForm.setUserId(userId);
                customerInfoForm.setOrgId(createVo.getOrgId());
                customerInfoForm.setUserName(createVo.getUserName());
                customerInfoForm.setMobile(createVo.getMobile());
                //客户表插入一条记录
                customerFacadeRest.insertCustomerInfo(customerInfoForm);
                respForm.setUserId(userId);
                form.setUserId(userId);
                //客户表中存在该用户；
            } else {
                //更新客户信息
                CustomerInfoDO customerInfoDO1 = new CustomerInfoDO();
                customerInfoDO1.setUserName(createVo.getUserName());
                customerInfoDO1.setMobile(createVo.getMobile());
                customerInfoDO1.setUserId(customerInfoDO.getUserId());
                customerInfoDO1.setUpdatedTime(DateUtils.currentDateTime());
                Long l = customerInfoDAO.updateUserInfo(customerInfoDO1);
                logger.info("更新客户信息l:" + l);
                List<AccountBorrowDO> accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getCusBaseInfo().getOrgId()), form.getLoanDetailInfo().getBoId(), customerInfoDO.getUserId());
                //通过userId,boId查询账务表，如果存在，则报错；
                if (accountBorrowDOS != null && accountBorrowDOS.size() > 0) {
                    throw new CommonException(ResultEnum.ExistAccount, "boId" + ResultEnum.ExistAccount.getMsg());
                }
                //还款服务费表
                //平台收益表
                //平台收取服务费表
                respForm.setUserId(customerInfoDO.getUserId());
                form.setUserId(customerInfoDO.getUserId());
            }
            //插入账务表
            createAccountBorrow(form);
            //引入mq
            Object payload = form;
            logger.info("publish request 1." + payload.toString());
            success = mqService.publish(TOPIC, EVENTCODE, payload);
            logger.info("publish request 2." + payload.toString());
            if (success) {
                respForm.setBoId(form.getLoanDetailInfo().getBoId());
                data.setReturn_code(ResultEnum.SUCCESS.getCode());
                data.setReturn_msg("建账请求接收成功");
                data.setData(respForm);
            }
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("审贷建账异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("审贷建账异常", e);

        }
        logger.info("审贷建账返回:" + data);
        return data;
    }

    /**
     * 提前还款试算
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<PreRepayTryRespForm> preRepayTry(PreRepayTryReqForm form) {
        ResponseData data = new ResponseData();
        PreRepayTryRespForm respForm = new PreRepayTryRespForm();
        logger.info("提前还款试算request:" + form);
        try {
            AccountDoValidate.preRepayTry(form);
            CustomerInfoDO customerInfoDO = null;
            List<AccountBorrowDO> accountBorrowDOS = null;
            AccountBorrowDO borrowDO = null;
            if (StringUtil.isNotBlank(form.getUserId())) {
                accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), form.getUserId());
                customerInfoDO = customerInfoDAO.queryCustomerInfoByUserId(form.getUserId());
            } else if (StringUtil.isNotBlank(form.getIdNo())) {
                customerInfoDO = customerInfoDAO.queryCustomerInfo(form.getIdNo(), form.getIdType(), form.getUserName());
                if (customerInfoDO != null && customerInfoDO.getUserId() != null) {
                    accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), customerInfoDO.getUserId());
                }
            }
            if (customerInfoDO == null) {
                throw new CommonException(ResultEnum.CustomerNotExist, ResultEnum.CustomerNotExist.getMsg());
            }
            if (accountBorrowDOS != null && accountBorrowDOS.size() == 1) {
                form.setUserName(customerInfoDO.getUserName());
                form.setIdNo(customerInfoDO.getIdNo());
                form.setIdType(customerInfoDO.getIdType());
                form.setUserId(customerInfoDO.getUserId());
                borrowDO = accountBorrowDOS.get(0);
                if (borrowDO != null) {
                    String repayRate = borrowDO.getRepayRate();
                    List<ProductFeeRateVo> productFeeRateVos = JSON.parseArray(repayRate, ProductFeeRateVo.class);
                    for (ProductFeeRateVo vo : productFeeRateVos) {
                        if ("11001".equals(vo.getFeeRateType())) {
                            borrowDO.setRate(new BigDecimal(vo.getFeeRate()));//正常利率
                        }
                    }
                    BigDecimal preRepayFine = new BigDecimal(0);//逾期罚息
                    BigDecimal preRepayServiceFee0 = new BigDecimal(0);//逾期服务费
                    BigDecimal preRepayServiceFee2 = new BigDecimal(0);//还款技术服务费
                    BigDecimal preRepayServiceFee3 = new BigDecimal(0);//平台服务费
                    String overdueTimes = borrowDO.getOverdueTimes();
                    Integer overTimes = null;
                    if (StringUtils.isNotBlank(overdueTimes)) {
                        overTimes = Integer.valueOf(overdueTimes);
                    }
                    if (overTimes > 0) {
                        List<String> list = new ArrayList<>();
                        list.add(PlanRepayStatus.OVERDUE.getCode());
                        List<AccountRepayExDO> accountRepayExDOS = accountRepayPlanDAO.queryPreRepayTry(form.getBoId(), form.getUserId(), "21002", list);
                        for (AccountRepayExDO exDO : accountRepayExDOS) {
                            if (exDO.getAllServiceFee() != null) {
                                preRepayFine = preRepayFine.add(exDO.getAllServiceFee());
                            }
                        }
                        List<String> list0 = new ArrayList<>();
                        list0.add(PlanRepayStatus.OVERDUE.getCode());
                        List<AccountRepayExDO> preRepayServiceFee0List = accountRepayPlanDAO.queryPreRepayTry(form.getBoId(), form.getUserId(), "22005", list0);
                        for (AccountRepayExDO exDO : preRepayServiceFee0List) {
                            if (exDO.getAllServiceFee() != null) {
                                preRepayServiceFee0 = preRepayServiceFee0.add(exDO.getAllServiceFee());//逾期服务费
                            }
                        }
                    }
                    List<String> list3 = new ArrayList<>();
                    list3.add(PlanRepayStatus.UNDUE.getCode());
                    list3.add(PlanRepayStatus.OVERDUE.getCode());
                    list3.add(PlanRepayStatus.BAD_ACCOUNT.getCode());
                    list3.add(PlanRepayStatus.WITHHOLDING.getCode());
                    List<AccountRepayExDO> preRepayServiceFee3List = accountRepayPlanDAO.queryPreRepayTry(form.getBoId(), form.getUserId(), "12004", list3);
                    for (AccountRepayExDO exDO : preRepayServiceFee3List) {
                        if (exDO.getAllServiceFee() != null) {
                            preRepayServiceFee3 = preRepayServiceFee3.add(exDO.getAllServiceFee());//截止申请提前还款日需提前还款平台服务费
                        }
                    }
                    List<AccountRepayExDO> preRepayServiceFee2List = accountRepayPlanDAO.queryPreRepayTry(form.getBoId(), form.getUserId(), "12003", list3);
                    for (AccountRepayExDO exDO : preRepayServiceFee2List) {
                        if (exDO.getAllServiceFee() != null) {
                            preRepayServiceFee2 = preRepayServiceFee2.add(exDO.getAllServiceFee());//截止申请提前还款日需提前还款技术服务费
                        }
                    }
                    respForm = AccountConvert.getPreRepayTry(form, borrowDO, preRepayFine, preRepayServiceFee0, preRepayServiceFee2, preRepayServiceFee3);
                }
            } else {
                throw new CommonException(ResultEnum.NoExistAccount, ResultEnum.NoExistAccount.getMsg());
            }
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            data.setData(respForm);
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("提前还款试算异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("提前还款试算异常", e);
        }
        logger.info("提前还款试算返回:" + data);
        return data;
    }

    /**
     * 还款交易
     *
     * @param form
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseData<Object> manualRepay(ManualRepayReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("还款交易request:" + form);
        try {
            AccountDoValidate.manualRepay(form);
            BigDecimal repayAmount = form.getPreRepayAmount();//还款金额
            PreRepayTryReqForm tryReqForm = AccountConvert.reqManualRepay(form);
            ResponseData<PreRepayTryRespForm> tryRespFormResponseData = preRepayTry(tryReqForm);
            if (ResultEnum.SUCCESS.getCode().equals(tryRespFormResponseData.getReturn_code())) {
                PreRepayTryRespForm respForm = tryRespFormResponseData.getData();
                BigDecimal preRepayAmount = respForm.getPreRepayAmount();//提前应还总金额
                //还款金额必须等于应还总金额
                if (repayAmount.compareTo(preRepayAmount) != 0) {
                    data.setData(false);
                } else {
                    data.setData(true);
                }
                data.setReturn_code(ResultEnum.SUCCESS.getCode());
                data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            } else {
                data.setReturn_code(tryRespFormResponseData.getReturn_code());
                data.setReturn_msg(tryRespFormResponseData.getReturn_msg());
            }
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("还款交易异常", e);
        } catch (Exception e) {

            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("还款交易异常", e);
            throw new RuntimeException();

        }
        logger.info("还款交易返回:" + data);
        return data;
    }


    /**
     * 账务变更
     *
     * @param form
     * @return
     */
    @Override
    @Transactional
    public ResponseData<AccountUpdateRespForm> accountUpdate(AccountUpdateReqForm form) {
        AccountUpdateRespForm form1 = new AccountUpdateRespForm();
        ResponseData data = new ResponseData();
        long l = 0;
        logger.info("账务变更request:" + form);
        try {
            AccountDoValidate.accountUpdate(form);
         /*   CustomerInfoDO customerInfoDO = accountQueryCusto(form);
            if (customerInfoDO == null) {
                throw new CommonException(ResultEnum.CustomerNotExist, form.getUserId() + form.getUserName() + ResultEnum.CustomerNotExist.getMsg());
            }*/
//            String userId = customerInfoDO.getUserId();
            String applyType = form.getApplyUpdateType();
            //借款人全额提前还款账务结清
            if ("1".equals(applyType)) {
//借款账务表，还款计划表，还款计划服务费表，平台收益表，收益服务费表
                //更新账务表
                AccountBorrowDO borrowDO = new AccountBorrowDO();
//                borrowDO.setUserId(customerInfoDO.getUserId());
                borrowDO.setBoId(form.getBoId());
                borrowDO.setOrgId(Long.valueOf(form.getOrgId()));
                borrowDO.setRepayStatus(AccountRepayStatus.PREALL_REPAY.getCode());//提前全部还款
                accountBorrowDAO.updateRepayStatus(borrowDO);
                String repayPeriod = "";
                Integer period = null;
                List<AccountBorrowDO> accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), null);
                if (accountBorrowDOS != null && accountBorrowDOS.size() > 0) {
                    AccountBorrowDO accountBorrowDO = accountBorrowDOS.get(0);
                    repayPeriod = accountBorrowDO.getRepayPeriod();
                }
                if (StringUtils.isNotBlank(repayPeriod)) {
                    period = Integer.valueOf(repayPeriod);
                }
                //更新还款计划表：还款状态
                for (int i = 1; i < period + 1; i++) {
                    AccountRepayPlanDO planDO = new AccountRepayPlanDO();
//                    planDO.setUserId(customerInfoDO.getUserId());
                    planDO.setBoId(form.getBoId());
                    planDO.setOrgId(Long.valueOf(form.getOrgId()));
                    planDO.setPeriodNum(String.valueOf(i));
                    AccountRepayExDO accountRepayExDO = accountRepayPlanDAO.queryRepayStatus(planDO);
                    if (accountRepayExDO != null && "0".equals(accountRepayExDO.getRepayStatus())) {
                        planDO.setRepayStatus(PlanRepayStatus.PREREPAY_PAYED.getCode());//提前还款结清
                        planDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountRepayPlanDAO.updateStatus(planDO);
                    } else if (accountRepayExDO != null && "1".equals(accountRepayExDO.getRepayStatus())) {
                        planDO.setRepayStatus(PlanRepayStatus.OVERREPAY_PAYED.getCode());//逾期还款结清
                        planDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountRepayPlanDAO.updateStatus(planDO);
                    }
                }
                //更新平台盈利表：还款状态
                for (int i = 1; i < period + 1; i++) {
                    AccountEarningsDO accountEarningsDO = new AccountEarningsDO();
//                    accountEarningsDO.setUserId(customerInfoDO.getUserId());
                    accountEarningsDO.setBoId(form.getBoId());
                    accountEarningsDO.setOrgId(Long.valueOf(form.getOrgId()));
                    accountEarningsDO.setPeriodNum(String.valueOf(i));
                    AccountEarningsExDO accountEarningsExDO = accountEarningsDAO.queryRepayStatus(accountEarningsDO);
                    if (accountEarningsExDO != null && "0".equals(accountEarningsExDO.getRepayStatus())) {
                        accountEarningsDO.setRepayStatus(PlanRepayStatus.PREREPAY_PAYED.getCode());//提前还款结清
                        accountEarningsDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountEarningsDAO.updateStatus(accountEarningsDO);
                    } else if (accountEarningsExDO != null && "1".equals(accountEarningsExDO.getRepayStatus())) {
                        accountEarningsDO.setRepayStatus(PlanRepayStatus.OVERREPAY_PAYED.getCode());//逾期还款结清
                        accountEarningsDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountEarningsDAO.updateStatus(accountEarningsDO);
                    }
                }

                //账务流水表
                AccountRepaySerialDO serialDO = new AccountRepaySerialDO();
                accountRepaySerialDAO.insert(serialDO);
                //正常代扣
            } else if ("7".equals(applyType)) {
                AccountRepayExDO accountRepayExDO = null;
                AccountEarningsExDO accountEarningsExDO = null;
                AccountRepayPlanDO planDO = new AccountRepayPlanDO();
//                planDO.setUserId(customerInfoDO.getUserId());
                planDO.setBoId(form.getBoId());
                planDO.setOrgId(Long.valueOf(form.getOrgId()));
                planDO.setPeriodNum(form.getPeriodNum());
                accountRepayExDO = accountRepayPlanDAO.queryRepayStatus(planDO);
                AccountRepaySerialDO serialDO = new AccountRepaySerialDO();
                serialDO.setBoId(form.getBoId());
                serialDO.setPeriodNum(form.getPeriodNum());
                serialDO.setCreatedTime(DateUtils.currentDateTime());
                serialDO.setOrgId(Long.valueOf(form.getOrgId()));
                serialDO.setRepayStatus(form.getRetCode());
                serialDO.setRepayType("7");
                serialDO.setStatus("0");
                serialDO.setRepayAmount(form.getPayAmt());
                if (accountRepayExDO == null) {
                    //账务流水表
                    serialDO.setRemark(ResultEnum.UpdateAcctFail.getMsg());
                    accountRepaySerialDAO.insert(serialDO);
                    data.setReturn_code(ResultEnum.UpdateAcctFail.getCode());
                    data.setReturn_msg(ResultEnum.UpdateAcctFail.getMsg());
                    form1.setUpdateStatus(0);
                    data.setData(form1);
                    logger.info("账务变更返回:" + data);
                    return data;
                }
                if ("2".equals(accountRepayExDO.getRepayStatus())) {
                    serialDO.setRemark(ResultEnum.CantRepeatUpdate.getMsg());
                    accountRepaySerialDAO.insert(serialDO);
                    data.setReturn_code(ResultEnum.CantRepeatUpdate.getCode());
                    data.setReturn_msg(ResultEnum.CantRepeatUpdate.getMsg());
                    form1.setUpdateStatus(0);
                    data.setData(form1);
                    logger.info("账务变更返回:" + data);
                    return data;
                }
                if ("4".equals(accountRepayExDO.getRepayStatus())) {
                    serialDO.setRemark(ResultEnum.CantRepeatUpdate.getMsg());
                    accountRepaySerialDAO.insert(serialDO);
                    data.setReturn_code(ResultEnum.CantRepeatUpdate.getCode());
                    data.setReturn_msg(ResultEnum.CantRepeatUpdate.getMsg());
                    form1.setUpdateStatus(0);
                    data.setData(form1);
                    logger.info("账务变更返回:" + data);
                    return data;
                }
                AccountEarningsDO accountEarningsDO = new AccountEarningsDO();
//                accountEarningsDO.setUserId(customerInfoDO.getUserId());
                accountEarningsDO.setBoId(form.getBoId());
                accountEarningsDO.setOrgId(Long.valueOf(form.getOrgId()));
                accountEarningsDO.setPeriodNum(form.getPeriodNum());
                accountEarningsExDO = accountEarningsDAO.queryRepayStatus(accountEarningsDO);

                List<AccountBorrowDO> accountBorrowDOS = null;
                //扣款成功处理，
                if ("1".equals(form.getRetCode())) {
                    //更新还款计划表
                    if (Integer.valueOf(accountRepayExDO.getOverdueDay()) == 0) {
                        planDO.setRepayStatus(PlanRepayStatus.NORMAL_REPAY_PAYED.getCode());//正常还款结清
                        planDO.setUpdatedTime(DateUtils.currentDateTime());
                        planDO.setRealRepayDate(accountRepayExDO.getRepayDate());
                        l = accountRepayPlanDAO.updatePlanInfo(planDO);
                    } else if (Integer.valueOf(accountRepayExDO.getOverdueDay()) > 0) {
                        planDO.setRepayStatus(PlanRepayStatus.OVERREPAY_PAYED.getCode());//逾期还款结清
                        planDO.setUpdatedTime(DateUtils.currentDateTime());
                        planDO.setRealRepayDate(accountRepayExDO.getRepayDate());
                        l = accountRepayPlanDAO.updatePlanInfo(planDO);
                    }

                    logger.info("l结果为：" + l);
                    //更新平台收益表
                    if (accountEarningsExDO != null && Integer.valueOf(accountRepayExDO.getOverdueDay()) == 0) {
                        accountEarningsDO.setRepayStatus(PlanRepayStatus.NORMAL_REPAY_PAYED.getCode());//正常还款结清
                        accountEarningsDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountEarningsDO.setRealRepayDate(accountEarningsExDO.getRepayDate());
                        accountEarningsDAO.updatePlanInfo(accountEarningsDO);
                    } else if (accountEarningsExDO != null && Integer.valueOf(accountRepayExDO.getOverdueDay()) > 0) {
                        accountEarningsDO.setRepayStatus(PlanRepayStatus.OVERREPAY_PAYED.getCode());//逾期还款结清
                        accountEarningsDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountEarningsDO.setRealRepayDate(accountEarningsExDO.getRepayDate());
                        accountEarningsDAO.updatePlanInfo(accountEarningsDO);
                    }
                    accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), null);
                    if (accountBorrowDOS != null && accountBorrowDOS.size() > 0) {
                        AccountBorrowDO borrowDO = accountBorrowDOS.get(0);
                        //next_repay_date,total_capital_left,total_capital_accu,interest_accu,service_fee_accu,punish_fee_accu,overdue_times
                        Date lastRepayDate = borrowDO.getLastRepayDate();
                        Date nextRepayDate = DateUtils.addMonths(accountRepayExDO.getRepayDate(), 1);//
                        BigDecimal totalCapitalLeft = borrowDO.getTotalCapitalLeft().subtract(accountRepayExDO.getCapitalAmount());
                        BigDecimal totalCapitalAccu = borrowDO.getTotalCapitalAccu().add(accountRepayExDO.getCapitalAmount());
                        BigDecimal interestAccu = borrowDO.getInterestAccu().add(accountRepayExDO.getInterestAmount());
                        BigDecimal serviceFeeAccu = accountRepayExDO.getServiceFeeAccu();
                        BigDecimal punishFeeAccu = accountRepayExDO.getPunishFeeAccu();
                        Date updatedTime = DateUtils.currentDateTime();
                        AccountBorrowDO borrowDO1 = new AccountBorrowDO();
                        borrowDO1.setTotalCapitalLeft(totalCapitalLeft);
                        borrowDO1.setTotalCapitalAccu(totalCapitalAccu);
                        borrowDO1.setInterestAccu(interestAccu);
                        borrowDO1.setServiceFeeAccu(serviceFeeAccu);
                        borrowDO1.setPunishFeeAccu(punishFeeAccu);
                        if (nextRepayDate.getTime() <= lastRepayDate.getTime()) {
                            borrowDO1.setNextRepayDate(nextRepayDate);
                        } else {
                            borrowDO1.setNextRepayDate(null);
                        }
                        borrowDO1.setUpdatedTime(updatedTime);
                        borrowDO1.setOrgId(Long.valueOf(form.getOrgId()));
                        borrowDO1.setBoId(form.getBoId());
                        accountBorrowDAO.updateBorrowSuccess(borrowDO1);
                        //账务流水表
                        serialDO.setUserId(borrowDO.getUserId());
                        serialDO.setRepayTime(accountRepayExDO.getRepayDate());
                        serialDO.setCapitalAmount(accountRepayExDO.getCapitalAmount());
                        serialDO.setInterestAmount(accountRepayExDO.getInterestAmount());
                        serialDO.setStatus("1");
                        accountRepaySerialDAO.insert(serialDO);
                    }

                    //扣款失败处理，
                } else {
                    //更新还款计划表
                    if (accountRepayExDO != null) {
                        planDO.setRepayStatus(PlanRepayStatus.OVERDUE.getCode());//已逾期
                        planDO.setUpdatedTime(DateUtils.currentDateTime());
                        String overdueDay = String.valueOf(Integer.valueOf(accountRepayExDO.getOverdueDay()) + 1);
                        planDO.setOverdueDay(overdueDay);
                        l = accountRepayPlanDAO.updatePlanFail(planDO);
                        accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), null);
                        if (accountBorrowDOS != null && accountBorrowDOS.size() > 0) {
                            AccountBorrowDO borrowDO = accountBorrowDOS.get(0);
                            //next_repay_date,total_capital_left,total_capital_accu,interest_accu,service_fee_accu,punish_fee_accu,overdue_times
                            String overdueTimes = String.valueOf(Integer.valueOf(borrowDO.getOverdueTimes()) + 1);//
                            Date updatedTime = DateUtils.currentDateTime();
                            AccountBorrowDO borrowDO1 = new AccountBorrowDO();
                            borrowDO1.setRepayStatus(RepayStatus.OVERDUE.getCode());
                            borrowDO1.setOverdueTimes(overdueTimes);
                            borrowDO1.setUpdatedTime(updatedTime);
                            borrowDO1.setOrgId(Long.valueOf(form.getOrgId()));
                            borrowDO1.setBoId(form.getBoId());
                            accountBorrowDAO.updateBorrowFail(borrowDO1);

                            //账务流水表
                            serialDO.setUserId(borrowDO.getUserId());
                            serialDO.setCapitalAmount(accountRepayExDO.getCapitalAmount());
                            serialDO.setInterestAmount(accountRepayExDO.getInterestAmount());
                            serialDO.setStatus("1");
                            accountRepaySerialDAO.insert(serialDO);
                        }
                    }
                    //更新平台收益表
                    if (accountEarningsExDO != null) {
                        accountEarningsDO.setRepayStatus(PlanRepayStatus.OVERDUE.getCode());//已逾期
                        accountEarningsDO.setUpdatedTime(DateUtils.currentDateTime());
                        accountEarningsDO.setOverdueDay(String.valueOf(Integer.valueOf(accountEarningsExDO.getOverdueDay()) + 1));
                        accountEarningsDAO.updatePlanFail(accountEarningsDO);
                    }
                }
            }
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
            form1.setUpdateStatus(l);
            data.setData(form1);
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("账务变更异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("账务变更异常", e);

        }
        logger.info("账务变更返回:" + data);
        return data;
    }

    /**
     * 查询建账是否成功
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<Object> queryAccountStatus(QueryAccountStatusReqForm form) {
        ResponseData data = new ResponseData();
        logger.info(" 查询建账情况request:" + form);
        try {
            AccountDoValidate.queryAccountStatus(form);
            AccountUpdateReqForm reqForm = new AccountUpdateReqForm();
            reqForm.setUserId(form.getUserId());
            reqForm.setIdNo(form.getIdNo());
            reqForm.setIdType(form.getIdType());
            reqForm.setUserName(form.getUserName());
            CustomerInfoDO customerInfoDO = accountQueryCusto(reqForm);
            if (customerInfoDO == null) {
                throw new CommonException(ResultEnum.CustomerNotExist, ResultEnum.CustomerNotExist.getMsg());
            }
            List<AccountBorrowDO> accountBorrowDOS = accountBorrowDAO.queryAccountInfo(Long.valueOf(form.getOrgId()), form.getBoId(), customerInfoDO.getUserId());
            if (accountBorrowDOS != null && accountBorrowDOS.size() > 0) {
                data.setData(true);
            } else {
                data.setData(false);
            }
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("查询建账情况异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("查询建账情况异常", e);
        }
        logger.info("查询建账情况返回:" + data);
        return data;
    }

    /**
     * 资金端成本试算查询
     *
     * @param form
     * @return
     */
    @Override
    public ResponseData<AccountTrialRespForm> capitalCostTrial(CapitalCostTrialReqForm form) {
        ResponseData data = new ResponseData();
        logger.info("资金端成本试算查询request:" + form);
        try {
            CapitalCostTrialRespForm respForm = new CapitalCostTrialRespForm();
            AccountDoValidate.capitalCostTrial(form);
            BigDecimal amount = new BigDecimal(form.getAmount());
            Integer period = Integer.valueOf(form.getPeriod());
            String type = form.getType();
            String price = form.getPrice();
            BigDecimal totalInterestAccu = new BigDecimal(0);

//等额本息
            if (RepayModeEnum.ACPI.getCode().equals(type)) {
                totalInterestAccu = MoneyUtils.getAllMonthInterest(amount, Double.valueOf(price), period);
//等额本金
            } else if (RepayModeEnum.AP.getCode().equals(type)) {
                for (int i = 1; i < period + 1; i++) {
                    totalInterestAccu = totalInterestAccu.add(MoneyUtils.getPerInterest(amount, price, period, i));
                }
            }
            respForm.setFeeAmount(String.valueOf(totalInterestAccu));
            data.setData(respForm);
            data.setReturn_code(ResultEnum.SUCCESS.getCode());
            data.setReturn_msg(ResultEnum.SUCCESS.getMsg());
        } catch (CommonException e) {
            data.setReturn_code(e.getCode());
            data.setReturn_msg(e.getMessage());
            logger.error("资金端成本试算查询异常", e);
        } catch (Exception e) {
            data.setReturn_code(ResultEnum.UNKONW_ERROR.getCode());
            data.setReturn_msg(ResultEnum.UNKONW_ERROR.getMsg());
            logger.error("资金端成本试算查询异常", e);
        }
        logger.info("资金端成本试算查询返回:" + data);
        return data;
    }

    public CustomerInfoDO accountQueryCusto(AccountUpdateReqForm form) {
        CustomerInfoDO customerInfoDO = null;
        if (StringUtils.isNotBlank(form.getUserId())) {
            CustomerInfoForm customerInfoForm = new CustomerInfoForm();
            customerInfoForm.setUserId(form.getUserId());
            customerInfoDO = customerFacadeRest.queryCustomerInfoByUserId(customerInfoForm);
        } else {
            CustomerInfoForm customerInfoForm = new CustomerInfoForm();
            customerInfoForm.setIdNo(form.getIdNo());
            customerInfoForm.setIdType(form.getIdType());
            customerInfoForm.setUserName(form.getUserName());
            customerInfoDO = customerFacadeRest.queryCustomerInfo(customerInfoForm);
        }
        logger.info("客户信息：" + customerInfoDO);
        return customerInfoDO;
    }


    /**
     * 账务表插入
     *
     * @return
     */

    public Long createAccountBorrow(CreateAccountReqForm form) throws ParseException {
        CreateLoanDetailInfoVo loan = form.getLoanDetailInfo();
        String lendDate = loan.getLendDate();//实际放款日
        String lendTime = loan.getLendTime();
        String repayPeriod = loan.getRepayPeriod();//还款期数
        AccountBorrowDO borrowDO = new AccountBorrowDO();
        borrowDO.setBoId(loan.getBoId());
        borrowDO.setUserId(form.getUserId());
        borrowDO.setOrgId(Long.valueOf(form.getCusBaseInfo().getOrgId()));
        borrowDO.setStatus("1");
        borrowDO.setBrUserId("");
        if (StringUtils.isNotBlank(loan.getApplyTime())) {
            borrowDO.setApplyTime(DateUtils.parseDatetime(loan.getApplyTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN));
        }
        if (StringUtils.isBlank(loan.getRepayDate())) {
            borrowDO.setRepayDate(String.valueOf(DateUtils.stringToDate(lendDate, DateUtils.SIMPLE_DATE_PATTERN).getDate()));
        } else {
            borrowDO.setRepayDate(loan.getRepayDate());//
        }
        if (StringUtils.isNotBlank(loan.getApplyTime())) {
            borrowDO.setApproveTime(DateUtils.parseDatetime(loan.getApplyTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN));
        }
        if (StringUtils.isNotBlank(loan.getApplyDate())) {
            borrowDO.setApproveDate(DateUtils.parseDatetime(loan.getApplyDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        borrowDO.setLoanAmount(loan.getLoanAmount());
        borrowDO.setLendAmount(loan.getLendAmount());
        borrowDO.setProductCode(loan.getProductCode());
        borrowDO.setRepayPeriod(loan.getRepayPeriod());
        borrowDO.setCapitalAmount(loan.getLendAmount());//本金金额
        if (StringUtils.isNotBlank(lendDate)) {
            Date lendDates = DateUtils.parseDatetime(lendDate, DateUtils.SIMPLE_DATE_PATTERN);
            borrowDO.setLendDate(lendDates);
            borrowDO.setFirstRepayDate(DateUtils.addMonths(lendDates, 1));
            borrowDO.setNextRepayDate(DateUtils.addMonths(lendDates, 1));
            borrowDO.setLastRepayDate(DateUtils.addMonths(lendDates, Integer.valueOf(repayPeriod)));
        }
        if (StringUtils.isNotBlank(lendTime)) {
            borrowDO.setLendTime(DateUtils.parseDatetime(lendTime, DateUtils.SIMPLE_DATE_HOURS_PATTERN));
        }
//        borrowDO.setNextRepayDate();
        borrowDO.setRepayAccountName(loan.getRepayAcctName());
        borrowDO.setRepayAcctBank(loan.getRepayAcctBank());
        borrowDO.setRepayAccountNo(loan.getRepayAcctNo());
        borrowDO.setRepayAcctPhone(loan.getRepayAcctPhone());
        borrowDO.setRepayType("1");
        borrowDO.setRateType("2");
        borrowDO.setRepayStatus(AccountRepayStatus.NORMAL.getCode());
        borrowDO.setTotalCapitalLeft(loan.getLendAmount());
        borrowDO.setTotalCapitalAccu(new BigDecimal(0));
        borrowDO.setInterestAccu(new BigDecimal(0));
        borrowDO.setServiceFeeAccu(new BigDecimal(0));
        borrowDO.setPunishFeeAccu(new BigDecimal(0));
        borrowDO.setCapitalAdvance(loan.getLendAmount());
        borrowDO.setOverdueTimes("0");
        borrowDO.setCreatedTime(DateUtils.currentDateTime());
        return accountBorrowDAO.insert(borrowDO);
    }


    /**
     * 更新账务表
     *
     * @param
     * @return
     */
    public Long updateAccount(AccountBorrowDO borrowDO) {
        return accountBorrowDAO.updateRepayRate(borrowDO);
    }

    /**
     * 还款计划表插入
     *
     * @return
     */
    public Long createRepayPlan(AccountRepayPlanDO repayPlanDO) {
        return accountRepayPlanDAO.insert(repayPlanDO);
    }

    /**
     * 还款计划服务费表插入
     *
     * @return
     */
    public Long createRepayServiceFee(AccountRepayServiceFeeDO repayServiceFeeDO) {
        return accountRepayServiceFeeDAO.insert(repayServiceFeeDO);
    }


}

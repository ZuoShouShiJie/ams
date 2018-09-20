package com.dzjk.ams.endpoint.share.converter;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.basic.framework.core.model.Money;
import com.dzjk.ams.core.common.enums.ResultEnum;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.MoneyUtils;
import com.dzjk.ams.dal.dataobject.*;
import com.dzjk.ams.endpoint.action.account.AccountFacadeRestImpl;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.facade.model.*;
import com.sun.jdi.DoubleValue;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daixiaohu on 2018/2/26.
 */
public class AccountConvert {
    private static final Logger logger = LoggerFactory.getLogger(AccountFacadeRestImpl.class);

    public static List<QueryAccountRespForm> accountListreConverter(CustomerInfoDO customerInfoDO, List<AccountBorrowDO> list) {
        List<QueryAccountRespForm> listResp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listResp.add(accountreConverter(customerInfoDO, list.get(i)));
        }
        return listResp;
    }

    public static QueryAccountRespForm accountreConverter(CustomerInfoDO customerInfoDO, AccountBorrowDO borrowDO) {
        QueryAccountRespForm form = new QueryAccountRespForm();
        form.setUserName(customerInfoDO.getUserName());
        form.setIdType(customerInfoDO.getIdType());
        form.setIdNo(customerInfoDO.getIdNo());
        form.setBoId(borrowDO.getBoId());
        form.setOrgId(borrowDO.getOrgId() == null ? "" : borrowDO.getOrgId().toString());
        form.setBoId(borrowDO.getBoId());
        form.setTotalCapital(borrowDO.getLendAmount());
        form.setTotalInterest(borrowDO.getInterestAdvance());
        form.setTotalServiceFee(borrowDO.getServiceFeeAccu());
        form.setTotalFine(borrowDO.getPunishFeeAccu());
        form.setRepayDate(borrowDO.getRepayDate());
        form.setRepayPeriod(borrowDO.getRepayPeriod());
        if (borrowDO.getFirstRepayDate() != null) {
            form.setFirstRepayDate(DateUtils.dateToString(borrowDO.getFirstRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        if (borrowDO.getLastRepayDate() != null) {
            form.setLastRepayDate(DateUtils.dateToString(borrowDO.getLastRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        if (borrowDO.getNextRepayDate() != null) {
            form.setNextRepayDate(DateUtils.dateToString(borrowDO.getNextRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        form.setRepayStatus(borrowDO.getRepayStatus());
        form.setOverdueTimes(borrowDO.getOverdueTimes());
        form.setMaxOverdueDay(borrowDO.getMaxOverdueDay());
        form.setCurrOverdueDay(borrowDO.getCurrOverdueDay());
        return form;
    }


    public static List<QueryRepayPlanVo> repayPlanListConverter(List<AccountRepayExDO> list) {
        List<QueryRepayPlanVo> listResp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listResp.add(repayPlanVoConverter(list.get(i)));
        }
        return listResp;
    }

    public static QueryRepayPlanVo repayPlanVoConverter(AccountRepayExDO borrowDO) {
        QueryRepayPlanVo form = new QueryRepayPlanVo();
        List<AccountRepayServiceFeeDO> feeList = borrowDO.getFeeList();
        List<FeeVo> feeVos = new ArrayList<>();
        for (AccountRepayServiceFeeDO exDO : feeList) {
            FeeVo vo = new FeeVo();
            vo.setFeeName(exDO.getFeeName());
            vo.setFeeAmount(exDO.getFeeAmount());
            feeVos.add(vo);
        }
        form.setPeriodNum(borrowDO.getPeriodNum());
        form.setCapitalAmount(borrowDO.getCapitalAmount());
        form.setInterestAmount(borrowDO.getInterestAmount());
        form.setServiceFee(borrowDO.getServiceFee());
        if (borrowDO.getRepayDate() != null) {
            form.setRepayDate(DateUtils.dateToString(borrowDO.getRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        if (borrowDO.getRealRepayDate() != null) {
            form.setRepaidDate(DateUtils.dateToString(borrowDO.getRealRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        form.setServiceFeeDetails(JSON.toJSONString(feeVos));//相关服务费明细，待定
        form.setRepayStatus(borrowDO.getRepayStatus());//还款状态,需要枚举
        form.setOverdueDay(borrowDO.getOverdueDay());
        form.setTotalCapitalLeft(borrowDO.getTotalCapitalLeft());
        form.setTotalCapitalAccu(borrowDO.getTotalCapitalAccu());
        form.setInterestAccu(borrowDO.getInterestAccu());
        form.setServiceFeeAccu(borrowDO.getServiceFeeAccu());
        form.setFineAccu(borrowDO.getPunishFee());
        if (borrowDO.getPunishUpdatedTime() != null) {
            form.setFineUpdatedTime(DateUtils.dateToString(borrowDO.getPunishUpdatedTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN));
        }
        return form;
    }

    public static LoanDetailInfoVo customerConverter(CustomerInfoDO cust, QueryRepayPlanReqForm vo, Integer count) {
        LoanDetailInfoVo form = new LoanDetailInfoVo();
        form.setUserName(cust.getUserName());
        form.setUserId(cust.getUserId());
        form.setIdType(cust.getIdType());
        form.setIdNo(cust.getIdNo());
        form.setOrgId(String.valueOf(cust.getOrgId()));
        form.setBoId(vo.getBoId());
        form.setPageNo(vo.getPageNo());
        form.setPageRec(vo.getPageRec());
        form.setPageCount(count);
        return form;
    }

    /**
     * 平台收益查询
     *
     * @param list
     * @return
     */
    public static List<QueryPlatEarningsVo> platEarningsListConverter(List<AccountEarningsExDO> list) {
        if (list != null && list.size() > 0) {
            List<QueryPlatEarningsVo> listResp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listResp.add(platEarningsVoConverter(list.get(i)));
            }
            return listResp;
        }
        return null;
    }

    public static QueryPlatEarningsVo platEarningsVoConverter(AccountEarningsExDO borrowDO) {
        QueryPlatEarningsVo form = new QueryPlatEarningsVo();
        List<AccountEarningsServiceFeeDO> feeList = borrowDO.getFeeDOS();
        List<FeeVo> feeVos = new ArrayList<>();
        BigDecimal platService = new BigDecimal(0);//平台服务费
        BigDecimal fine = new BigDecimal(0);//当期应收逾期导致的罚息或违约费用

        for (AccountEarningsServiceFeeDO exDO : feeList) {
            FeeVo vo = new FeeVo();
            vo.setFeeName(exDO.getFeeName());
            vo.setFeeAmount(exDO.getFeeAmount());
            feeVos.add(vo);
            if ("12004".equals(exDO.getFeeType())) {
                platService = exDO.getFeeAmount();
            }
            if ("2".equals(exDO.getFeeType().substring(0, 1))) {
                fine = fine.add(exDO.getFeeAmount());
            }
        }
        form.setServiceFee(platService);
        form.setFine(fine);
        form.setBoId(borrowDO.getBoId());
        form.setPeriodNum(borrowDO.getPeriodNum());
        form.setOrgId(String.valueOf(borrowDO.getOrgId()));
        form.setIsFullFee(borrowDO.getIsFullFee()); //是否一次性收取平台费，枚举，待定
        form.setTotalServiceFee(borrowDO.getServiceFee());//应收平台服务总费
        form.setTotalServiceFeeDetails(JSON.toJSONString(feeVos));//服务费明细，json
        form.setCapitalAmount(borrowDO.getCapitalAmount());
        form.setInterestAmount(borrowDO.getInterestAmount());
        if (borrowDO.getRepayDate() != null) {
            form.setRepayDate(DateUtils.dateToString(borrowDO.getRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        if (borrowDO.getRealRepayDate() != null) {
            form.setRepaidDate(DateUtils.dateToString(borrowDO.getRealRepayDate(), DateUtils.SIMPLE_DATE_PATTERN));
        }
        form.setRepayStatus(borrowDO.getRepayStatus());//收款状态，枚举。
        form.setOverdueDay(borrowDO.getOverdueDay());
        form.setServiceFeeAccu(borrowDO.getServiceFeeAccu());
        form.setFineAccu(borrowDO.getPunishFeeAccu());
        if (borrowDO.getPunishUpdatedTime() != null) {
            form.setFineUpdatedTime(DateUtils.dateToString(borrowDO.getPunishUpdatedTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN));
        }
        return form;
    }

    public static TrialLoanDetailInfoVo queryTrialLoanDetail(AccountTrialReqForm vo, String interest, String service) throws ParseException {

        TrialLoanDetailInfoVo form = new TrialLoanDetailInfoVo();
        Integer repayPeriod = Integer.valueOf(vo.getRepayPeriod());
        BigDecimal loanAmount = vo.getLoanAmount();
        form.setUserName(vo.getUserName());
        form.setIdType(vo.getIdType());
        form.setIdNo(vo.getIdNo());
        form.setOrgId(vo.getOrgId());
        form.setTotalCapital(vo.getLoanAmount().setScale(2, BigDecimal.ROUND_UP));
        BigDecimal totalInterestAccu = new BigDecimal(0);
        //如果通过减息券等变更利率
        BigDecimal totalService = new BigDecimal(0);
        BigDecimal totalCapitalAccu = new BigDecimal(0);
        BigDecimal perAmount = MoneyUtils.getPerAmount(loanAmount, Integer.valueOf(vo.getRepayPeriod()));//每期应该本金
        //总利息（每期利息累计）
        for (int j = 1; j < repayPeriod + 1; j++) {// getPerAmount(BigDecimal invest,int totalmonth)
            totalCapitalAccu = totalCapitalAccu.add(perAmount);
            totalInterestAccu = totalInterestAccu.add(MoneyUtils.getPerInterest(loanAmount, interest, repayPeriod, j));
            totalService = totalService.add((loanAmount.subtract(totalCapitalAccu).add(perAmount)).multiply(new BigDecimal(service)).setScale(2, BigDecimal.ROUND_UP));

        }
        form.setTotalInterest(totalInterestAccu);
        form.setTotalServiceFee(totalService);
        if (StringUtils.isNotBlank(vo.getRepayDate())) {
            form.setRepayDate(vo.getRepayDate());
        }
        form.setRepayPeriod(vo.getRepayPeriod());
        String applyDate = vo.getApplyDate();
        if (StringUtils.isNotBlank(applyDate)) {
            Date applyDates = DateUtils.parseDatetime(applyDate, DateUtils.SIMPLE_DATE_PATTERN);
            Date firstRepayDate = DateUtils.addMonths(applyDates, 1);
            form.setFirstRepayDate(DateUtils.dateToString(firstRepayDate, DateUtils.SIMPLE_DATE_PATTERN));
            Date lastRepayDate = DateUtils.addMonths(applyDates, repayPeriod);
            form.setLastRepayDate(DateUtils.dateToString(lastRepayDate, DateUtils.SIMPLE_DATE_PATTERN));
//            form.setRepayDate(DateUtils.);
        }
        return form;
    }

    public static List<TrialDetailListVo> queryTrialDetailList(AccountTrialReqForm vo, String interest, String service) throws ParseException {
        List<TrialDetailListVo> trialDetailListVos = new ArrayList<>();
        String repayPeriod = vo.getRepayPeriod();
        Integer period = Integer.valueOf(repayPeriod);
        for (int i = 1; i < period + 1; i++) {
            trialDetailListVos.add(queryTrialDetail(vo.getLoanAmount(), vo.getApplyDate(), interest, repayPeriod, service, i));
        }
        return trialDetailListVos;
    }

    public static TrialDetailListVo queryTrialDetail(BigDecimal loanAmount, String applyDate, String rate, String repayPeriod, String service, int i) throws ParseException {
        Integer totalMonth = Integer.valueOf(repayPeriod);
        TrialDetailListVo vo = new TrialDetailListVo();
        vo.setPeriodNum(String.valueOf(i));
        BigDecimal capitalAmount = MoneyUtils.getPerAmount(loanAmount, totalMonth);
        vo.setCapitalAmount(capitalAmount);//每月偿还本金
        vo.setInterestAmount(MoneyUtils.getPerInterest(loanAmount, rate, totalMonth, i));//每月偿还利息
        BigDecimal totalCapitalAccu = new BigDecimal(0);
        BigDecimal totalInterestAccu = new BigDecimal(0);
        BigDecimal totalServiceFeeAccu = new BigDecimal(0);
        for (int j = 1; j < i + 1; j++) {
            totalCapitalAccu = totalCapitalAccu.add(capitalAmount);
            totalInterestAccu = totalInterestAccu.add(MoneyUtils.getPerInterest(loanAmount, rate, totalMonth, j));
            totalServiceFeeAccu = totalServiceFeeAccu.add((loanAmount.subtract(totalCapitalAccu).add(capitalAmount)).multiply(new BigDecimal(service)).setScale(2, BigDecimal.ROUND_UP));
        }
        logger.info("loanAmount:" + loanAmount + "totalCapitalAccu:" + totalCapitalAccu + "capitalAmount:" + capitalAmount + "service:" + service);
        vo.setServiceFee((loanAmount.subtract(totalCapitalAccu).add(capitalAmount)).multiply(new BigDecimal(service)).setScale(2, BigDecimal.ROUND_UP)); //相关费用
        logger.info("serviceFee:" + vo.getServiceFee());
        Date repayDate = DateUtils.addMonths(DateUtils.stringToDate(applyDate, DateUtils.SIMPLE_DATE_PATTERN), i);
        vo.setRepayDate(DateUtils.dateToString(repayDate, DateUtils.SIMPLE_DATE_PATTERN));//计划划款日
        BigDecimal totalCapitalLeft = loanAmount.subtract(totalCapitalAccu).setScale(2, BigDecimal.ROUND_UP);
        if (i == totalMonth) {
            totalCapitalLeft = new BigDecimal(0).setScale(2, BigDecimal.ROUND_UP);
            totalCapitalAccu = loanAmount.setScale(2, BigDecimal.ROUND_UP);
        }
        vo.setTotalCapitalLeft(totalCapitalLeft);//截至当期剩余本金
        vo.setTotalCapitalAccu(totalCapitalAccu);//截至当期累计已还本金金额
        vo.setInterestAccu(totalInterestAccu);//截至当期累计已还利息总额
        vo.setServiceFeeAccu(totalServiceFeeAccu);//截至当期累计服务费用总额
        return vo;
    }


    public static PreRepayTryRespForm getPreRepayTry(PreRepayTryReqForm form, AccountBorrowDO borrowDO, BigDecimal preRepayFine, BigDecimal preRepayServiceFee0,BigDecimal preRepayServiceFee2, BigDecimal preRepayServiceFee3) throws ParseException {
        BigDecimal totalCapitalLeft = borrowDO.getTotalCapitalLeft();//需提前还款本金
        Date lendDate = borrowDO.getLendDate(); //实际放款时间
        BigDecimal lendAmount = borrowDO.getLendAmount();
        String repayPeriod = borrowDO.getRepayPeriod();//还款期数
        String repayDate = form.getApplyDate();//还款日期
        BigDecimal repayRate = borrowDO.getRate();//正常利率

        Date d2 = DateUtils.stringToDate(repayDate, DateUtils.SIMPLE_DATE_PATTERN);
        Date d1 = DateUtils.date2date(lendDate, DateUtils.SIMPLE_DATE_PATTERN);
        int a = (int) ((d2.getTime() - d1.getTime()) / (1000 * 3600 * 24));
        if (a <= 0) {
            throw new CommonException(ResultEnum.RepayDateLessApply, ResultEnum.RepayDateLessApply.getMsg());
        }
        //提前还款利息=剩余金额*（月利率/30)*（还款日期-实际放款日期）
        //提前还款金额 = 剩余本金+提前还款利息+罚息费+罚息服务费+技术服务费+平台服务费
        BigDecimal preRepayInterest = totalCapitalLeft.multiply(new BigDecimal(a)).multiply(repayRate).divide(new BigDecimal(30), 2, BigDecimal.ROUND_UP);
        BigDecimal preRepayAmount = totalCapitalLeft.add(preRepayInterest).add(preRepayFine).add(preRepayServiceFee0).add(preRepayServiceFee2).add(preRepayServiceFee3).setScale(2, BigDecimal.ROUND_UP);//需提前还款本金+还款利息+还款罚息；

        PreRepayTryRespForm respForm = new PreRepayTryRespForm();
        respForm.setUserName(form.getUserName());
        respForm.setIdType(form.getIdType());
        respForm.setIdNo(form.getIdNo());
        respForm.setBoId(form.getBoId());
        respForm.setPreRepayApplyDate(form.getApplyDate());
        respForm.setPreRepayAmount(preRepayAmount);
        respForm.setPreRepayCapitalLeft(totalCapitalLeft);
        respForm.setPreRepayInterest(preRepayInterest);
        respForm.setPreRepayFine(preRepayFine);
        respForm.setOverDueFine(new BigDecimal(0));//滞纳金,目前滞纳金为0，等接入资产端再算。
        respForm.setPreRepayServiceFee0(preRepayServiceFee0);//逾期服务费
        respForm.setPreRepayServiceFee1(new BigDecimal(0));
        respForm.setPreRepayServiceFee2(preRepayServiceFee2);//技术服务费
        respForm.setPreRepayServiceFee3(preRepayServiceFee3);//平台服务费
        return respForm;
    }


    public static PreRepayTryReqForm reqManualRepay(ManualRepayReqForm form) {
        PreRepayTryReqForm tryReqForm = new PreRepayTryReqForm();
        tryReqForm.setUserName(form.getUserName());
        tryReqForm.setIdType(form.getIdType());
        tryReqForm.setIdNo(form.getIdNo());
        tryReqForm.setUserId(form.getUserId());
        tryReqForm.setOrgId(form.getOrgId());
        tryReqForm.setBoId(form.getBoId());
        tryReqForm.setApplyDate(form.getApplyDate());
        tryReqForm.setApplyTime(form.getApplyTime());
        return tryReqForm;
    }


}

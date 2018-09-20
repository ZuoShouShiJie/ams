package com.dzjk.ams.endpoint.doValidate.account;

import com.alibaba.common.lang.StringUtil;
import com.dzjk.ams.core.common.enums.RepayModeEnum;
import com.dzjk.ams.core.common.enums.ResultEnum;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.RegexUtils;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.facade.model.CreateCusBaseInfoVo;
import com.dzjk.ams.facade.model.CreateLoanDetailInfoVo;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public class AccountDoValidate {


    public static QueryAccountReqForm queryAccount(QueryAccountReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtils.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }

        return form;
    }


    public static QueryRepayPlanReqForm queryRepayPlan(QueryRepayPlanReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtils.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "boId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getPageNo() == null) {
            throw new CommonException(ResultEnum.ParamNull, "pageNo" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getPageRec() == null) {
            throw new CommonException(ResultEnum.ParamNull, "pageRec" + ResultEnum.ParamNull.getMsg());
        }
        return form;
    }


    public static QueryPlatEarningsReqForm queryPlatEarnings(QueryPlatEarningsReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getStartDate())) {
            throw new CommonException(ResultEnum.ParamNull, "startDate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getEndDate())) {
            throw new CommonException(ResultEnum.ParamNull, "endDate" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getPageNo() == null) {
            throw new CommonException(ResultEnum.ParamNull, "pageNo" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getPageRec() == null) {
            throw new CommonException(ResultEnum.ParamNull, "pageRec" + ResultEnum.ParamNull.getMsg());
        }
        return form;
    }

    public static AccountTrialReqForm accountTrial(AccountTrialReqForm form) {
        if (StringUtils.isBlank(form.getUserName())) {
            throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getIdType())) {
            throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getIdNo())) {
            throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getLoanAmount() != null) {
            if (form.getLoanAmount().compareTo(new BigDecimal(0)) == -1) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            }
            String loanAmount = form.getLoanAmount().toString();
            if (loanAmount.lastIndexOf('.') != -1 && loanAmount.substring(loanAmount.lastIndexOf('.')).length() > 3) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            }
        } else {
            throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
        }
        if (StringUtils.isBlank(form.getProductCode())) {
            throw new CommonException(ResultEnum.ParamNull, "productCode" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getApplyDate())) {
            throw new CommonException(ResultEnum.ParamNull, "applyDate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getApplyTime())) {
            throw new CommonException(ResultEnum.ParamNull, "ApplyTime" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getRepayPeriod())) {
            throw new CommonException(ResultEnum.ParamNull, "repayPeriod" + ResultEnum.ParamNull.getMsg());
        }
        return form;
    }

    public static void createAccount(CreateAccountReqForm form) throws ParseException {
        if (form.getCusBaseInfo() == null) {
            throw new CommonException(ResultEnum.ParamNull, "客户信息" + ResultEnum.ParamNull.getMsg());
        }
        CreateCusBaseInfoVo customer = form.getCusBaseInfo();

        if (StringUtils.isBlank(customer.getUserName())) {
            throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(customer.getIdType())) {
            throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(customer.getIdNo())) {
            throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
        }

        if (StringUtils.isBlank(customer.getMobile())) {
            throw new CommonException(ResultEnum.ParamNull, "mobile" + ResultEnum.ParamNull.getMsg());
        }
        if (customer.getMobile().length() > 11) {
            throw new CommonException(ResultEnum.NoLegal, "mobile" + ResultEnum.NoLegal.getMsg());
        }
        if (!customer.getMobile().matches(RegexUtils.teleReg)) {
            throw new CommonException(ResultEnum.NoLegal, "mobile" + ResultEnum.NoLegal.getMsg());
        }

        if (StringUtils.isBlank(customer.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getLoanDetailInfo() == null) {
            throw new CommonException(ResultEnum.ParamNull, "借款信息" + ResultEnum.ParamNull.getMsg());
        }
        CreateLoanDetailInfoVo loan = form.getLoanDetailInfo();
        if (StringUtils.isBlank(loan.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "boId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(loan.getProductCode())) {
            throw new CommonException(ResultEnum.ParamNull, "productCode" + ResultEnum.ParamNull.getMsg());
        }
        if ("1".equals(customer.getIdType())) {
            if (!CommonUtils.checkNum(customer.getIdNo())) {
                throw new CommonException(ResultEnum.NoLegal, "idNo" + "身份证号" + ResultEnum.NoLegal.getMsg());
            }
        } else {
            throw new CommonException(ResultEnum.NoLegal, "idType" + "身份证类型" + ResultEnum.NoLegal.getMsg());
        }
        if (loan.getLoanAmount() != null) {
            if (loan.getLoanAmount().compareTo(new BigDecimal(0)) == -1) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            }
            String loanAmount = loan.getLoanAmount().toString();
            if (loanAmount.lastIndexOf('.') != -1 && loanAmount.substring(loanAmount.lastIndexOf('.')).length() > 3) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            }
            if (loanAmount.indexOf('.') != -1 && loanAmount.substring(0, loanAmount.indexOf('.')).length() > 16) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            } else if (loanAmount.indexOf('.') == -1 && loanAmount.length() > 16) {
                throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
            }

        } else {
            throw new CommonException(ResultEnum.NoLegal, "loanAmount" + ResultEnum.NoLegal.getMsg());
        }

        if (loan.getLendAmount() != null) {
            if (loan.getLendAmount().compareTo(new BigDecimal(0)) == -1) {
                throw new CommonException(ResultEnum.NoLegal, "lendAmount" + ResultEnum.NoLegal.getMsg());
            }
            String lendAmount = loan.getLendAmount().toString();
            if (lendAmount.lastIndexOf('.') != -1 && lendAmount.substring(lendAmount.lastIndexOf('.')).length() > 3) {
                throw new CommonException(ResultEnum.NoLegal, "lendAmount" + ResultEnum.NoLegal.getMsg());
            }
            if (lendAmount.indexOf('.') != -1 && lendAmount.substring(0, lendAmount.indexOf('.')).length() > 16) {
                throw new CommonException(ResultEnum.NoLegal, "lendAmount" + ResultEnum.NoLegal.getMsg());
            } else if (lendAmount.indexOf('.') == -1 && lendAmount.length() > 16) {
                throw new CommonException(ResultEnum.NoLegal, "lendAmount" + ResultEnum.NoLegal.getMsg());
            }
        } else {
            throw new CommonException(ResultEnum.NoLegal, "lendAmount" + ResultEnum.NoLegal.getMsg());
        }
        if (StringUtils.isBlank(loan.getLendDate())) {
            throw new CommonException(ResultEnum.ParamNull, "lendDate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(loan.getLendTime())) {
            throw new CommonException(ResultEnum.ParamNull, "LendTime" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(loan.getApplyDate())) {
            throw new CommonException(ResultEnum.ParamNull, "ApplyDate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(loan.getApplyTime())) {
            throw new CommonException(ResultEnum.ParamNull, "ApplyTime" + ResultEnum.ParamNull.getMsg());
        }
        Date lendDate = DateUtils.parseDatetime(loan.getLendDate(), DateUtils.SIMPLE_DATE_PATTERN);
        Date lendTime = DateUtils.parseDatetime(loan.getLendTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN);
        Date applyDate = DateUtils.parseDatetime(loan.getApplyDate(), DateUtils.SIMPLE_DATE_PATTERN);
        Date applyTime = DateUtils.parseDatetime(loan.getApplyTime(), DateUtils.SIMPLE_DATE_HOURS_PATTERN);
        if (lendDate.getTime() < applyDate.getTime()) {
            throw new CommonException(ResultEnum.ShouldBig, "实际放款日" + ResultEnum.ShouldBig.getMsg() + "申请日期");
        }
        if (lendTime.getTime() < applyTime.getTime()) {
            throw new CommonException(ResultEnum.ShouldBig, "实际放款时间" + ResultEnum.ShouldBig.getMsg() + "申请时间");
        }
        //校验repayDate
        if (StringUtils.isNotBlank(loan.getRepayDate())) {
            String repayDate = loan.getRepayDate();
            if (!repayDate.matches(RegexUtils.digReg)) {
                throw new CommonException(ResultEnum.NoLegal, "repayDate格式" + ResultEnum.NoLegal.getMsg());
            }
            if (repayDate.length() > 2) {
                throw new CommonException(ResultEnum.NoLegal, "repayDate格式" + ResultEnum.NoLegal.getMsg());
            }
            Integer irepayDate = Integer.valueOf(repayDate);
            if (irepayDate > 28) {
                throw new CommonException(ResultEnum.NoLegal, "repayDate格式" + ResultEnum.NoLegal.getMsg());
            }
        }
    }

    public static void preRepayTry(PreRepayTryReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtils.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "BoId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }

        if (StringUtils.isBlank(form.getApplyDate())) {
            throw new CommonException(ResultEnum.ParamNull, "applydate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getApplyTime())) {
            throw new CommonException(ResultEnum.ParamNull, "applyTime" + ResultEnum.ParamNull.getMsg());
        }

    }

    public static void manualRepay(ManualRepayReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtils.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "BoId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }

        if (StringUtils.isBlank(form.getApplyDate())) {
            throw new CommonException(ResultEnum.ParamNull, "applydate" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getApplyTime())) {
            throw new CommonException(ResultEnum.ParamNull, "applyTime" + ResultEnum.ParamNull.getMsg());
        }
        if (form.getPreRepayAmount() == null) {
            throw new CommonException(ResultEnum.ParamNull, "preRepayAmount" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getSerialNumber())) {
            throw new CommonException(ResultEnum.ParamNull, "serialNumber" + ResultEnum.ParamNull.getMsg());
        }
    }

    public static void accountUpdate(AccountUpdateReqForm form) {
       /* if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtil.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }*/

        if (StringUtils.isBlank(form.getApplyUpdateType())) {
            throw new CommonException(ResultEnum.ParamNull, "applyUpdateType" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "BoId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }

    }

    public static void queryAccountStatus(QueryAccountStatusReqForm form) {
        if (StringUtils.isBlank(form.getUserId())) {
            if (StringUtil.isBlank(form.getUserName())) {
                throw new CommonException(ResultEnum.ParamNull, "userName" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdType())) {
                throw new CommonException(ResultEnum.ParamNull, "idType" + ResultEnum.ParamNull.getMsg());
            }
            if (StringUtils.isBlank(form.getIdNo())) {
                throw new CommonException(ResultEnum.ParamNull, "idNo" + ResultEnum.ParamNull.getMsg());
            }
        }
        if (StringUtils.isBlank(form.getBoId())) {
            throw new CommonException(ResultEnum.ParamNull, "BoId" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getOrgId())) {
            throw new CommonException(ResultEnum.ParamNull, "orgId" + ResultEnum.ParamNull.getMsg());
        }
    }


    public static void capitalCostTrial(CapitalCostTrialReqForm form) {
        if (form==null){
            throw new CommonException(ResultEnum.ParamNull, "请求" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getAmount())) {
            throw new CommonException(ResultEnum.ParamNull, "借款金额" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getPeriod())) {
            throw new CommonException(ResultEnum.ParamNull, "期数" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getPrice())) {
            throw new CommonException(ResultEnum.ParamNull, "每期利息" + ResultEnum.ParamNull.getMsg());
        }
        if (StringUtils.isBlank(form.getType())) {
            throw new CommonException(ResultEnum.ParamNull, "还款方式" + ResultEnum.ParamNull.getMsg());
        }
        if (RepayModeEnum.parser(form.getType())==null){
            throw new CommonException(ResultEnum.RepayMode, ResultEnum.RepayMode.getMsg());
        }

    }




}

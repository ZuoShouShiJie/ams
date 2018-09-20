package com.dzjk.ams.web.controller.account;


import com.dzjk.ams.core.common.enums.ResultEnum;
import com.dzjk.ams.core.common.exception.CommonException;

import com.dzjk.ams.endpoint.action.account.AccountFacadeRestImpl;
import com.dzjk.ams.facade.api.account.AccountRestFacade;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.facade.model.CreateCusBaseInfoVo;
import com.dzjk.ams.facade.model.CreateLoanDetailInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author climb.s
 * @date 2018/2/6 09:57
 */
@RestController
@RequestMapping("/account")
public class accountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountFacadeRestImpl.class);
    @Autowired
    private AccountRestFacade accountRestacade;

    /**
     * 账务查询
     *
     * @param form
     * @param request
     * @return
     * @throws CommonException
     */
    @RequestMapping(value = "/queryAccount")
    @ResponseBody
    public Object queryAccount(QueryAccountReqForm form, HttpServletRequest request) throws CommonException {
        return accountRestacade.queryAccount(form);
    }

    /**
     * 还款计划查询
     */
    @RequestMapping("/queryRepayPlan")
    @ResponseBody
    public Object queryRepayPlan(QueryRepayPlanReqForm form, HttpServletRequest request) {
        return accountRestacade.queryRepayPlan(form);
    }

    /**
     * 撮合平台收益计划查询
     */
    @RequestMapping("/queryPlatEarnings")
    @ResponseBody
    public Object queryPlatEarnings(QueryPlatEarningsReqForm form, HttpServletRequest request) {
        return accountRestacade.queryPlatEarnings(form);
    }

    /**
     * 借款前账务试算
     *
     * @param form
     * @param request
     * @return
     */
    @RequestMapping("/accountTrial")
    @ResponseBody
    public Object accountTrial(AccountTrialReqForm form, HttpServletRequest request) {

        return accountRestacade.accountTrial(form);

    }

    /**
     * 审贷建账
     * @return
     */
    @RequestMapping(value = "/createAccount")
    @ResponseBody
    public Object createAccount(CreateAccountReqFormTest form, HttpServletRequest request){

        CreateAccountReqForm form1 = new CreateAccountReqForm();
        form1.setUserId(form.getUserId());
        CreateCusBaseInfoVo cusBaseInfoVo = new CreateCusBaseInfoVo();
        cusBaseInfoVo.setUserName(form.getUserName());
        cusBaseInfoVo.setIdType(form.getIdType());
        cusBaseInfoVo.setIdNo(form.getIdNo());
        cusBaseInfoVo.setMobile(form.getMobile());
        cusBaseInfoVo.setOrgId(form.getOrgId());
        form1.setCusBaseInfo(cusBaseInfoVo);
        CreateLoanDetailInfoVo loan = new CreateLoanDetailInfoVo();

        loan.setBoId(form.getBoId());
        loan.setRepayRate(form.getRepayRate());
        loan.setProductCode(form.getProductCode());
        loan.setLoanAmount(form.getLoanAmount());
        loan.setLendAmount(form.getLendAmount());
        loan.setApplyTime(form.getApplyTime());
        loan.setApplyDate(form.getApplyDate());
        loan.setLendDate(form.getLendDate());
        loan.setLendTime(form.getLendTime());
        loan.setRepayAcctNo(form.getRepayAcctNo());
        loan.setRepayAcctName(form.getRepayAcctName());
        loan.setRepayAcctBank(form.getRepayAcctBank());
        loan.setRepayAcctPhone(form.getRepayAcctPhone());
        loan.setRepayDate(form.getRepayDate());
        loan.setRepayPeriod(form.getRepayPeriod());
        form1.setLoanDetailInfo(loan);
        return accountRestacade.createAccount(form1);
    }

    /**
     * 提前还款试算
     * @param form
     * @param request
     * @return
     */
    @RequestMapping("/prePrpayTry")
    @ResponseBody
    public Object preRepayTry(PreRepayTryReqForm form,HttpServletRequest request){

        return accountRestacade.preRepayTry(form);
    }

    /**
     * 还款交易
     * @param form
     * @param request
     * @return
     */
    @RequestMapping("/manualRepay")
    @ResponseBody
    public Object manualRepay(ManualRepayReqForm form,HttpServletRequest request){
        return accountRestacade.manualRepay(form);
    }

    /**
     * 账务变更
     * @param form
     * @param request
     * @return
     */
    @RequestMapping("/accountUpdate")
    @ResponseBody
    public Object accountUpdate(AccountUpdateReqForm form,HttpServletRequest request){
        return accountRestacade.accountUpdate(form);
    }


    /**
     * 查询建账是否成功
     */
    @RequestMapping("/queryAccountStatus")
    @ResponseBody
    public Object queryAccountStatus(QueryAccountStatusReqForm form, HttpServletRequest request){
        return accountRestacade.queryAccountStatus(form);

    }

    /**
     * 资金端成本试算查询
     */
    @RequestMapping("/capitalCostTrial")
    @ResponseBody
    public Object capitalCostTrial(CapitalCostTrialReqForm form){
        return accountRestacade.capitalCostTrial(form);

    }

}
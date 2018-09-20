package com.dzjk.ams.endpoint.action.account;

import com.alibaba.fastjson.JSON;
import com.dzjk.ams.core.common.enums.ResultEnum;
import com.dzjk.ams.core.common.enums.ServiceCode;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.api.account.AccountApiFacade;
import com.dzjk.ams.facade.base.CommonResponse;
import com.dzjk.ams.facade.base.Message;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.account.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import static com.dzjk.ams.core.common.enums.ServiceCode.AccountTrial;

/**
 * Created by daixiaohu on 2018/6/4.
 */
public class AccountFacadeApiImpl implements AccountApiFacade {
    private static Logger logger = LoggerFactory.getLogger(AccountApiFacade.class);
    @Resource
    private AccountFacadeRestImpl accountFacadeRest;

    @Override
    public String doInvoke(String var) {
        CommonResponse commonResponse = new CommonResponse();
        Message message = new Message();
        ResponseData data = new ResponseData();
        String response = "";
        try {
            logger.info("接收网关请求:" + var);
            if (StringUtils.isEmpty(var)) {
                throw new CommonException(ResultEnum.ReqMsgIsNull, ResultEnum.ReqMsgIsNull.getMsg());
            }
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(var);
            com.alibaba.fastjson.JSONObject responseHead = jsonObject.getJSONObject("header");
            String serviceCode = responseHead.getString("serviceCode");
            com.alibaba.fastjson.JSONObject body = jsonObject.getJSONObject("body");

            //借款前账务试算
            if (ServiceCode.AccountTrial.getCode().equals(serviceCode)) {
                AccountTrialReqForm form = body.toJavaObject(AccountTrialReqForm.class);
                data = accountFacadeRest.accountTrial(form);
                //审贷建账
            } else if (ServiceCode.CreateAccount.getCode().equals(serviceCode)) {
                CreateAccountReqForm form = body.toJavaObject(CreateAccountReqForm.class);
                data = accountFacadeRest.createAccount(form);
                //账务查询
            } else if (ServiceCode.QueryAccount.getCode().equals(serviceCode)) {
                QueryAccountReqForm form = body.toJavaObject(QueryAccountReqForm.class);
                data = accountFacadeRest.queryAccount(form);
                //还款计划查询
            } else if (ServiceCode.QueryRepayPlan.getCode().equals(serviceCode)) {
                QueryRepayPlanReqForm form = body.toJavaObject(QueryRepayPlanReqForm.class);
                data = accountFacadeRest.queryRepayPlan(form);
                //撮合平台收益计划查询
            } else if (ServiceCode.QueryPlatEarnings.getCode().equals(serviceCode)) {
                QueryPlatEarningsReqForm form = body.toJavaObject(QueryPlatEarningsReqForm.class);
                data = accountFacadeRest.queryPlatEarnings(form);
                //提前还款试算
            } else if (ServiceCode.PrePrpayTry.getCode().equals(serviceCode)) {
                PreRepayTryReqForm form = body.toJavaObject(PreRepayTryReqForm.class);
                data = accountFacadeRest.preRepayTry(form);
                //还款交易接口
            } else if (ServiceCode.ManualRepay.getCode().equals(serviceCode)) {
                ManualRepayReqForm form = body.toJavaObject(ManualRepayReqForm.class);
                data = accountFacadeRest.manualRepay(form);
                //查询建账是否成功
            } else if (ServiceCode.QueryAccountStatus.getCode().equals(serviceCode)) {
                QueryAccountStatusReqForm form = body.toJavaObject(QueryAccountStatusReqForm.class);
                data = accountFacadeRest.queryAccountStatus(form);
                //账务变更
            } else if (ServiceCode.AccountUpdate.getCode().equals(serviceCode)) {
                AccountUpdateReqForm form = body.toJavaObject(AccountUpdateReqForm.class);
                data = accountFacadeRest.accountUpdate(form);
            }else if (ServiceCode.CapitalCostTrial.getCode().equals(serviceCode)){
                CapitalCostTrialReqForm form = body.toJavaObject(CapitalCostTrialReqForm.class);
                data = accountFacadeRest.capitalCostTrial(form);
            }
            commonResponse.setData(data.getData());
            message.setStatus(data.getReturn_code());
            message.setDesc(data.getReturn_msg());
            commonResponse.setMessage(message);
            response = JSON.toJSONString(commonResponse);
        } catch (CommonException e) {
            message.setStatus(data.getReturn_code());
            message.setDesc(data.getReturn_msg());
            commonResponse.setMessage(message);
            response = JSON.toJSONString(commonResponse);
            logger.error("调用账务接口异常", e);
        } catch (Exception e) {
            message.setStatus(ResultEnum.UNKONW_ERROR.getCode());
            message.setDesc(ResultEnum.UNKONW_ERROR.getMsg());
            commonResponse.setMessage(message);
            response = JSON.toJSONString(commonResponse);
            logger.error("调用账务接口异常", e);
        }
        logger.info("账务系统返回:" + var);
        return response;
    }
}

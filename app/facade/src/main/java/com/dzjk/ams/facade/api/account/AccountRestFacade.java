package com.dzjk.ams.facade.api.account;

import com.dzjk.ams.core.common.RestConstants;
import com.dzjk.ams.core.common.URLConstants;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.base.ResultCommonFacadeResp;
import com.dzjk.ams.facade.form.QueryReqForm;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.facade.model.DemoUserModel;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Path("/account")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface AccountRestFacade {
    @GET
    @Path("/queryAccount")
    ResponseData<List<QueryAccountRespForm>> queryAccount(QueryAccountReqForm form);

    @GET
    @Path("/queryRepayPlan")
    ResponseData<QueryRepayPlanRespForm> queryRepayPlan(QueryRepayPlanReqForm form);

    @GET
    @Path("/queryPlatEarnings")
    ResponseData<QueryPlatEarningsRespForm> queryPlatEarnings(QueryPlatEarningsReqForm form);

    @GET
    @Path("/accountTrial")
    ResponseData<AccountTrialRespForm> accountTrial(AccountTrialReqForm form);

    @POST
    @Path("/createAccount")
    ResponseData<CreateAccountRespForm> createAccount(CreateAccountReqForm form);

    @GET
    @Path("/preRepayTry")
    ResponseData<PreRepayTryRespForm> preRepayTry(PreRepayTryReqForm form);

    @GET
    @Path("/manualRepay")
    ResponseData<Object> manualRepay(ManualRepayReqForm form);

    @POST
    @Path("/accountUpdate")
    ResponseData<AccountUpdateRespForm> accountUpdate(AccountUpdateReqForm form);

    @GET
    @Path("/queryAccountStatus")
    ResponseData<Object> queryAccountStatus(QueryAccountStatusReqForm form);

    @GET
    @Path("/capitalCostTrial")
    ResponseData<AccountTrialRespForm> capitalCostTrial(CapitalCostTrialReqForm form);

}

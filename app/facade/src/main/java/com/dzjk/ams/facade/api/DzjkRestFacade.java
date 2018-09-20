package com.dzjk.ams.facade.api;

import com.dzjk.ams.core.common.RestConstants;
import com.dzjk.ams.core.common.URLConstants;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.base.DefaultFacadeResp;
import com.dzjk.ams.facade.base.ResultCommonFacadeResp;
import com.dzjk.ams.facade.form.QueryReqForm;
import com.dzjk.ams.facade.model.AccountingModel;
import com.dzjk.ams.facade.model.DemoUserModel;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.Map;

/** @author climb.s
 * @date 2018/2/6 09:27 */
@Path(URLConstants.REST_API_PEFFIX + "/dzjknew")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface DzjkRestFacade {
	@GET
	@Path("/{userName}")
	ResultCommonFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException;

	String query(QueryReqForm form);

	Map<String, Object> queryAddress(String custId) throws IOException;

	String redisQuery(QueryReqForm form);

	String UniqueLoadAll();

	DefaultFacadeResp testSplitTable(AccountingModel model);


}

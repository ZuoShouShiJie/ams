package com.dzjk.ams.facade.api;



import com.dzjk.ams.core.common.RestConstants;
import com.dzjk.ams.core.common.URLConstants;
import com.dzjk.ams.facade.base.RestSampleFacadeResp;
import com.dzjk.ams.facade.model.MqMessage;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * REST interface used to trigger message publish.
 *
 * base url: http://host:port/webapi/mq/
 *
 */
@Path(URLConstants.REST_API_PEFFIX + "/mq")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface MqRestFacade {
	
    @GET
    @Path("/publish")
    RestSampleFacadeResp<MqMessage> publish() throws Exception;

    @GET
    @Path("/subscribe")
    RestSampleFacadeResp<List<MqMessage>> subscribe() throws Exception;

}

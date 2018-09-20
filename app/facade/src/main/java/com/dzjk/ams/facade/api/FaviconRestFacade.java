package com.dzjk.ams.facade.api;

import com.dzjk.ams.core.common.RestConstants;
import com.dzjk.ams.core.common.exception.CommonException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** @author climb.s
 * @date 2018/2/6 09:42 */
@Path("/favicon.ico")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface FaviconRestFacade {

	@GET
	public String faviconIco() throws CommonException;
}

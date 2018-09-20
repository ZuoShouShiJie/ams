package com.dzjk.ams.core.common.filter;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.util.Set;

/** @author climb.s
 * @date 2018/2/6 09:44 */
@Provider
@PreMatching
public class CommonContainerResponseFilter extends CorsFilter {

	public void setAllowedOrigins(Set<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

}

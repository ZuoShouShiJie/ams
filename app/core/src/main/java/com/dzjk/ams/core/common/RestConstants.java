package com.dzjk.ams.core.common;


import javax.ws.rs.core.MediaType;

/** @author climb.s
 * @date 2018/2/6 09:11 */
public class RestConstants {
	/** response encoding */
	public static final String DEFAULT_CHARSET		= "UTF-8";
	/** Content-Type */
	public static final String DEFAULT_CONTENT_TYPE	= MediaType.APPLICATION_JSON + ";" + MediaType.CHARSET_PARAMETER
			+ "=" + DEFAULT_CHARSET;
}

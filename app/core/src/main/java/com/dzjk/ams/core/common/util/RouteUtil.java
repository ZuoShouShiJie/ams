package com.dzjk.ams.core.common.util;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/** @author climb.s
 * @date 2018/2/11 05:33 */
public final class RouteUtil {
	public static final int DEFAULT_ROUTE = 2;

	public static String getRoute(String routeMapping) {
		return getRoute(routeMapping, null, DEFAULT_ROUTE);
	}

	public static String getRoute(String routeMapping,
								  int route) {
		return getRoute(routeMapping, null, route);
	}

	public static String getRoute(String routeMapping,
								  String filter,
								  int route) {
		String targetRoute = routeMapping;
		if (StringUtils.isNotEmpty(filter)) {
			targetRoute = StringUtils.replace(routeMapping, filter, "");
		}
		if (!NumberUtils.isNumber(targetRoute)) {
			return null;
		}
		String sequence = targetRoute.substring(7, targetRoute.length());
		int $sequence = Integer.parseInt(sequence);
		return StringUtils.leftPad(String.valueOf($sequence % route), 2, "0");
	}

	public static void main(String[] args) {
		System.out.println(getRoute("2017021000000151"));
	}

}

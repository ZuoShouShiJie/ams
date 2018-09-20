package com.dzjk.ams.core.common.util;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;

public class OSSUtils {
	private static OSSClient client = null;
	@Value("${ACCESS_ID}")
	private static  String ACCESS_ID ;
	@Value("${ACCESS_KEY}")
	private static  String ACCESS_KEY ;
	@Value("${ENDPOINT}")
	private static  String ENDPOINT ;

	public static OSSClient getOSSClient() {
		if (client == null) {
			synchronized (OSSClient.class) {
				if (client == null) {
					client = new OSSClient(ENDPOINT, ACCESS_ID, ACCESS_KEY);
				}
			}
		}
		return client;
	}
}

package com.dzjk.ams.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/** @author climb.s
 * @date 2018/2/6 09:49 */
@ImportResource({"classpath*:ams-applicationContext.xml"})
@SpringBootApplication
public class Slite2WebSpringBootApplication {
	// init the logger
	private static final Logger logger = LoggerFactory.getLogger(Slite2WebSpringBootApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(Slite2WebSpringBootApplication.class);
		ApplicationContext applicationContext = springApplication.run(args);
	}
}

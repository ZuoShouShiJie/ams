package com.dzjk.ams.endpoint.job;

import java.util.concurrent.ThreadPoolExecutor;


import com.alipay.antschedulerclient.common.ClientCommonResult;
import com.alipay.antschedulerclient.handler.ISimpleJobHandler;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.sun.istack.logging.Logger;

public class DzjkPayJob implements ISimpleJobHandler {
	 Logger logger = Logger.getLogger(this.getClass());

	 ThreadPoolExecutor threadPoolExecutor;
	 
	 
	  @Override
	  public String getName() {
	      return "dzjkPayJob";
	  }
	  @Override
	  public ThreadPoolExecutor getThreadPool() {
	      return threadPoolExecutor;
	  }
	  @Override
	  public ClientCommonResult handle(JobExecuteContext context) {
		  logger.info("dzjkPayjob excuting");
		  System.out.println("dzjkPayjob excuting.......");
	      boolean success = true;
	      if (success) {
	    	  return ClientCommonResult.buildSuccessResult();
	      } else {  
	          return ClientCommonResult.buildFailResult("handle failed");
	      }
	  }
	  public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
	      this.threadPoolExecutor = threadPoolExecutor;
	  }
	  
}

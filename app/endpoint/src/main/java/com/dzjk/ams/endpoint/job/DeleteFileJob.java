package com.dzjk.ams.endpoint.job;

import com.alipay.antschedulerclient.common.ClientCommonResult;
import com.alipay.antschedulerclient.handler.ISimpleJobHandler;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.dal.dao.AccountRepayPlanDAO;
import com.sun.istack.logging.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

public class DeleteFileJob implements ISimpleJobHandler {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeleteFileJob.class);
	ThreadPoolExecutor threadPoolExecutor;
	@Resource
	private AccountRepayPlanDAO accountRepayPlanDAO;
	private static String FILE_PATH="/home/admin/ossams";
	 
	  @Override
	  public String getName() {
	      return "deleteFileJob";
	  }
	  @Override
	  public ThreadPoolExecutor getThreadPool() {
	      return threadPoolExecutor;
	  }
	  @Override
	  public ClientCommonResult handle(JobExecuteContext context) {
	  	  //删除还款扣款.txt文件存放路径文件
		  String fileName1 = "Payment" + DateUtils.dateToString(DateUtils.today(), DateUtils.SDF_YMD_PATTERN);
		  String fullPath1 = FILE_PATH + "/" + fileName1 + ".txt";
		  CommonUtils.deleteFile(fullPath1);
		  logger.info("删除还款扣款.txt文件,存放路径是:"+fullPath1);
		  //删除当天还款.txt文件存放路径文件
		  String fileName = "PaymentResult" + DateUtils.dateToString(DateUtils.today(), DateUtils.SDF_YMD_PATTERN);
		  String fullPath = FILE_PATH + "/" + fileName + ".txt";
		  CommonUtils.deleteFile(fullPath);
		  logger.info("删除当天还款.txt文件,存放路径是:"+fullPath);

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

package com.dzjk.ams.endpoint.job;

import com.alipay.antschedulerclient.common.ClientCommonResult;
import com.alipay.antschedulerclient.handler.ISimpleJobHandler;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.OSSUtils;
import com.dzjk.ams.dal.dao.AccountRepayPlanDAO;
import com.dzjk.ams.dal.dataobject.AccountBorrowDO;
import com.dzjk.ams.dal.dataobject.AccountRepayPlanRepaymentDO;
import com.dzjk.ams.dal.dataobject.TodayRepaymentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by daixiaohu on 2018/3/16.
 */
public class TodayRepaymentAccountJob implements ISimpleJobHandler {
    private static Logger logger = LoggerFactory.getLogger(TodayRepaymentAccountJob.class);
    @Value("${BACKET_NAME}")
    private static String BACKET_NAME ;
    ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private AccountRepayPlanDAO accountRepayPlanDAO;
    private static String FILE_PATH="/home/admin/ossamsams";
    /**
     * 生成当天还款反馈.txt文件,并上传到oss
     * @param jobExecuteContext
     * @return
     */
    @Override
    public ClientCommonResult handle(JobExecuteContext jobExecuteContext) {
        logger.info("当天还款.txt文件开始上传OSS");
        /**
         * 生成当天还款反文件.txt
         */
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("repayDate",DateUtils.getTomorrow());
        List<TodayRepaymentDO> list = accountRepayPlanDAO.selectByTodayRepaymentDO(params);
        String fileName = "PaymentResult" + DateUtils.dateToString(DateUtils.today(), DateUtils.SDF_YMD_PATTERN);
        String fullPath = FILE_PATH + "/" + fileName + ".txt";
        FileWriter out = null;
        try {
        /*    out = new FileWriter(fullPath, true);
            //判断是否有对象
            if (list != null && list.size() > 0) {
                for (TodayRepaymentDO attribute : list) {
                    //还款金额 = 应还本金+应还利息+服务费+罚息
                    BigDecimal loanAmount = attribute.getCapitalAmount()
                            .add(attribute.getInterestAmount()).add(attribute.getServiceFee()).add(attribute.getPunishFee());
                    Date date = attribute.getRepayDate();
                    String repayDate = DateUtils.format(date, "yyyyMMdd");
                    String s = attribute.getId() + "|" + attribute.getBoId() + "|" + attribute.getContractNo() + "|" + attribute.getPeriodNum() + "|" + attribute.getOrgId()
                            + "|" + repayDate + "|" + loanAmount + "|" + attribute.getRepayAccountNo() + "|" + attribute.getRepayAccountName()
                            + "|" + attribute.getRepayStatus() + "|" + attribute.getRepayMessage()+";";
                    out.write(s);
                    out.write("\r\n");
                }
                out.flush();
                out.close();
            }*/
            //获取文件,上传OSS
            File file =new File(fullPath);
            //创建ossClient实例
            OSSClient ossClient = OSSUtils.getOSSClient();
            //上传文件  download
            PutObjectResult dzjkdev = ossClient.putObject(BACKET_NAME, "home/leex/upload/"+fileName+ ".txt", file);
            //关闭client
            System.out.println(dzjkdev.toString());
            logger.info("当天还款.txt文件上传OSS成功");
        } catch (Exception e) {
            logger.error("当天还款.txt文件上传OSS失败",e);
        }
        boolean success = true;
        if (success) {
            return ClientCommonResult.buildSuccessResult();
        } else {
            return ClientCommonResult.buildFailResult("handle failed");
        }
    }

    @Override
    public ThreadPoolExecutor getThreadPool() {
        return threadPoolExecutor;
    }

    @Override
    public String getName() {
        return "todayRepaymentAccountJob";
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}

package com.dzjk.ams.test.account;

import com.alibaba.fastjson.JSON;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.aliyun.oss.OSSClient;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.OSSUtils;
import com.dzjk.ams.endpoint.action.account.AccountFacadeRestImpl;
import com.dzjk.ams.endpoint.job.DzjkAccountJob;
import com.dzjk.ams.endpoint.job.OssDownloadAccountJob;
import com.dzjk.ams.endpoint.job.TodayRepaymentAccountJob;
import com.dzjk.ams.facade.api.account.AccountRestFacade;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.account.*;
import com.dzjk.ams.web.Slite2WebSpringBootApplication;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by daixiaohu on 2018/3/4.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Slite2WebSpringBootApplication.class)//App是springboot 的启动类
public class AccountTest {
    static String   ADD_URL = "http://localhost:8090/account/queryAccount";
    private static Logger logger = LoggerFactory.getLogger(AccountTest.class);

    @Autowired
    private AccountRestFacade accountRestacade;
    @Resource
    private TodayRepaymentAccountJob todayRepaymentAccountJob;
    @Resource
    private DzjkAccountJob dzjkAccountJob;
    @Resource
    private OssDownloadAccountJob ossDownloadAccountJob;


    ResponseData data = new ResponseData();


    public static void main(String[] args) throws IOException {

        WebApplicationContext contextLoader = ContextLoader.getCurrentWebApplicationContext();
        DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) contextLoader.getBean("ams.transactionManager");
        QueryAccountReqForm form = new QueryAccountReqForm();
        form.setUserId("111111111");
        form.setOrgId("1000");
        URL url = new URL(ADD_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(form.toString().getBytes("UTF-8"));
        out.flush();
        out.close();

        //读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer sb = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sb.append(lines);
        }
        System.out.println(sb);
        reader.close();
        // 断开连接
        connection.disconnect();


    }

    /**
     * 账务查询
     */
//    @Test
//    public void testQueryAccount() throws IOException {
//
//        logger.info("日期:"+ DateUtils.addDay(DateUtils.today(),1),DateUtils.SIMPLE_DATE_PATTERN);
//        logger.info("开始测试：request");
//        logger.debug("哈哈：");
//        QueryAccountReqForm form = new QueryAccountReqForm();
//        form.setUserId("111111111");
//        form.setOrgId("1000");
//
//        data = (ResponseData) accountRestacade.queryAccount(form);
//        data.getReturn_code();
//        data.getReturn_msg();
//        data.getData();
//        logger.info("测试结束：response" + data);
//    }

    /**
     * 还款计划查询
     */
//    @Test
//    public void testQueryRepayPlan() {
//        QueryRepayPlanReqForm form = new QueryRepayPlanReqForm();
//        form.setUserId("111111111");
//        form.setOrgId("1000");
//        form.setBoId("22222222");
//        form.setPageNo(Integer.valueOf(1));
//        form.setPageRec(Integer.valueOf(4));
//        data = accountRestacade.queryRepayPlan(form);
//        logger.info("resp:" + data);
//        if (data != null) {
//            QueryRepayPlanRespForm resp = (QueryRepayPlanRespForm) data.getData();
//            logger.info("data:" + data.getData());
//            logger.info("code:" + data.getReturn_code());
//            logger.info("msg:" + data.getReturn_msg());
//        }
//
//    }

    /**
     * 审贷建账
     */
//    @Test
//    public void testCreateAccount() throws IOException {
//
//
//
//
///*        CreateAccountReqForm form = new CreateAccountReqForm();
//
//        accountRestacade.createAccount(form);*/
//
//    }

    /**
     * 提前还款试算
     */
//    @Test
//    public void testPreRepayTry() {
//        PreRepayTryReqForm form = new PreRepayTryReqForm();
//        form.setUserId("111111111");
//        form.setBoId("22222222");
//        form.setApplyDate("2017-03-01");
//        form.setApplyTime("2017-03-01 08:08:08");
//
//        accountRestacade.preRepayTry(form);
//    }


    /**
     * accountUpdate
     */
//    @Test
//    public void testAccountUpdate() {
  /*  AccountUpdateReqForm form = new AccountUpdateReqForm();
    form.setUserId("111111111");
    form.setBoId("22222222");
    form.setOrgId("1000");
    form.setApplyUpdateType("1");
    accountRestacade.accountUpdate(form);*/
//    accountRestacade.updateAccount();

//    }
    //测试
//    @Test
//    public void ossClient(){
//        OSSClient ossClient = OSSUtils.getOSSClient();
//        System.out.println(ossClient);
//    }

    /**
     * 测试当天还款.txt文件上传OSS
     */
   @Test
    public void  upLoad(){
       JobExecuteContext jobExecuteContext = new JobExecuteContext();


        //当天还款.txt文件上传OSS
//       todayRepaymentAccountJob.handle(jobExecuteContext);
       //还款扣款.txt文件上传OSS
//       dzjkAccountJob.handle(jobExecuteContext);
       //从OSS下载当天还款.txt文件,并解析,更新数据库状态
//       ossDownloadAccountJob.handle(jobExecuteContext);






    }

    /**
     * 从OSS下载当天还款.txt文件,并解析,更新数据库状态
     */
//    @Test
//    public void download(){
//        OssDownloadAccountJob odjob = new OssDownloadAccountJob();
//        JobExecuteContext jobExecuteContext = new JobExecuteContext();
//        odjob.handle(jobExecuteContext);
//        logger.info("下载文件成功");
//    }






}

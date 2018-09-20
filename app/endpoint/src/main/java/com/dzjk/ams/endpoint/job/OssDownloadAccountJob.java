package com.dzjk.ams.endpoint.job;

import com.alipay.antschedulerclient.common.ClientCommonResult;
import com.alipay.antschedulerclient.handler.ISimpleJobHandler;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.dzjk.ams.core.common.enums.PlanRepayStatus;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.OSSUtils;
import com.dzjk.ams.dal.dao.AccountRepayPlanDAO;
import com.dzjk.ams.dal.dataobject.AccountRepayPlanDO;
import com.dzjk.ams.dal.dataobject.TodayRepaymentDO;
import com.dzjk.ams.facade.api.account.AccountRestFacade;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.account.AccountUpdateReqForm;
import com.dzjk.ams.facade.form.account.AccountUpdateRespForm;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;


public class OssDownloadAccountJob implements ISimpleJobHandler {
    private static Logger logger = LoggerFactory.getLogger(OssDownloadAccountJob.class);
    ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private AccountRepayPlanDAO accountRepayPlanDAO;
    @Autowired
    private AccountRestFacade accountRestFacade;
    @Value("${BACKET_NAME}")
    private static String BACKET_NAME ;
    private static String FILE_PATH = "/home/admin/ossams";

    /**
     * 从OSS下载当天还款.txt文件
     *
     * @param jobExecuteContext
     * @return
     */
    @Override
    public ClientCommonResult handle(JobExecuteContext jobExecuteContext) {
        logger.info("从OSS开始下载当天还款.txt文件,并解析,更新数据库状态");
        String fileName = "PaymentResult" + DateUtils.dateToString(DateUtils.today(), DateUtils.SDF_YMD_PATTERN);
        File dir = new File(FILE_PATH);
        //创建ams文件夹
        CommonUtils.judeDirExists(dir);
        String filePath = FILE_PATH + "/" + fileName + ".txt";
        logger.info("生成的文件路径: " + filePath);
        // 从OSS下载当天还款.txt文件
        OSSClient ossClient = null;
        ObjectMetadata object = null;
        try {
            ossClient = OSSUtils.getOSSClient();
            String key="home/leex/upload/"+fileName+ ".txt";
            object = ossClient.getObject(new GetObjectRequest(BACKET_NAME, key), new File(filePath));
            logger.info(key+"取到的对象为："+object);
        } catch (Exception e) {
            logger.info("从OSS下载当天还款.txt文件失败: ",e);
            e.printStackTrace();
        }
        logger.info("从OSS下载当天还款.txt文件成功");

        //从本地解析txt文件,获取扣款状态码,对数据库中还款计划表进行更新状态
        //通过借款编号(boId),期数编号(periodNum),商家渠道编码(orgId)来确定数据唯一性,如扣款成功1,则修改还款状态为2(正常还款结清)
        AccountUpdateReqForm form = new AccountUpdateReqForm();
        //设置为正常代扣
        form.setApplyUpdateType("7");
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int x = 0;//总条数
                int y=0;//成功条数
                int i=0;//失败条数
                ArrayList<String> strList = new ArrayList<>();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    strList.add(lineTxt);
                }
                for(int j=1;j<strList.size();j++){
                   String str = strList.get(j);
                   logger.info("取到的数据："+str);
                    String[] strs = str.split("\\|");
                    form.setBoId(strs[1]);    //借款编号(boId)
                    form.setPeriodNum(strs[3]);   //期数编号(periodNum)
                    form.setOrgId(strs[4]);     //商户渠道编码(orgId)
//                        form.setUserId(strs[length-1]);     //借款人ID
                    String payAmt = strs[6];
                    logger.info("payAmt:"+payAmt);
                    if (StringUtils.isNotBlank(payAmt)&&!"null".equals(payAmt)){
                        form.setPayAmt(new BigDecimal(payAmt).setScale(2, BigDecimal.ROUND_UP));
                    }
                    form.setRetCode(strs[9]);       //code:1成功,其余失败
                    logger.info("更新前传入第" + (++x) + "条数据是: " + form.toString());
                    ResponseData<AccountUpdateRespForm> responseData = accountRestFacade.accountUpdate(form);
                    if ("000000".equals(responseData.getReturn_code())){
                        if ("1".equals(responseData.getData().getUpdateStatus())){
                            ++y;
                        }else{
                            ++i;
                        }
                    }else {
                        ++i;
                    }
                }
                logger.info("一共："+x+"条数据");
                logger.info("更新成功："+y+"条");
                logger.info("更新失败："+i+"条");
                read.close();
            } else {
                logger.info("找不到指定的文件");
            }
        } catch (Exception e) {
            logger.error("读取文件内容出错,更新失败: ", e);
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
        return "ossDownloadAccountJob";
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}

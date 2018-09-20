package com.dzjk.ams.endpoint.job;

import com.alipay.antschedulerclient.common.ClientCommonResult;
import com.alipay.antschedulerclient.handler.ISimpleJobHandler;
import com.alipay.antschedulerclient.model.JobExecuteContext;
import com.aliyun.oss.OSSClient;
import com.dzjk.ams.core.common.enums.PlanRepayStatus;
import com.dzjk.ams.core.common.util.CommonUtils;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.core.common.util.OSSUtils;
import com.dzjk.ams.dal.dao.AccountEarningsDAO;
import com.dzjk.ams.dal.dao.AccountRepayPlanDAO;
import com.dzjk.ams.dal.dataobject.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by daixiaohu on 2018/3/16.
 */

/**
 * 上传
 */
public class DzjkAccountJob implements ISimpleJobHandler {
    private static Logger logger = LoggerFactory.getLogger(DzjkAccountJob.class);
    @Value("${BACKET_NAME}")
    private static String BACKET_NAME ;

    ThreadPoolExecutor threadPoolExecutor;
    @Resource
    private AccountRepayPlanDAO accountRepayPlanDAO;
    @Resource
    private AccountEarningsDAO accountEarningsDAO;
    private static String FILE_PATH="/home/admin/ossams";
    /**
     * 生成还款扣款.txt文件,并上传到oss
     * @param jobExecuteContext
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ClientCommonResult handle(JobExecuteContext jobExecuteContext) {
        logger.info("还款扣款.txt文件开始上传OSS");
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("repayDate",DateUtils.getTomorrow());
        //通过比对当期时间来获取数据集合
        List<TodayRepaymentDO> list = accountRepayPlanDAO.selectByAccountRepayPlanRepaymentDO(params);
        String fileName = "Payment" + DateUtils.dateToString(DateUtils.today(), DateUtils.SDF_YMD_PATTERN);
        File dir = new File(FILE_PATH);
        //创建ams文件夹
        CommonUtils.judeDirExists(dir);
        //文件存放路径 home/admin/ams
        String fullPath = FILE_PATH + "/" + fileName + ".txt";
        logger.info("文件路径: "+fullPath);
        FileWriter out = null;
        try {
            out = new FileWriter(fullPath, false);
            String title="序号|借款编号|借据编号|期数编号|商户编码|借款人ID|还款绑定账号|还款账号开户名|还款账号开户行|还款账号预留手机号|出借人绑定账号|"+
                    "出借人开户名|出借人开户行|出借人预留手机号|代扣总金额|当期应收本金|当期应收利息|应收服务费用|应收罚息或违约费用|计划收款日|";
            out.write(title);
            out.write("\r\n");
            //判断是否有对象
            if (list != null && list.size() > 0) {
                logger.info("取出数据"+list.size()+"条");
                for (TodayRepaymentDO attribute : list) {
                    //还款金额 = 应还本金+应还利息+服务费+罚息
                    BigDecimal loanAmount = attribute.getCapitalAmount().add(attribute.getInterestAmount())
                            .add(attribute.getServiceFee()).add(attribute.getPunishFee());
                    Date date = attribute.getRepayDate();
                    String repayDate = DateUtils.format(date, "yyyyMMdd");
                    String s = attribute.getId() + "|" + attribute.getBoId() + "|" + attribute.getContractNo() + "|" +
                            attribute.getPeriodNum() + "|" + attribute.getOrgId() + "|" + attribute.getUserId() + "|" +
                            attribute.getRepayAccountNo() + "|" + attribute.getRepayAccountName() + "|" + attribute.getRepayAcctBank()
                            + "|" + attribute.getRepayAcctPhone() + "|" + attribute.getLoanAcctNo() + "|" + attribute.getLoanAcctName() + "|"
                            + attribute.getLoanAcctBank() + "|" + attribute.getLoanAcctPhone() + "|" + loanAmount + "|" +
                            attribute.getCapitalAmount() + "|" + attribute.getInterestAmount() + "|" + attribute.getServiceFee() + "|" +
                            attribute.getPunishFee() + "|" + repayDate + "|";
                    out.write(s);
                    out.write("\r\n");

                    AccountRepayPlanDO planDO = new AccountRepayPlanDO();
                    planDO.setBoId(attribute.getBoId());
                    planDO.setPeriodNum(attribute.getPeriodNum());
                    planDO.setOrgId(Long.valueOf(attribute.getOrgId()));
                    planDO.setRepayStatus(PlanRepayStatus.WITHHOLDING.getCode());//代扣中
                    accountRepayPlanDAO.updateStatus(planDO);

                    AccountEarningsDO earningsDO = new AccountEarningsDO();
                    earningsDO.setBoId(attribute.getBoId());
                    earningsDO.setPeriodNum(attribute.getPeriodNum());
                    earningsDO.setOrgId(Long.valueOf(attribute.getOrgId()));
                    earningsDO.setRepayStatus(PlanRepayStatus.WITHHOLDING.getCode());//代扣中
                    accountEarningsDAO.updateStatus(earningsDO);
                }
            }
            out.flush();
            out.close();
            logger.info("写入文件内容成功");
            //获取文件,上传OSS
            File file =new File(fullPath);
            OSSClient ossClient = OSSUtils.getOSSClient();
            ossClient.putObject(BACKET_NAME,"home/leex/upload/"+fileName+ ".txt",file);
            logger.info("还款扣款.txt文件上传OSS成功");
        } catch (IOException e) {
            logger.error("还款扣款.txt文件上传OSS失败: ",e);
        }catch (Exception e){
            logger.error("还款扣款.txt文件上传OSS失败: ",e);
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
        return "dzjkAccountJob";
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}

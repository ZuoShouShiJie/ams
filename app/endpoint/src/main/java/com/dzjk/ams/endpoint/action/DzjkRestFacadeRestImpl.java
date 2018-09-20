package com.dzjk.ams.endpoint.action;

import com.alibaba.fastjson.JSON;
import com.dzjk.ams.core.common.ResultConstants;
import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.core.common.util.RouteUtil;
import com.dzjk.ams.dal.dao.AccountingDAO;
import com.dzjk.ams.dal.dao.UniqueCheckDAO;
import com.dzjk.ams.dal.dataobject.AccountingDO;
import com.dzjk.ams.dal.dataobject.UniqueCheckDO;
import com.dzjk.ams.endpoint.share.converter.TestSplitTable;
import com.dzjk.ams.facade.api.DzjkRestFacade;
import com.dzjk.ams.facade.base.DefaultFacadeResp;
import com.dzjk.ams.facade.base.ResultCommonFacadeResp;
import com.dzjk.ams.facade.form.QueryReqForm;
import com.dzjk.ams.facade.model.AccountingModel;
import com.dzjk.ams.facade.model.DemoUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author climb.s
 * @date 2018/2/6 10:00
 */
public class DzjkRestFacadeRestImpl implements DzjkRestFacade {

    private static final Logger logger = LoggerFactory.getLogger(DzjkRestFacadeRestImpl.class);

    private UniqueCheckDAO uniqueCheckDAO;

    private AccountingDAO accountingDAO;

    @Value("${com.dzjk}")
    private String comDzjk;

    @Override
    public ResultCommonFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException {

        DemoUserModel demoUserModel = new DemoUserModel();

        demoUserModel.setRealName("Real " + userName);
        demoUserModel.setUserName(userName +"------" +comDzjk);

        ResultCommonFacadeResp<DemoUserModel> result = new ResultCommonFacadeResp<DemoUserModel>();
        result.setData(demoUserModel);
        result.setResultCode(ResultConstants.SUCCESS_RESULT);
        return result;
    }

    @Override
    public String query(QueryReqForm form){
        return comDzjk+'-'+form.getName()+'-'+form.getAge();
    }

    @Override
    public Map<String, Object> queryAddress(String custId)
            throws IOException {
        Map<String,Object> returnMap=new HashMap<String, Object>();
        // 客户默认地址信息
        try{
        }catch (Exception e) {
            logger.info(e.getMessage());
            returnMap.put("responseCode", "0001");
            returnMap.put("responseMsg", "查询默认地址出现系统错误"+e.getMessage().toString());
        }
        return returnMap;

    }

    @Override
    public String redisQuery(QueryReqForm form){

        JedisPoolConfig config = new JedisPoolConfig();
        //最大空闲连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
        config.setMaxIdle(200);
        //最大连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
        config.setMaxTotal(2000);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        String host = "r-zm0cb150cb4e4314.redis.rds.aliyuncs.com";
        String password = "maiziJF2017";
        JedisPool pool = new JedisPool(config, host, 6379, 3000, password);
        Jedis jedis = null;
        String xiaoye;
        try {
            jedis = pool.getResource();
            jedis.set("xiaoye", form.getName());
            xiaoye = jedis.get("xiaoye");
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        pool.destroy();
        return xiaoye;

    }

    @Override
    public String UniqueLoadAll() {
        UniqueCheckDO uniqueCheckDO = uniqueCheckDAO.getByPrimary("test");
        return JSON.toJSONString(uniqueCheckDO);
    }

    @Override
    public DefaultFacadeResp testSplitTable(AccountingModel model) {
        AccountingDO accountingDO = TestSplitTable.reConverter(model);
        accountingDO.setRoute(RouteUtil.getRoute(accountingDO.getId()));
        Long flag = accountingDAO.insertByRoute(accountingDO);
        DefaultFacadeResp resp = new DefaultFacadeResp(true);
        resp.setResultMsg("生成账务成功");
        resp.setRequestId("00000");
        if (flag <= 0) {
            resp.setSuccess(false);
            resp.setRequestId("00001");
            resp.setResultMsg("生成账务失败");
        }
        return resp;
    }

    public void setUniqueCheckDAO(UniqueCheckDAO uniqueCheckDAO) {
        this.uniqueCheckDAO = uniqueCheckDAO;
    }

    public void setAccountingDAO(AccountingDAO accountingDAO) {
        this.accountingDAO = accountingDAO;
    }
}

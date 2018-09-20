package com.dzjk.ams.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import com.alibaba.fastjson.JSON;
import com.dzjk.ams.facade.api.MqRestFacade;
import com.dzjk.ams.facade.base.DefaultFacadeResp;
import com.dzjk.ams.facade.base.RestSampleFacadeResp;
import com.dzjk.ams.facade.model.AccountingModel;
import com.dzjk.ams.facade.model.MqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.api.DzjkRestFacade;
import com.dzjk.ams.facade.form.QueryReqForm;

/**
 * @author climb.s
 * @date 2018/2/6 09:57
 */
@RestController
@RequestMapping("/rpc")
public class RpcController {

    @Autowired
    private DzjkRestFacade dzjkRestFacade;
    @Autowired
    private MqRestFacade mqRestFacade;

    @GET
    @RequestMapping("/dzjk/query")
    public String query(QueryReqForm form, HttpServletRequest request) throws CommonException {
        return this.dzjkRestFacade.query(form);
    }

    @GET
    @RequestMapping("/dzjk/query/userInfo")
    public String userInfo(QueryReqForm form, HttpServletRequest request) throws CommonException {
        return this.dzjkRestFacade.userInfo(form.getName()).toString();
    }

    @GET
    @RequestMapping("/dzjk/query/address")
    public Map<String, Object> queryAddr(String custId, HttpServletRequest request) throws CommonException, IOException {
        System.out.println("address.....");
        return this.dzjkRestFacade.queryAddress(custId);
    }

    @GET
    @RequestMapping("/dzjk/query/redis")
    public String queryRedis(QueryReqForm form, HttpServletRequest request) throws CommonException, IOException {
        System.out.println("redis.....");
        return this.dzjkRestFacade.redisQuery(form);
    }

    @GET
    @RequestMapping("/ams/query/redis")
    public String uniqueLoadAll(){
        return this.dzjkRestFacade.UniqueLoadAll();
    }

    @GET
    @RequestMapping("/ams/create/accounting")
    public DefaultFacadeResp testSplitTable(String json, HttpServletRequest request){
        return this.dzjkRestFacade.testSplitTable(JSON.parseObject(json, AccountingModel.class));
    }

    @GET
    @RequestMapping("/dzjk/query/mq")
    public RestSampleFacadeResp<MqMessage> queryMq() throws Exception {
        System.out.println("mq.....");
        return this.mqRestFacade.publish();
    }

}
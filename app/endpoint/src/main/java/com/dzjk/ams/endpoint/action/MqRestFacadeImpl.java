package com.dzjk.ams.endpoint.action;



import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.model.MqMessage;
import com.dzjk.ams.endpoint.service.Account;
import com.dzjk.ams.endpoint.service.MqMessageRepository;
import com.dzjk.ams.endpoint.service.MqService;
import com.dzjk.ams.facade.api.MqRestFacade;
import com.dzjk.ams.facade.base.RestSampleFacadeResp;
import com.sun.istack.logging.Logger;

import java.util.List;

//@Component("mqRestFacade")
public class MqRestFacadeImpl implements MqRestFacade {
	
	Logger logger = Logger.getLogger(this.getClass());

    private final static String TOPIC     = "TP_AMS";

    private final static String EVENTCODE = "EC_AMS";

    private MqService mqService;

    @Override
    public RestSampleFacadeResp<MqMessage> publish() throws CommonException {
   
        logger.info("Receive a message publish request.");
        boolean success=false;
        
        Object payload = Account.buildDefaultInstance();

        try{
        	logger.info("Receive a message publish request 1."+payload.toString());
        	success = mqService.publish(TOPIC, EVENTCODE, payload);
        } catch (Exception e) {
        	logger.info("Receive a message publish request failed."+e.getMessage());	
        }
        RestSampleFacadeResp<MqMessage> result = new RestSampleFacadeResp<>();
        MqMessage mqMessage = new MqMessage(TOPIC, EVENTCODE, payload);
        logger.info("Receive a message publish request 2."+mqMessage.toString());
        result.setData(mqMessage);
        result.setSuccess(Boolean.valueOf(success));
        return result;
    }

    @Override
    public RestSampleFacadeResp<List<MqMessage>> subscribe() throws Exception {

        logger.info("Receive a message subscribe request.");

        RestSampleFacadeResp<List<MqMessage>> result = new RestSampleFacadeResp<>();
        result.setData(MqMessageRepository.getInstance().queryAll());
        result.setSuccess(true);
        return result;
    }

    public void setMqService(MqService mqService) {
        this.mqService = mqService;
    }

}

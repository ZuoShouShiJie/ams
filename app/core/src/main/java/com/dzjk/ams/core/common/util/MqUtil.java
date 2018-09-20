package com.dzjk.ams.core.common.util;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventBuilder;
import com.alipay.common.event.UniformEventPublisher;
import com.alipay.common.event.impl.DefaultUniformEventBuilder;
import com.dzjk.ams.core.common.QueryReqForm;

import java.util.logging.Logger;

public class MqUtil {
	 /** 
     * 默认日志打印logger
     */  
	public static Logger logger = Logger.getLogger("logger_mq_default");
	
	private final String   TOPIC               = "TP_AMS";
    private final String   EVENTCODE           = "EC_AMS";
    private UniformEventPublisher mqPublisher;
    private UniformEventBuilder   uniformEventBuilder = new DefaultUniformEventBuilder();
    public boolean publish(QueryReqForm form) {
         logger.info("Publish a AMS message...");
         System.out.println("Publish a AMS message...");
        /* Create a message instance. */
        final UniformEvent message = uniformEventBuilder.buildUniformEvent(TOPIC, EVENTCODE);
        /* Set the business object as an event payload. */
        message.setEventPayload(buildDefaultMsg(form));
        /* Mark that a runtime exception must be thrown when publishing failure. */
        message.setThrowExceptionOnFailed(true);
        boolean publishSuccess = false;
        try {
            /* Do publish action. */
            mqPublisher.publishUniformEvent(message);
            publishSuccess = true;
            logger.info("Public a message, success. TOPIC TP_AMS 1");
            System.out.println("Public a message, success. TOPIC TP_AMS 1");
        } catch (Exception e) {
            logger.info("Public a message, failure. TOPIC TP_AMS 2"+e.getMessage());
        }
        System.out.println("Public a message, failure. TOPIC TP_AMS 3 : " + publishSuccess);
        return publishSuccess;
    }
    public QueryReqForm buildDefaultMsg(QueryReqForm form) {
    	QueryReqForm amsForm = new QueryReqForm();
    	amsForm.setAge(form.getAge());
    	amsForm.setName(form.getName());
        return amsForm;
    }
    public void setMqPublisher(UniformEventPublisher mqPublisher) {
        this.mqPublisher = mqPublisher;
    }
}

package com.dzjk.ams.endpoint.service;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventBuilder;
import com.alipay.common.event.UniformEventPublisher;
import com.alipay.common.event.impl.DefaultUniformEventBuilder;
import com.sun.istack.logging.Logger;

public class MqService {
	

    private final Logger logger  =  Logger.getLogger(this.getClass());

    private UniformEventPublisher mqPublisher;

    private UniformEventBuilder uniformEventBuilder = new DefaultUniformEventBuilder();

    public boolean publish(String topic, String eventcode, Object payload) {

            logger.info("Publish a message.");
     

        /* Create a message instance. */
        final UniformEvent message = uniformEventBuilder.buildUniformEvent(topic, eventcode);

        /* Set the business object as an event payload. */
        message.setEventPayload(payload);

        /* Mark that a runtime exception must be thrown when publishing failure. */
        message.setThrowExceptionOnFailed(true);

        boolean publishSuccess = false;

        try {
            /* Do publish action. */
            mqPublisher.publishUniformEvent(message);
            publishSuccess = true;

            logger.info("Public a message, success. TOPIC TP_AMS 1");
        } catch (Exception e) {
        	logger.info("Public a message, failure. TOPIC TP_AMS 2"+e.getMessage());
        }
        
        return publishSuccess;
    }

    public void setMqPublisher(UniformEventPublisher mqPublisher) {
        this.mqPublisher = mqPublisher;
    }

}

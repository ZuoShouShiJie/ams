package com.dzjk.ams.endpoint.service;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventContext;
import com.alipay.common.event.UniformEventMessageListener;
import com.dzjk.ams.facade.model.MqMessage;
import com.sun.istack.logging.Logger;

public class MqMessageListener implements UniformEventMessageListener {
	
	Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void onUniformEvent(UniformEvent message, UniformEventContext context) throws Exception {

        /* get TOPIC, EVENTCODE and payload from the message instance */
        final String topic = message.getTopic();
        final String eventcode = message.getEventCode();
        final String id = message.getId();
        final Object businessObject = message.getEventPayload();

        logger.info("Receive a message, TOPIC [{}] EVENTCODE [{}] id [{}] payload [{}]", new Object[] { topic,
                eventcode, id, businessObject });

        save(message);

        try {
            boolean processSuccess = processMessage(businessObject);

            if (!processSuccess) {
                /* Process the message failure, set cause and rollback, the message is re-delivered later. */
                context.setContextDesc("process error cause");
                context.setRollbackOnly();
            }
        } catch (Exception e) {
            logger.info("Process a message, failure."+e.getMessage());
            /* When any exception is thrown, the message is re-delivered later. */
            throw e;
        }
    }

    /* Process the business logic */
    private boolean processMessage(Object businessObject) {
        return true;
    }

    private void save(UniformEvent message) {
        MqMessage mqMessage = new MqMessage(message.getTopic(), message.getEventCode(), message.getEventPayload());
        MqMessageRepository.getInstance().add(mqMessage);
    }


}

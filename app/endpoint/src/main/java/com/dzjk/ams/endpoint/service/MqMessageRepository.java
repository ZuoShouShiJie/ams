package com.dzjk.ams.endpoint.service;


import com.dzjk.ams.facade.model.MqMessage;

import java.util.ArrayList;
import java.util.List;

public class MqMessageRepository {
	
	private static MqMessageRepository repo     = new MqMessageRepository();

    private List<MqMessage>            messages = new ArrayList<MqMessage>(10);

    private MqMessageRepository() {
    }

    public static MqMessageRepository getInstance() {
        return repo;
    }

    public void add(MqMessage mqMessage) {
        messages.add(mqMessage);
    }

    public List<MqMessage> queryAll() {
        return messages;
    }

}

package com.dzjk.ams.facade.base;

import com.basic.framework.core.base.AbstractModel;

/**
 * Created by daixiaohu on 2018/6/4.
 */
public class CommonResponse extends AbstractModel {
private Message message;
    private Object data;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

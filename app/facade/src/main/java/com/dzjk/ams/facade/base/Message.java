package com.dzjk.ams.facade.base;

import com.basic.framework.core.base.AbstractModel;

/**
 * Created by daixiaohu on 2018/6/4.
 */
public class Message extends AbstractModel {
    private String status;
    private String desc;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

/**
 * Created by daixiaohu on 2018/3/5.
 */
public class CreateAccountRespForm extends BaseVo {
    private String userId;
    private String boId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }
}

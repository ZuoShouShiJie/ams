package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public class AccountUpdateRespForm extends BaseVo {
    private long updateStatus;

    public long getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(long updateStatus) {
        this.updateStatus = updateStatus;
    }
}

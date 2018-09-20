package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

/**
 * Created by daixiaohu on 2018/8/23.
 */
public class CapitalCostTrialReqForm extends BaseVo {
    private String amount    ;
    private String period    ;
    private String type      ;
    private String price     ;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

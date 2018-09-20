package com.dzjk.ams.facade.model;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/15.
 */
public class FeeVo {
    private String feeName;
    private BigDecimal feeAmount;

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }
}

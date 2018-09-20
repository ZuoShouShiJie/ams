package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.PreRepayTryVo;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/12.
 */
public class PreRepayTryRespForm extends BaseVo {
    private String userName;
    private String idType;
    private String idNo;
    private String boId;
    private String preRepayApplyDate;
    private BigDecimal preRepayAmount;
    private BigDecimal preRepayCapitalLeft;
    private BigDecimal preRepayInterest;
    private BigDecimal preRepayFine;
    private BigDecimal overDueFine;
    private BigDecimal preRepayServiceFee0;
    private BigDecimal preRepayServiceFee1;
    private BigDecimal preRepayServiceFee2;
    private BigDecimal preRepayServiceFee3;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getPreRepayApplyDate() {
        return preRepayApplyDate;
    }

    public void setPreRepayApplyDate(String preRepayApplyDate) {
        this.preRepayApplyDate = preRepayApplyDate;
    }

    public BigDecimal getPreRepayAmount() {
        return preRepayAmount;
    }

    public void setPreRepayAmount(BigDecimal preRepayAmount) {
        this.preRepayAmount = preRepayAmount;
    }

    public BigDecimal getPreRepayCapitalLeft() {
        return preRepayCapitalLeft;
    }

    public void setPreRepayCapitalLeft(BigDecimal preRepayCapitalLeft) {
        this.preRepayCapitalLeft = preRepayCapitalLeft;
    }

    public BigDecimal getPreRepayInterest() {
        return preRepayInterest;
    }

    public void setPreRepayInterest(BigDecimal preRepayInterest) {
        this.preRepayInterest = preRepayInterest;
    }

    public BigDecimal getPreRepayFine() {
        return preRepayFine;
    }

    public void setPreRepayFine(BigDecimal preRepayFine) {
        this.preRepayFine = preRepayFine;
    }

    public BigDecimal getOverDueFine() {
        return overDueFine;
    }

    public void setOverDueFine(BigDecimal overDueFine) {
        this.overDueFine = overDueFine;
    }

    public BigDecimal getPreRepayServiceFee0() {
        return preRepayServiceFee0;
    }

    public void setPreRepayServiceFee0(BigDecimal preRepayServiceFee0) {
        this.preRepayServiceFee0 = preRepayServiceFee0;
    }

    public BigDecimal getPreRepayServiceFee1() {
        return preRepayServiceFee1;
    }

    public void setPreRepayServiceFee1(BigDecimal preRepayServiceFee1) {
        this.preRepayServiceFee1 = preRepayServiceFee1;
    }

    public BigDecimal getPreRepayServiceFee2() {
        return preRepayServiceFee2;
    }

    public void setPreRepayServiceFee2(BigDecimal preRepayServiceFee2) {
        this.preRepayServiceFee2 = preRepayServiceFee2;
    }

    public BigDecimal getPreRepayServiceFee3() {
        return preRepayServiceFee3;
    }

    public void setPreRepayServiceFee3(BigDecimal preRepayServiceFee3) {
        this.preRepayServiceFee3 = preRepayServiceFee3;
    }
}

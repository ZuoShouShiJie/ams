package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public class ManualRepayReqForm extends BaseVo {
    private String userName;
    private String idType;
    private String idNo;
    private String userId;
    private String orgId;
    private String boId;
    private String repayType;
    private String periodNum;
    private String serialNumber;
    private BigDecimal preRepayAmount;
    private String applyDate;
    private String applyTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPreRepayAmount() {
        return preRepayAmount;
    }

    public void setPreRepayAmount(BigDecimal preRepayAmount) {
        this.preRepayAmount = preRepayAmount;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}

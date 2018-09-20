package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/19.
 */
public class CreateAccountReqFormTest extends BaseVo {
    private String userId;
    private String userName;
    private String idType;
    private String idNo;
    private String mobile;
    private String orgId;
    private String boId;
    private String productCode;
    private BigDecimal loanAmount;
    private BigDecimal lendAmount;
    private String repayRate;
    private String applyTime;
    private String applyDate;
    private String lendDate;
    private String lendTime;
    private String repayAcctNo;
    private String repayAcctName;
    private String repayAcctBank;
    private String repayAcctPhone;
    private String repayDate;
    private String repayPeriod;

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLendAmount() {
        return lendAmount;
    }

    public void setLendAmount(BigDecimal lendAmount) {
        this.lendAmount = lendAmount;
    }

    public String getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(String repayRate) {
        this.repayRate = repayRate;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getRepayAcctNo() {
        return repayAcctNo;
    }

    public void setRepayAcctNo(String repayAcctNo) {
        this.repayAcctNo = repayAcctNo;
    }

    public String getRepayAcctName() {
        return repayAcctName;
    }

    public void setRepayAcctName(String repayAcctName) {
        this.repayAcctName = repayAcctName;
    }

    public String getRepayAcctBank() {
        return repayAcctBank;
    }

    public void setRepayAcctBank(String repayAcctBank) {
        this.repayAcctBank = repayAcctBank;
    }

    public String getRepayAcctPhone() {
        return repayAcctPhone;
    }

    public void setRepayAcctPhone(String repayAcctPhone) {
        this.repayAcctPhone = repayAcctPhone;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(String repayPeriod) {
        this.repayPeriod = repayPeriod;
    }
}

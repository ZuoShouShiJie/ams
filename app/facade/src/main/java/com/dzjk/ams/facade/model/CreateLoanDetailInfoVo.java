package com.dzjk.ams.facade.model;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/5.
 */
public class CreateLoanDetailInfoVo extends BaseVo{
    private String boId;
    private String productCode;
    private BigDecimal loanAmount;
    private BigDecimal lendAmount;
    private String repayRate;
    private String applyDate;
    private String applyTime;
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

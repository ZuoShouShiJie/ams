package com.dzjk.ams.facade.model;

import java.math.BigDecimal;

/**
 * Created by daixiaohu on 2018/3/2.
 */
public class TrialDetailListVo extends BaseVo{
    private String periodNum;
    private BigDecimal capitalAmount;
    private BigDecimal interestAmount;
    private BigDecimal serviceFee;
    private String repayDate;
    private BigDecimal totalCapitalLeft;
    private BigDecimal totalCapitalAccu;
    private BigDecimal interestAccu;
    private BigDecimal serviceFeeAccu;

    public String getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum;
    }

    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getTotalCapitalLeft() {
        return totalCapitalLeft;
    }

    public void setTotalCapitalLeft(BigDecimal totalCapitalLeft) {
        this.totalCapitalLeft = totalCapitalLeft;
    }

    public BigDecimal getTotalCapitalAccu() {
        return totalCapitalAccu;
    }

    public void setTotalCapitalAccu(BigDecimal totalCapitalAccu) {
        this.totalCapitalAccu = totalCapitalAccu;
    }

    public BigDecimal getInterestAccu() {
        return interestAccu;
    }

    public void setInterestAccu(BigDecimal interestAccu) {
        this.interestAccu = interestAccu;
    }

    public BigDecimal getServiceFeeAccu() {
        return serviceFeeAccu;
    }

    public void setServiceFeeAccu(BigDecimal serviceFeeAccu) {
        this.serviceFeeAccu = serviceFeeAccu;
    }
}

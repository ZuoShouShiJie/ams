package com.dzjk.ams.facade.model;


import com.alibaba.fastjson.JSONArray;
import org.apache.james.mime4j.field.datetime.DateTime;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by daixiaohu on 2018/2/28.
 */
public class QueryRepayPlanVo extends BaseVo{
    private String periodNum;
    private BigDecimal capitalAmount;
    private BigDecimal interestAmount;
    private BigDecimal serviceFee;
    private String serviceFeeDetails;
    private String repayDate;
    private String repaidDate;
    private String repayStatus;
    private String overdueDay;
    private BigDecimal totalCapitalLeft;
    private BigDecimal totalCapitalAccu;
    private BigDecimal interestAccu;
    private BigDecimal serviceFeeAccu;
    private BigDecimal fineAccu;
    private String fineUpdatedTime;

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

    public String getServiceFeeDetails() {
        return serviceFeeDetails;
    }

    public void setServiceFeeDetails(String serviceFeeDetails) {
        this.serviceFeeDetails = serviceFeeDetails;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepaidDate() {
        return repaidDate;
    }

    public void setRepaidDate(String repaidDate) {
        this.repaidDate = repaidDate;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(String overdueDay) {
        this.overdueDay = overdueDay;
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

    public BigDecimal getFineAccu() {
        return fineAccu;
    }

    public void setFineAccu(BigDecimal fineAccu) {
        this.fineAccu = fineAccu;
    }

    public String getFineUpdatedTime() {
        return fineUpdatedTime;
    }

    public void setFineUpdatedTime(String fineUpdatedTime) {
        this.fineUpdatedTime = fineUpdatedTime;
    }
}

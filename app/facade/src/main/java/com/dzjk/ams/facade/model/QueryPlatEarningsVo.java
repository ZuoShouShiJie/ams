package com.dzjk.ams.facade.model;

import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public class QueryPlatEarningsVo extends BaseVo{
    private String boId;
    private String periodNum;
    private String orgId;
    private String isFullFee;
    private BigDecimal totalServiceFee;
    private BigDecimal capitalAmount;
    private String  totalServiceFeeDetails;
    private BigDecimal interestAmount;
    private String repayDate;
    private String repaidDate;
    private String repayStatus;
    private String overdueDay;
    private BigDecimal serviceFeeAccu;
    private BigDecimal fineAccu;
    private String fineUpdatedTime;
    private BigDecimal serviceFee;
    private BigDecimal fine;

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public String getTotalServiceFeeDetails() {
        return totalServiceFeeDetails;
    }

    public void setTotalServiceFeeDetails(String totalServiceFeeDetails) {
        this.totalServiceFeeDetails = totalServiceFeeDetails;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(String periodNum) {
        this.periodNum = periodNum;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIsFullFee() {
        return isFullFee;
    }

    public void setIsFullFee(String isFullFee) {
        this.isFullFee = isFullFee;
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

    public BigDecimal getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(BigDecimal totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
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

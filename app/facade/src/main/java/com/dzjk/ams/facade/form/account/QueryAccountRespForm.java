
package com.dzjk.ams.facade.form.account;
import com.dzjk.ams.facade.model.BaseVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by daixiaohu on 2018/2/11.
 */
public class QueryAccountRespForm extends BaseVo {
    private String userName;
    private String idType;
    private String idNo;
    private String orgId;
    private String boId;
    private BigDecimal totalCapital;
    private BigDecimal totalInterest;
    private BigDecimal totalServiceFee;
    private BigDecimal totalFine;
    private String repayDate;
    private String repayPeriod;
    private String firstRepayDate;
    private String lastRepayDate;
    private String repayStatus;
    private String nextRepayDate;
    private String overdueTimes;
    private String maxOverdueDay;
    private String currOverdueDay;

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

    public BigDecimal getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(BigDecimal totalCapital) {
        this.totalCapital = totalCapital;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(BigDecimal totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public BigDecimal getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(BigDecimal totalFine) {
        this.totalFine = totalFine;
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


    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getFirstRepayDate() {
        return firstRepayDate;
    }

    public void setFirstRepayDate(String firstRepayDate) {
        this.firstRepayDate = firstRepayDate;
    }

    public String getLastRepayDate() {
        return lastRepayDate;
    }

    public void setLastRepayDate(String lastRepayDate) {
        this.lastRepayDate = lastRepayDate;
    }

    public String getNextRepayDate() {
        return nextRepayDate;
    }

    public void setNextRepayDate(String nextRepayDate) {
        this.nextRepayDate = nextRepayDate;
    }

    public String getOverdueTimes() {
        return overdueTimes;
    }

    public void setOverdueTimes(String overdueTimes) {
        this.overdueTimes = overdueTimes;
    }

    public String getMaxOverdueDay() {
        return maxOverdueDay;
    }

    public void setMaxOverdueDay(String maxOverdueDay) {
        this.maxOverdueDay = maxOverdueDay;
    }

    public String getCurrOverdueDay() {
        return currOverdueDay;
    }

    public void setCurrOverdueDay(String currOverdueDay) {
        this.currOverdueDay = currOverdueDay;
    }
}

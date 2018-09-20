package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 当天还款实体类
 */
public class TodayRepaymentDO implements Serializable{

    private String id; //序号
    private String userId;  //借款人ID
    private String brUserId;    //出借人账号
    private String repayAcctBank;   //还款账号开户行
    private String repayAcctPhone;  //还款账号预留手机号
    private String boId;  //借款编号
    private String contractNo; //借据编号
    private String periodNum;  //还款期数
    private String orgId;   //商户渠道编码
    private Date repayDate;  //还款日期
    private BigDecimal capitalAmount;   //应还本金
    private BigDecimal interestAmount;  //应还利息
    private BigDecimal serviceFee;      //服务费
    private BigDecimal punishFee;      //罚息
    private BigDecimal loanAmount;  //还款总金额 = 应还本金+应还利息+服务费+罚息
    private String repayAccountNo;  //还款账户
    private String repayAccountName;  //还款账户名
    private String repayStatus;  //扣款状态(还款状态)
    private String repayMessage;  //扣款信息
    private String loanAcctNo;  //出借人绑定账号
    private String loanAcctName;  //出借人开户名
    private String loanAcctBank;  //出借人开户行
    private String loanAcctPhone;  //出借人预留手机号


    public String getLoanAcctNo() {
        return loanAcctNo;
    }

    public void setLoanAcctNo(String loanAcctNo) {
        this.loanAcctNo = loanAcctNo;
    }

    public String getLoanAcctName() {
        return loanAcctName;
    }

    public void setLoanAcctName(String loanAcctName) {
        this.loanAcctName = loanAcctName;
    }

    public String getLoanAcctBank() {
        return loanAcctBank;
    }

    public void setLoanAcctBank(String loanAcctBank) {
        this.loanAcctBank = loanAcctBank;
    }

    public String getLoanAcctPhone() {
        return loanAcctPhone;
    }

    public void setLoanAcctPhone(String loanAcctPhone) {
        this.loanAcctPhone = loanAcctPhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBrUserId() {
        return brUserId;
    }

    public void setBrUserId(String brUserId) {
        this.brUserId = brUserId;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRepayMessage() {
        return repayMessage;
    }

    public void setRepayMessage(String repayMessage) {
        this.repayMessage = repayMessage;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
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

    public BigDecimal getPunishFee() {
        return punishFee;
    }

    public void setPunishFee(BigDecimal punishFee) {
        this.punishFee = punishFee;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getRepayAccountNo() {
        return repayAccountNo;
    }

    public void setRepayAccountNo(String repayAccountNo) {
        this.repayAccountNo = repayAccountNo;
    }

    public String getRepayAccountName() {
        return repayAccountName;
    }

    public void setRepayAccountName(String repayAccountName) {
        this.repayAccountName = repayAccountName;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }


}

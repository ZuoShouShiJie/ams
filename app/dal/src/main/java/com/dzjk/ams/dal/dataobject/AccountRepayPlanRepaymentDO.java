package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 还款扣款实体类
 */
public class AccountRepayPlanRepaymentDO implements Serializable{

    private Integer id;
    private String boId;  //借款编号
    private String contractNo; //借据编号
    private String orgId;   //商户渠道编码
    private String userId;  //借款人ID
    private String repayAcctBank;   //还款账号开户行
    private String repayAcctPhone;  //还款账号预留手机号
    private String brUserId;    //出借人账号
    private BigDecimal capitalAmount;   //应还本金
    private BigDecimal interestAmount;  //应还利息
    private BigDecimal serviceFee;      //服务费
    private BigDecimal punishFee;       //罚息
    private BigDecimal loanAmount;  //还款金额 = 应还本金+应还利息+服务费 + 罚息
    private Date repayDate;  //计划还款日
    private String repayAccountName;  //还款账户开户名
    private String repayAccountNo;  //还款绑定账户
    private Integer periodNum;  //还款期数

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBrUserId() {
        return brUserId;
    }

    public void setBrUserId(String brUserId) {
        this.brUserId = brUserId;
    }

    public BigDecimal getPunishFee() {
        return punishFee;
    }

    public void setPunishFee(BigDecimal punishFee) {
        this.punishFee = punishFee;
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

    public Integer getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(Integer periodNum) {
        this.periodNum = periodNum;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayAccountName() {
        return repayAccountName;
    }

    public void setRepayAccountName(String repayAccountName) {
        this.repayAccountName = repayAccountName;
    }

    public String getRepayAccountNo() {
        return repayAccountNo;
    }

    public void setRepayAccountNo(String repayAccountNo) {
        this.repayAccountNo = repayAccountNo;
    }

    public Integer getId() {

        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}

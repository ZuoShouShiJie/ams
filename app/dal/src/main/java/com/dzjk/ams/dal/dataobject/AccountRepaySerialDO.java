package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * The table AMS_ACCOUNT_REPAY_SERIAL
 */
public class AccountRepaySerialDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * boId 借款编号.
     */
    private String boId;
    /**
     * orgId 商户（渠道）编码.
     */
    private Long orgId;
    /**
     * status 状态.
     */
    private String status;
    /**
     * userId 借款人帐号.
     */
    private String userId;
    /**
     * createdBy CREATED_BY.
     */
    private String createdBy;
    /**
     * periodNum 期数编号.
     */
    private String periodNum;
    /**
     * repayTime 还款时间.
     */
    private Date repayTime;
    /**
     * repayType 还款类型：ALLPRE_REPAYED("1", "借款人全额提前还款账务结清"),.
     */
    private String repayType;
    /**
     * updatedBy UPDATED_BY.
     */
    private String updatedBy;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * repayAmount 还款金额.
     */
    private BigDecimal repayAmount;
    /**
     * repayStatus 还款状态(0:还款失败，1：还款成功，2：还款中).
     */
    private String repayStatus;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * serialNumber 流水号.
     */
    private String serialNumber;
    /**
     * capitalAmount 当期应还本金.
     */
    private BigDecimal capitalAmount;
    /**
     * interestAmount 当期应还利息.
     */
    private BigDecimal interestAmount;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set boId 借款编号.
     */
    public void setBoId(String boId){
        this.boId = boId;
    }

    /**
     * Get boId 借款编号.
     *
     * @return the string
     */
    public String getBoId(){
        return boId;
    }

    /**
     * Set orgId 商户（渠道）编码.
     */
    public void setOrgId(Long orgId){
        this.orgId = orgId;
    }

    /**
     * Get orgId 商户（渠道）编码.
     *
     * @return the string
     */
    public Long getOrgId(){
        return orgId;
    }

    /**
     * Set status 状态.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 状态.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set userId 借款人帐号.
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * Get userId 借款人帐号.
     *
     * @return the string
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Set createdBy CREATED_BY.
     */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    /**
     * Get createdBy CREATED_BY.
     *
     * @return the string
     */
    public String getCreatedBy(){
        return createdBy;
    }

    /**
     * Set periodNum 期数编号.
     */
    public void setPeriodNum(String periodNum){
        this.periodNum = periodNum;
    }

    /**
     * Get periodNum 期数编号.
     *
     * @return the string
     */
    public String getPeriodNum(){
        return periodNum;
    }

    /**
     * Set repayTime 还款时间.
     */
    public void setRepayTime(Date repayTime){
        this.repayTime = repayTime;
    }

    /**
     * Get repayTime 还款时间.
     *
     * @return the string
     */
    public Date getRepayTime(){
        return repayTime;
    }

    /**
     * Set repayType 还款类型：ALLPRE_REPAYED("1", "借款人全额提前还款账务结清"),.
     */
    public void setRepayType(String repayType){
        this.repayType = repayType;
    }

    /**
     * Get repayType 还款类型：ALLPRE_REPAYED("1", "借款人全额提前还款账务结清"),.
     *
     * @return the string
     */
    public String getRepayType(){
        return repayType;
    }

    /**
     * Set updatedBy UPDATED_BY.
     */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }

    /**
     * Get updatedBy UPDATED_BY.
     *
     * @return the string
     */
    public String getUpdatedBy(){
        return updatedBy;
    }

    /**
     * Set createdTime CREATED_TIME.
     */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }

    /**
     * Get createdTime CREATED_TIME.
     *
     * @return the string
     */
    public Date getCreatedTime(){
        return createdTime;
    }

    /**
     * Set repayAmount 还款金额.
     */
    public void setRepayAmount(BigDecimal repayAmount){
        this.repayAmount = repayAmount;
    }

    /**
     * Get repayAmount 还款金额.
     *
     * @return the string
     */
    public BigDecimal getRepayAmount(){
        return repayAmount;
    }

    /**
     * Set repayStatus 还款状态(0:还款失败，1：还款成功，2：还款中).
     */
    public void setRepayStatus(String repayStatus){
        this.repayStatus = repayStatus;
    }

    /**
     * Get repayStatus 还款状态(0:还款失败，1：还款成功，2：还款中).
     *
     * @return the string
     */
    public String getRepayStatus(){
        return repayStatus;
    }

    /**
     * Set updatedTime UPDATED_TIME.
     */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }

    /**
     * Get updatedTime UPDATED_TIME.
     *
     * @return the string
     */
    public Date getUpdatedTime(){
        return updatedTime;
    }

    /**
     * Set serialNumber 流水号.
     */
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Get serialNumber 流水号.
     *
     * @return the string
     */
    public String getSerialNumber(){
        return serialNumber;
    }

    /**
     * Set capitalAmount 当期应还本金.
     */
    public void setCapitalAmount(BigDecimal capitalAmount){
        this.capitalAmount = capitalAmount;
    }

    /**
     * Get capitalAmount 当期应还本金.
     *
     * @return the string
     */
    public BigDecimal getCapitalAmount(){
        return capitalAmount;
    }

    /**
     * Set interestAmount 当期应还利息.
     */
    public void setInterestAmount(BigDecimal interestAmount){
        this.interestAmount = interestAmount;
    }

    /**
     * Get interestAmount 当期应还利息.
     *
     * @return the string
     */
    public BigDecimal getInterestAmount(){
        return interestAmount;
    }
}

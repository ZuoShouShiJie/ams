package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * The table AMS_ACCOUNT_EARNINGS
 */
public class AccountEarningsDO implements Serializable{

    /**
     * id 平台收益表.
     */
    private Long id;
    /**
     * boId 借款编号.
     */
    private String boId;
    /**
     * orgId ORG_ID.
     */
    private Long orgId;
    /**
     * status 状态.
     */
    private String status;
    /**
     * userId 出借人账号.
     */
    private String userId;
    /**
     * boUserId 借款人账号.
     */
    private String boUserId;
    /**
     * createdBy CREATED_BY.
     */
    private String createdBy;
    /**
     * isFullFee 是否一次性收取平台FEE.
     */
    private String isFullFee;
    /**
     * periodNum 期数编号.
     */
    private String periodNum;
    /**
     * repayDate 计划收款日.
     */
    private Date repayDate;
    /**
     * updatedBy UPDATED_BY.
     */
    private String updatedBy;
    /**
     * overdueDay 逾期天数.
     */
    private String overdueDay;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * repayStatus 收款状态(0:未到帐，1：逾期，2：正常到账，3：提前还款，4：逾期还款，5：提前账务结清，6：坏账).
     */
    private String repayStatus;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * serviceFeeId 费用ID.
     */
    private String serviceFeeId;
    /**
     * capitalAmount 当期应收本金.
     */
    private BigDecimal capitalAmount;
    /**
     * punishFeeAccu 截至当期罚息费用累计.
     */
    private BigDecimal punishFeeAccu;
    /**
     * realRepayDate 实际收款/到账日.
     */
    private Date realRepayDate;
    /**
     * interestAmount 当期应收利息.
     */
    private BigDecimal interestAmount;
    /**
     * serviceFeeAccu 截至当期服务费用总额.
     */
    private BigDecimal serviceFeeAccu;
    /**
     * punishUpdatedTime 应收罚息更新时间.
     */
    private Date punishUpdatedTime;
    /**
     * merchantServiceFee 应收商户服务费.
     */
    private BigDecimal merchantServiceFee;

    /**
     * Set id 平台收益表.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 平台收益表.
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
     * Set orgId ORG_ID.
     */
    public void setOrgId(Long orgId){
        this.orgId = orgId;
    }

    /**
     * Get orgId ORG_ID.
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
     * Set userId 出借人账号.
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * Get userId 出借人账号.
     *
     * @return the string
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Set boUserId 借款人账号.
     */
    public void setBoUserId(String boUserId){
        this.boUserId = boUserId;
    }

    /**
     * Get boUserId 借款人账号.
     *
     * @return the string
     */
    public String getBoUserId(){
        return boUserId;
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
     * Set isFullFee 是否一次性收取平台FEE.
     */
    public void setIsFullFee(String isFullFee){
        this.isFullFee = isFullFee;
    }

    /**
     * Get isFullFee 是否一次性收取平台FEE.
     *
     * @return the string
     */
    public String getIsFullFee(){
        return isFullFee;
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
     * Set repayDate 计划收款日.
     */


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
     * Set overdueDay 逾期天数.
     */
    public void setOverdueDay(String overdueDay){
        this.overdueDay = overdueDay;
    }

    /**
     * Get overdueDay 逾期天数.
     *
     * @return the string
     */
    public String getOverdueDay(){
        return overdueDay;
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
     * Set repayStatus 收款状态(0:未到帐，1：逾期，2：正常到账，3：提前还款，4：逾期还款，5：提前账务结清，6：坏账).
     */
    public void setRepayStatus(String repayStatus){
        this.repayStatus = repayStatus;
    }

    /**
     * Get repayStatus 收款状态(0:未到帐，1：逾期，2：正常到账，3：提前还款，4：逾期还款，5：提前账务结清，6：坏账).
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
     * Set serviceFeeId 费用ID.
     */
    public void setServiceFeeId(String serviceFeeId){
        this.serviceFeeId = serviceFeeId;
    }

    /**
     * Get serviceFeeId 费用ID.
     *
     * @return the string
     */
    public String getServiceFeeId(){
        return serviceFeeId;
    }

    /**
     * Set capitalAmount 当期应收本金.
     */
    public void setCapitalAmount(BigDecimal capitalAmount){
        this.capitalAmount = capitalAmount;
    }

    /**
     * Get capitalAmount 当期应收本金.
     *
     * @return the string
     */
    public BigDecimal getCapitalAmount(){
        return capitalAmount;
    }

    /**
     * Set punishFeeAccu 截至当期罚息费用累计.
     */
    public void setPunishFeeAccu(BigDecimal punishFeeAccu){
        this.punishFeeAccu = punishFeeAccu;
    }

    /**
     * Get punishFeeAccu 截至当期罚息费用累计.
     *
     * @return the string
     */
    public BigDecimal getPunishFeeAccu(){
        return punishFeeAccu;
    }

    /**
     * Set realRepayDate 实际收款/到账日.
     */
    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Date getRealRepayDate() {
        return realRepayDate;
    }

    public void setRealRepayDate(Date realRepayDate) {
        this.realRepayDate = realRepayDate;
    }

    /**
     * Set interestAmount 当期应收利息.
     */
    public void setInterestAmount(BigDecimal interestAmount){
        this.interestAmount = interestAmount;
    }

    /**
     * Get interestAmount 当期应收利息.
     *
     * @return the string
     */
    public BigDecimal getInterestAmount(){
        return interestAmount;
    }

    /**
     * Set serviceFeeAccu 截至当期服务费用总额.
     */
    public void setServiceFeeAccu(BigDecimal serviceFeeAccu){
        this.serviceFeeAccu = serviceFeeAccu;
    }

    /**
     * Get serviceFeeAccu 截至当期服务费用总额.
     *
     * @return the string
     */
    public BigDecimal getServiceFeeAccu(){
        return serviceFeeAccu;
    }

    /**
     * Set punishUpdatedTime 应收罚息更新时间.
     */
    public void setPunishUpdatedTime(Date punishUpdatedTime){
        this.punishUpdatedTime = punishUpdatedTime;
    }

    /**
     * Get punishUpdatedTime 应收罚息更新时间.
     *
     * @return the string
     */
    public Date getPunishUpdatedTime(){
        return punishUpdatedTime;
    }

    /**
     * Set merchantServiceFee 应收商户服务费.
     */
    public void setMerchantServiceFee(BigDecimal merchantServiceFee){
        this.merchantServiceFee = merchantServiceFee;
    }

    /**
     * Get merchantServiceFee 应收商户服务费.
     *
     * @return the string
     */
    public BigDecimal getMerchantServiceFee(){
        return merchantServiceFee;
    }
}

package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The table AMS_ACCOUNT_REPAY_PLAN
 */
public class AccountRepayPlanDO implements Serializable{

    /**
     * id 还款计划表.
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
     * channel 是否走撮合平台（0：非撮合渠道，1：通过撮合平台）.
     */
    private String channel;
    /**
     * createdBy CREATED_BY.
     */
    private String createdBy;
    /**
     * periodNum PERIOD_NUM.
     */
    private String periodNum;
    /**
     * punishFee 罚息或违约费用.
     */
    private BigDecimal punishFee;
    /**
     * repayDate 计划还款日.
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
     * serviceFee 相关服务费用.
     */
    private BigDecimal serviceFee;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * repayStatus 还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，5：提前总账务结清，6：坏账，9：代扣中).
     */
    private String repayStatus;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * interestAccu 截至当期累计已还利息总额.
     */
    private BigDecimal interestAccu;
    /**
     * returnAmount 使用减息券等返还借入客户的资金.
     */
    private BigDecimal returnAmount;
    /**
     * serviceFeeId SERVICE_FEE_ID.
     */
    private String serviceFeeId;
    /**
     * capitalAmount 当期应还本金.
     */
    private BigDecimal capitalAmount;
    /**
     * punishFeeAccu 截至当期罚息费用总额.
     */
    private BigDecimal punishFeeAccu;
    /**
     * realRepayDate 实际还款/扣款日.
     */
    private Date realRepayDate;
    /**
     * interestAmount 当期应还利息.
     */
    private BigDecimal interestAmount;
    /**
     * punishFeeOwner 罚息或违约金归属（1：平台，2：资金方）.
     */
    private String punishFeeOwner;
    /**
     * serviceFeeAccu 截至当期服务费用总额.
     */
    private BigDecimal serviceFeeAccu;
    /**
     * totalCapitalAccu 截至当期累计已还本金金额.
     */
    private BigDecimal totalCapitalAccu;
    /**
     * totalCapitalLeft 截至当期剩余本金.
     */
    private BigDecimal totalCapitalLeft;
    /**
     * punishUpdatedTime 罚息更新时间.
     */
    private Date punishUpdatedTime;

    /**
     * Set id 还款计划表.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 还款计划表.
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
     * Set channel 是否走撮合平台（0：非撮合渠道，1：通过撮合平台）.
     */
    public void setChannel(String channel){
        this.channel = channel;
    }

    /**
     * Get channel 是否走撮合平台（0：非撮合渠道，1：通过撮合平台）.
     *
     * @return the string
     */
    public String getChannel(){
        return channel;
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
     * Set periodNum PERIOD_NUM.
     */
    public void setPeriodNum(String periodNum){
        this.periodNum = periodNum;
    }

    /**
     * Get periodNum PERIOD_NUM.
     *
     * @return the string
     */
    public String getPeriodNum(){
        return periodNum;
    }

    /**
     * Set punishFee 罚息或违约费用.
     */
    public void setPunishFee(BigDecimal punishFee){
        this.punishFee = punishFee;
    }

    /**
     * Get punishFee 罚息或违约费用.
     *
     * @return the string
     */
    public BigDecimal getPunishFee(){
        return punishFee;
    }

    /**
     * Set repayDate 计划还款日.
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
     * Set serviceFee 相关服务费用.
     */
    public void setServiceFee(BigDecimal serviceFee){
        this.serviceFee = serviceFee;
    }

    /**
     * Get serviceFee 相关服务费用.
     *
     * @return the string
     */
    public BigDecimal getServiceFee(){
        return serviceFee;
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
     * Set repayStatus 还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，5：提前总账务结清，6：坏账，9：代扣中).
     */
    public void setRepayStatus(String repayStatus){
        this.repayStatus = repayStatus;
    }

    /**
     * Get repayStatus 还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，5：提前总账务结清，6：坏账，9：代扣中).
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
     * Set interestAccu 截至当期累计已还利息总额.
     */
    public void setInterestAccu(BigDecimal interestAccu){
        this.interestAccu = interestAccu;
    }

    /**
     * Get interestAccu 截至当期累计已还利息总额.
     *
     * @return the string
     */
    public BigDecimal getInterestAccu(){
        return interestAccu;
    }

    /**
     * Set returnAmount 使用减息券等返还借入客户的资金.
     */
    public void setReturnAmount(BigDecimal returnAmount){
        this.returnAmount = returnAmount;
    }

    /**
     * Get returnAmount 使用减息券等返还借入客户的资金.
     *
     * @return the string
     */
    public BigDecimal getReturnAmount(){
        return returnAmount;
    }

    /**
     * Set serviceFeeId SERVICE_FEE_ID.
     */
    public void setServiceFeeId(String serviceFeeId){
        this.serviceFeeId = serviceFeeId;
    }

    /**
     * Get serviceFeeId SERVICE_FEE_ID.
     *
     * @return the string
     */
    public String getServiceFeeId(){
        return serviceFeeId;
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
     * Set punishFeeAccu 截至当期罚息费用总额.
     */
    public void setPunishFeeAccu(BigDecimal punishFeeAccu){
        this.punishFeeAccu = punishFeeAccu;
    }

    /**
     * Get punishFeeAccu 截至当期罚息费用总额.
     *
     * @return the string
     */
    public BigDecimal getPunishFeeAccu(){
        return punishFeeAccu;
    }

    /**
     * Set realRepayDate 实际还款/扣款日.
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

    /**
     * Set punishFeeOwner 罚息或违约金归属（1：平台，2：资金方）.
     */
    public void setPunishFeeOwner(String punishFeeOwner){
        this.punishFeeOwner = punishFeeOwner;
    }

    /**
     * Get punishFeeOwner 罚息或违约金归属（1：平台，2：资金方）.
     *
     * @return the string
     */
    public String getPunishFeeOwner(){
        return punishFeeOwner;
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
     * Set totalCapitalAccu 截至当期累计已还本金金额.
     */
    public void setTotalCapitalAccu(BigDecimal totalCapitalAccu){
        this.totalCapitalAccu = totalCapitalAccu;
    }

    /**
     * Get totalCapitalAccu 截至当期累计已还本金金额.
     *
     * @return the string
     */
    public BigDecimal getTotalCapitalAccu(){
        return totalCapitalAccu;
    }

    /**
     * Set totalCapitalLeft 截至当期剩余本金.
     */
    public void setTotalCapitalLeft(BigDecimal totalCapitalLeft){
        this.totalCapitalLeft = totalCapitalLeft;
    }

    /**
     * Get totalCapitalLeft 截至当期剩余本金.
     *
     * @return the string
     */
    public BigDecimal getTotalCapitalLeft(){
        return totalCapitalLeft;
    }

    /**
     * Set punishUpdatedTime 罚息更新时间.
     */
    public void setPunishUpdatedTime(Date punishUpdatedTime){
        this.punishUpdatedTime = punishUpdatedTime;
    }

    /**
     * Get punishUpdatedTime 罚息更新时间.
     *
     * @return the string
     */
    public Date getPunishUpdatedTime(){
        return punishUpdatedTime;
    }
}

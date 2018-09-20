package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * The table AMS_ACCOUNT_BORROW
 */
public class AccountBorrowDO implements Serializable{

    /**
     * id 借款账务表.
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
     * userId 借款人帐号.
     */
    private String userId;
    /**
     * channel 是否走撮合平台（0：非撮合渠道，1：通过撮合平台）.
     */
    private String channel;
    /**
     * brUserId 出借人账号（LIST - 可以多个出借人，待确定）.
     */
    private String brUserId;
    /**
     * lendTime 实际放款时间.
     */
    private Date lendTime;
    /**
     * rateType 利率类型（1：天，2：月，3：年）.
     */
    private String rateType;
    /**
     * applyTime 申请时间.
     */
    private Date applyTime;
    private Date approveDate;
    private Date lendDate;

    /**
     * createdBy CREATED_BY.
     */
    private String createdBy;
    /**
     * isFullFee 是否一次性收取平台FEE（IF CHANNEL=1）.
     */
    private String isFullFee;
    /**
     * loanUsage 借款用途.
     */
    private String loanUsage;
    /**
     * repayDate 指定还款日.
     */
    private String repayDate;
    /**
     * repayRate 产品总利率.
     */
    private String repayRate;
    /**
     * repayType REPAY_TYPE.
     */
    private String repayType;
    /**
     * updatedBy UPDATED_BY.
     */
    private String updatedBy;
    /**
     * contractNo 合同编号（借据编号）LIST(可以单个合同，也支持多合同).
     */
    private String contractNo;
    /**
     * lendAmount 本金金额.
     */
    private BigDecimal lendAmount;
    /**
     * loanAmount 借款金额.
     */
    private BigDecimal loanAmount;
    /**
     * approveTime 审批时间.
     */
    private Date approveTime;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * productCode PRODUCT_CODE.
     */
    private String productCode;
    /**
     * productType PRODUCT_TYPE.
     */
    private String productType;
    /**
     * receiptRate 收款利率.
     */
    private BigDecimal receiptRate;
    /**
     * repayPeriod 还款期数.
     */
    private String repayPeriod;
    /**
     * repayStatus 当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）.
     */
    private String repayStatus;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * contractType 合同类型（1：单合同/单借据，2：多合同/多借据）.
     */
    private String contractType;
    /**
     * interestAccu 截至当前累计已还利息总额.
     */
    private BigDecimal interestAccu;
    /**
     * overdueTimes 逾期次数.
     */
    private String overdueTimes;
    /**
     * platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     */
    private BigDecimal platformRate;
    /**
     * accountAmount ACCOUNT_AMOUNT.
     */
    private BigDecimal accountAmount;
    /**
     * capitalAmount 建帐金额.
     */
    private BigDecimal capitalAmount;
    /**
     * lastRepayDate 最后还款日.
     */
    private Date lastRepayDate;
    /**
     * maxOverdueDay 最大逾期天数.
     */
    private String maxOverdueDay;
    /**
     * nextRepayDate 下一还款日.
     */
    private Date nextRepayDate;
    /**
     * punishFeeAccu 截至当前罚息费用总额.
     */
    private BigDecimal punishFeeAccu;
    /**
     * repayAcctBank 还款账号开户行.
     */
    private String repayAcctBank;
    /**
     * capitalAdvance 预收本金.
     */
    private BigDecimal capitalAdvance;
    /**
     * contractAmount 合同金额.
     */
    private BigDecimal contractAmount;
    /**
     * currOverdueDay 当前逾期天数.
     */
    private String currOverdueDay;
    /**
     * firstRepayDate 起始还款日.
     */
    private Date firstRepayDate;
    /**
     * repayAccountNo 还款绑定账号.
     */
    private String repayAccountNo;
    /**
     * repayAcctPhone 还款账号预留手机号.
     */
    private String repayAcctPhone;
    /**
     * serviceFeeAccu 截至当前服务费用总额.
     */
    private BigDecimal serviceFeeAccu;
    /**
     * interestAdvance 预收利息.
     */
    private BigDecimal interestAdvance;
    /**
     * repayAccountName 还款账号开户名.
     */
    private String repayAccountName;
    /**
     * totalCapitalAccu 截至当前累计已还本金金额.
     */
    private BigDecimal totalCapitalAccu;
    /**
     * totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     */
    private BigDecimal totalCapitalLeft;
    /**
     * repayFloatingRate 上浮比率（-20% — +20%）.
     */
    private BigDecimal repayFloatingRate;


    private BigDecimal rate;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * Set id 借款账务表.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id 借款账务表.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
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
     * Set brUserId 出借人账号（LIST - 可以多个出借人，待确定）.
     */
    public void setBrUserId(String brUserId){
        this.brUserId = brUserId;
    }

    /**
     * Get brUserId 出借人账号（LIST - 可以多个出借人，待确定）.
     *
     * @return the string
     */
    public String getBrUserId(){
        return brUserId;
    }

    /**
     * Set lendTime 实际放款时间.
     */
    public void setLendTime(Date lendTime){
        this.lendTime = lendTime;
    }

    /**
     * Get lendTime 实际放款时间.
     *
     * @return the string
     */
    public Date getLendTime(){
        return lendTime;
    }

    /**
     * Set rateType 利率类型（1：天，2：月，3：年）.
     */
    public void setRateType(String rateType){
        this.rateType = rateType;
    }

    /**
     * Get rateType 利率类型（1：天，2：月，3：年）.
     *
     * @return the string
     */
    public String getRateType(){
        return rateType;
    }

    /**
     * Set applyTime 申请时间.
     */
    public void setApplyTime(Date applyTime){
        this.applyTime = applyTime;
    }

    /**
     * Get applyTime 申请时间.
     *
     * @return the string
     */
    public Date getApplyTime(){
        return applyTime;
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
     * Set isFullFee 是否一次性收取平台FEE（IF CHANNEL=1）.
     */
    public void setIsFullFee(String isFullFee){
        this.isFullFee = isFullFee;
    }

    /**
     * Get isFullFee 是否一次性收取平台FEE（IF CHANNEL=1）.
     *
     * @return the string
     */
    public String getIsFullFee(){
        return isFullFee;
    }

    /**
     * Set loanUsage 借款用途.
     */
    public void setLoanUsage(String loanUsage){
        this.loanUsage = loanUsage;
    }

    /**
     * Get loanUsage 借款用途.
     *
     * @return the string
     */
    public String getLoanUsage(){
        return loanUsage;
    }

    /**
     * Set repayDate 指定还款日.
     */
    public void setRepayDate(String repayDate){
        this.repayDate = repayDate;
    }

    /**
     * Get repayDate 指定还款日.
     *
     * @return the string
     */
    public String getRepayDate(){
        return repayDate;
    }

    /**
     * Set repayRate 原始还款利率.
     */
    public String getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(String repayRate) {
        this.repayRate = repayRate;
    }

    /**
     * Set repayType REPAY_TYPE.
     */
    public void setRepayType(String repayType){
        this.repayType = repayType;
    }

    /**
     * Get repayType REPAY_TYPE.
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
     * Set contractNo 合同编号（借据编号）LIST(可以单个合同，也支持多合同).
     */
    public void setContractNo(String contractNo){
        this.contractNo = contractNo;
    }

    /**
     * Get contractNo 合同编号（借据编号）LIST(可以单个合同，也支持多合同).
     *
     * @return the string
     */
    public String getContractNo(){
        return contractNo;
    }

    /**
     * Set lendAmount 本金金额.
     */
    public void setLendAmount(BigDecimal lendAmount){
        this.lendAmount = lendAmount;
    }

    /**
     * Get lendAmount 本金金额.
     *
     * @return the string
     */
    public BigDecimal getLendAmount(){
        return lendAmount;
    }

    /**
     * Set loanAmount 借款金额.
     */
    public void setLoanAmount(BigDecimal loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * Get loanAmount 借款金额.
     *
     * @return the string
     */
    public BigDecimal getLoanAmount(){
        return loanAmount;
    }

    /**
     * Set approveTime 审批时间.
     */
    public void setApproveTime(Date approveTime){
        this.approveTime = approveTime;
    }

    /**
     * Get approveTime 审批时间.
     *
     * @return the string
     */
    public Date getApproveTime(){
        return approveTime;
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
     * Set productCode PRODUCT_CODE.
     */
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }

    /**
     * Get productCode PRODUCT_CODE.
     *
     * @return the string
     */
    public String getProductCode(){
        return productCode;
    }

    /**
     * Set productType PRODUCT_TYPE.
     */
    public void setProductType(String productType){
        this.productType = productType;
    }

    /**
     * Get productType PRODUCT_TYPE.
     *
     * @return the string
     */
    public String getProductType(){
        return productType;
    }

    /**
     * Set receiptRate 收款利率.
     */
    public void setReceiptRate(BigDecimal receiptRate){
        this.receiptRate = receiptRate;
    }

    /**
     * Get receiptRate 收款利率.
     *
     * @return the string
     */
    public BigDecimal getReceiptRate(){
        return receiptRate;
    }

    /**
     * Set repayPeriod 还款期数.
     */
    public void setRepayPeriod(String repayPeriod){
        this.repayPeriod = repayPeriod;
    }

    /**
     * Get repayPeriod 还款期数.
     *
     * @return the string
     */
    public String getRepayPeriod(){
        return repayPeriod;
    }

    /**
     * Set repayStatus 当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）.
     */
    public void setRepayStatus(String repayStatus){
        this.repayStatus = repayStatus;
    }

    /**
     * Get repayStatus 当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）.
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
     * Set contractType 合同类型（1：单合同/单借据，2：多合同/多借据）.
     */
    public void setContractType(String contractType){
        this.contractType = contractType;
    }

    /**
     * Get contractType 合同类型（1：单合同/单借据，2：多合同/多借据）.
     *
     * @return the string
     */
    public String getContractType(){
        return contractType;
    }

    /**
     * Set interestAccu 截至当前累计已还利息总额.
     */
    public void setInterestAccu(BigDecimal interestAccu){
        this.interestAccu = interestAccu;
    }

    /**
     * Get interestAccu 截至当前累计已还利息总额.
     *
     * @return the string
     */
    public BigDecimal getInterestAccu(){
        return interestAccu;
    }

    /**
     * Set overdueTimes 逾期次数.
     */
    public void setOverdueTimes(String overdueTimes){
        this.overdueTimes = overdueTimes;
    }

    /**
     * Get overdueTimes 逾期次数.
     *
     * @return the string
     */
    public String getOverdueTimes(){
        return overdueTimes;
    }

    /**
     * Set platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     */
    public void setPlatformRate(BigDecimal platformRate){
        this.platformRate = platformRate;
    }

    /**
     * Get platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     *
     * @return the string
     */
    public BigDecimal getPlatformRate(){
        return platformRate;
    }

    /**
     * Set accountAmount ACCOUNT_AMOUNT.
     */
    public void setAccountAmount(BigDecimal accountAmount){
        this.accountAmount = accountAmount;
    }

    /**
     * Get accountAmount ACCOUNT_AMOUNT.
     *
     * @return the string
     */
    public BigDecimal getAccountAmount(){
        return accountAmount;
    }

    /**
     * Set capitalAmount 建帐金额.
     */
    public void setCapitalAmount(BigDecimal capitalAmount){
        this.capitalAmount = capitalAmount;
    }

    /**
     * Get capitalAmount 建帐金额.
     *
     * @return the string
     */
    public BigDecimal getCapitalAmount(){
        return capitalAmount;
    }

    /**
     * Set lastRepayDate 最后还款日.
     */
    public void setLastRepayDate(Date lastRepayDate){
        this.lastRepayDate = lastRepayDate;
    }

    /**
     * Get lastRepayDate 最后还款日.
     *
     * @return the string
     */
    public Date getLastRepayDate(){
        return lastRepayDate;
    }

    /**
     * Set maxOverdueDay 最大逾期天数.
     */
    public void setMaxOverdueDay(String maxOverdueDay){
        this.maxOverdueDay = maxOverdueDay;
    }

    /**
     * Get maxOverdueDay 最大逾期天数.
     *
     * @return the string
     */
    public String getMaxOverdueDay(){
        return maxOverdueDay;
    }

    /**
     * Set nextRepayDate 下一还款日.
     */
    public void setNextRepayDate(Date nextRepayDate){
        this.nextRepayDate = nextRepayDate;
    }

    /**
     * Get nextRepayDate 下一还款日.
     *
     * @return the string
     */
    public Date getNextRepayDate(){
        return nextRepayDate;
    }

    /**
     * Set punishFeeAccu 截至当前罚息费用总额.
     */
    public void setPunishFeeAccu(BigDecimal punishFeeAccu){
        this.punishFeeAccu = punishFeeAccu;
    }

    /**
     * Get punishFeeAccu 截至当前罚息费用总额.
     *
     * @return the string
     */
    public BigDecimal getPunishFeeAccu(){
        return punishFeeAccu;
    }

    /**
     * Set repayAcctBank 还款账号开户行.
     */
    public void setRepayAcctBank(String repayAcctBank){
        this.repayAcctBank = repayAcctBank;
    }

    /**
     * Get repayAcctBank 还款账号开户行.
     *
     * @return the string
     */
    public String getRepayAcctBank(){
        return repayAcctBank;
    }

    /**
     * Set capitalAdvance 预收本金.
     */
    public void setCapitalAdvance(BigDecimal capitalAdvance){
        this.capitalAdvance = capitalAdvance;
    }

    /**
     * Get capitalAdvance 预收本金.
     *
     * @return the string
     */
    public BigDecimal getCapitalAdvance(){
        return capitalAdvance;
    }

    /**
     * Set contractAmount 合同金额.
     */
    public void setContractAmount(BigDecimal contractAmount){
        this.contractAmount = contractAmount;
    }

    /**
     * Get contractAmount 合同金额.
     *
     * @return the string
     */
    public BigDecimal getContractAmount(){
        return contractAmount;
    }

    /**
     * Set currOverdueDay 当前逾期天数.
     */
    public void setCurrOverdueDay(String currOverdueDay){
        this.currOverdueDay = currOverdueDay;
    }

    /**
     * Get currOverdueDay 当前逾期天数.
     *
     * @return the string
     */
    public String getCurrOverdueDay(){
        return currOverdueDay;
    }

    /**
     * Set firstRepayDate 起始还款日.
     */
    public void setFirstRepayDate(Date firstRepayDate){
        this.firstRepayDate = firstRepayDate;
    }

    /**
     * Get firstRepayDate 起始还款日.
     *
     * @return the string
     */
    public Date getFirstRepayDate(){
        return firstRepayDate;
    }

    /**
     * Set repayAccountNo 还款绑定账号.
     */
    public void setRepayAccountNo(String repayAccountNo){
        this.repayAccountNo = repayAccountNo;
    }

    /**
     * Get repayAccountNo 还款绑定账号.
     *
     * @return the string
     */
    public String getRepayAccountNo(){
        return repayAccountNo;
    }

    /**
     * Set repayAcctPhone 还款账号预留手机号.
     */
    public void setRepayAcctPhone(String repayAcctPhone){
        this.repayAcctPhone = repayAcctPhone;
    }

    /**
     * Get repayAcctPhone 还款账号预留手机号.
     *
     * @return the string
     */
    public String getRepayAcctPhone(){
        return repayAcctPhone;
    }

    /**
     * Set serviceFeeAccu 截至当前服务费用总额.
     */
    public void setServiceFeeAccu(BigDecimal serviceFeeAccu){
        this.serviceFeeAccu = serviceFeeAccu;
    }

    /**
     * Get serviceFeeAccu 截至当前服务费用总额.
     *
     * @return the string
     */
    public BigDecimal getServiceFeeAccu(){
        return serviceFeeAccu;
    }

    /**
     * Set interestAdvance 预收利息.
     */
    public void setInterestAdvance(BigDecimal interestAdvance){
        this.interestAdvance = interestAdvance;
    }

    /**
     * Get interestAdvance 预收利息.
     *
     * @return the string
     */
    public BigDecimal getInterestAdvance(){
        return interestAdvance;
    }

    /**
     * Set repayAccountName 还款账号开户名.
     */
    public void setRepayAccountName(String repayAccountName){
        this.repayAccountName = repayAccountName;
    }

    /**
     * Get repayAccountName 还款账号开户名.
     *
     * @return the string
     */
    public String getRepayAccountName(){
        return repayAccountName;
    }

    /**
     * Set totalCapitalAccu 截至当前累计已还本金金额.
     */
    public void setTotalCapitalAccu(BigDecimal totalCapitalAccu){
        this.totalCapitalAccu = totalCapitalAccu;
    }

    /**
     * Get totalCapitalAccu 截至当前累计已还本金金额.
     *
     * @return the string
     */
    public BigDecimal getTotalCapitalAccu(){
        return totalCapitalAccu;
    }

    /**
     * Set totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     */
    public void setTotalCapitalLeft(BigDecimal totalCapitalLeft){
        this.totalCapitalLeft = totalCapitalLeft;
    }

    /**
     * Get totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     *
     * @return the string
     */
    public BigDecimal getTotalCapitalLeft(){
        return totalCapitalLeft;
    }

    /**
     * Set repayFloatingRate 上浮比率（-20% — +20%）.
     */
    public void setRepayFloatingRate(BigDecimal repayFloatingRate){
        this.repayFloatingRate = repayFloatingRate;
    }

    /**
     * Get repayFloatingRate 上浮比率（-20% — +20%）.
     *
     * @return the string
     */
    public BigDecimal getRepayFloatingRate(){
        return repayFloatingRate;
    }
}

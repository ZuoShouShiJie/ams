package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table AMS_ACCOUNTING
 */
public class AccountingDO implements Serializable{

    /**
     * id ID.
     */
    private String id;
    /**
     * boId 借款编号.
     */
    private Long boId;
    /**
     * route 路由.
     */
    private String route;
    /**
     * certNo 证件号.
     */
    private String certNo;
    /**
     * mobile 手机号.
     */
    private String mobile;
    /**
     * creater 创建人.
     */
    private String creater;
    /**
     * certType 证件类型.
     */
    private String certType;
    /**
     * lendDate 实际放款日期.
     */
    private Date lendDate;
    /**
     * lendTime 实际放款时间.
     */
    private Date lendTime;
    /**
     * modifier 修改人.
     */
    private String modifier;
    /**
     * rateType 利率类型.
     */
    private String rateType;
    /**
     * userName 借款人姓名.
     */
    private String userName;
    /**
     * accountId 借款人账号.
     */
    private String accountId;
    /**
     * isFullFee 是否一次性收取平台费（IF CHANNEL=1）.
     */
    private String isFullFee;
    /**
     * loanUsage 借款用途.
     */
    private String loanUsage;
    /**
     * productId 产品编号.
     */
    private Long productId;
    /**
     * repayDate 指定还款日期.
     */
    private Date repayDate;
    /**
     * repayRate 原始还款利率.
     */
    private String repayRate;
    /**
     * repayType 放款类型.
     */
    private String repayType;
    /**
     * contractNo 合同编号（借据编号）LIST(可以单个合同，也支持多合同).
     */
    private String contractNo;
    /**
     * createTime 创建时间.
     */
    private Date createTime;
    /**
     * lendAmount 实际放款金额.
     */
    private Long lendAmount;
    /**
     * loanAmount 借款金额.
     */
    private Long loanAmount;
    /**
     * merchantId 商户编码.
     */
    private Long merchantId;
    /**
     * modifyTime 修改时间.
     */
    private Date modifyTime;
    /**
     * approveDate 审批日期.
     */
    private Date approveDate;
    /**
     * approveTime 审批时间.
     */
    private Date approveTime;
    /**
     * productType 产品类型.
     */
    private String productType;
    /**
     * receiptRate 收款利率.
     */
    private String receiptRate;
    /**
     * repayPeriod 放款期数.
     */
    private Integer repayPeriod;
    /**
     * repayStatus 当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）.
     */
    private String repayStatus;
    /**
     * contractType 合同类型（1：单合同/单借据，2：多合同/多借据）.
     */
    private String contractType;
    /**
     * interestAccu 截至当前累计已还本金金额.
     */
    private Long interestAccu;
    /**
     * overdueTimes 逾期次数.
     */
    private Integer overdueTimes;
    /**
     * platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     */
    private String platformRate;
    /**
     * accountAmount 建账金额.
     */
    private Long accountAmount;
    /**
     * capitalAmount 本金金额.
     */
    private Long capitalAmount;
    /**
     * lastRepayDate 最后还款日.
     */
    private Date lastRepayDate;
    /**
     * maxOverdueDay 最大逾期天数.
     */
    private Integer maxOverdueDay;
    /**
     * nextRepayDate 下一还款日.
     */
    private Date nextRepayDate;
    /**
     * punishFeeAccu 截至当前罚息费用总额.
     */
    private Long punishFeeAccu;
    /**
     * repayAcctBank 还款账号开户行.
     */
    private String repayAcctBank;
    /**
     * capitalAdvance 预收本金.
     */
    private Long capitalAdvance;
    /**
     * contractAmount 合同金额.
     */
    private Long contractAmount;
    /**
     * currOverdueDay 当前逾期天数.
     */
    private Integer currOverdueDay;
    /**
     * firstRepayDate 起始还款日.
     */
    private Date firstRepayDate;
    /**
     * repayAccountNo 还款绑定账号.
     */
    private String repayAccountNo;
    /**
     * serviceFeeAccu 截至当前服务费用总额.
     */
    private Long serviceFeeAccu;
    /**
     * interestAdvance 预收利息.
     */
    private Long interestAdvance;
    /**
     * repayAcctMobile 还款账号预留手机号.
     */
    private String repayAcctMobile;
    /**
     * repayAccountName 还款账号开户名.
     */
    private String repayAccountName;
    /**
     * totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     */
    private Long totalCapitalLeft;
    /**
     * repayFloatingRate 上浮比率（-20% — +20%）.
     */
    private String repayFloatingRate;

    /**
     * Set id ID.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public String getId(){
        return id;
    }

    /**
     * Set boId 借款编号.
     */
    public void setBoId(Long boId){
        this.boId = boId;
    }

    /**
     * Get boId 借款编号.
     *
     * @return the string
     */
    public Long getBoId(){
        return boId;
    }

    /**
     * Set route 路由.
     */
    public void setRoute(String route){
        this.route = route;
    }

    /**
     * Get route 路由.
     *
     * @return the string
     */
    public String getRoute(){
        return route;
    }

    /**
     * Set certNo 证件号.
     */
    public void setCertNo(String certNo){
        this.certNo = certNo;
    }

    /**
     * Get certNo 证件号.
     *
     * @return the string
     */
    public String getCertNo(){
        return certNo;
    }

    /**
     * Set mobile 手机号.
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
     * Get mobile 手机号.
     *
     * @return the string
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * Set creater 创建人.
     */
    public void setCreater(String creater){
        this.creater = creater;
    }

    /**
     * Get creater 创建人.
     *
     * @return the string
     */
    public String getCreater(){
        return creater;
    }

    /**
     * Set certType 证件类型.
     */
    public void setCertType(String certType){
        this.certType = certType;
    }

    /**
     * Get certType 证件类型.
     *
     * @return the string
     */
    public String getCertType(){
        return certType;
    }

    /**
     * Set lendDate 实际放款日期.
     */
    public void setLendDate(Date lendDate){
        this.lendDate = lendDate;
    }

    /**
     * Get lendDate 实际放款日期.
     *
     * @return the string
     */
    public Date getLendDate(){
        return lendDate;
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
     * Set modifier 修改人.
     */
    public void setModifier(String modifier){
        this.modifier = modifier;
    }

    /**
     * Get modifier 修改人.
     *
     * @return the string
     */
    public String getModifier(){
        return modifier;
    }

    /**
     * Set rateType 利率类型.
     */
    public void setRateType(String rateType){
        this.rateType = rateType;
    }

    /**
     * Get rateType 利率类型.
     *
     * @return the string
     */
    public String getRateType(){
        return rateType;
    }

    /**
     * Set userName 借款人姓名.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * Get userName 借款人姓名.
     *
     * @return the string
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Set accountId 借款人账号.
     */
    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    /**
     * Get accountId 借款人账号.
     *
     * @return the string
     */
    public String getAccountId(){
        return accountId;
    }

    /**
     * Set isFullFee 是否一次性收取平台费（IF CHANNEL=1）.
     */
    public void setIsFullFee(String isFullFee){
        this.isFullFee = isFullFee;
    }

    /**
     * Get isFullFee 是否一次性收取平台费（IF CHANNEL=1）.
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
     * Set productId 产品编号.
     */
    public void setProductId(Long productId){
        this.productId = productId;
    }

    /**
     * Get productId 产品编号.
     *
     * @return the string
     */
    public Long getProductId(){
        return productId;
    }

    /**
     * Set repayDate 指定还款日期.
     */
    public void setRepayDate(Date repayDate){
        this.repayDate = repayDate;
    }

    /**
     * Get repayDate 指定还款日期.
     *
     * @return the string
     */
    public Date getRepayDate(){
        return repayDate;
    }

    /**
     * Set repayRate 原始还款利率.
     */
    public void setRepayRate(String repayRate){
        this.repayRate = repayRate;
    }

    /**
     * Get repayRate 原始还款利率.
     *
     * @return the string
     */
    public String getRepayRate(){
        return repayRate;
    }

    /**
     * Set repayType 放款类型.
     */
    public void setRepayType(String repayType){
        this.repayType = repayType;
    }

    /**
     * Get repayType 放款类型.
     *
     * @return the string
     */
    public String getRepayType(){
        return repayType;
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
     * Set createTime 创建时间.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime 创建时间.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set lendAmount 实际放款金额.
     */
    public void setLendAmount(Long lendAmount){
        this.lendAmount = lendAmount;
    }

    /**
     * Get lendAmount 实际放款金额.
     *
     * @return the string
     */
    public Long getLendAmount(){
        return lendAmount;
    }

    /**
     * Set loanAmount 借款金额.
     */
    public void setLoanAmount(Long loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * Get loanAmount 借款金额.
     *
     * @return the string
     */
    public Long getLoanAmount(){
        return loanAmount;
    }

    /**
     * Set merchantId 商户编码.
     */
    public void setMerchantId(Long merchantId){
        this.merchantId = merchantId;
    }

    /**
     * Get merchantId 商户编码.
     *
     * @return the string
     */
    public Long getMerchantId(){
        return merchantId;
    }

    /**
     * Set modifyTime 修改时间.
     */
    public void setModifyTime(Date modifyTime){
        this.modifyTime = modifyTime;
    }

    /**
     * Get modifyTime 修改时间.
     *
     * @return the string
     */
    public Date getModifyTime(){
        return modifyTime;
    }

    /**
     * Set approveDate 审批日期.
     */
    public void setApproveDate(Date approveDate){
        this.approveDate = approveDate;
    }

    /**
     * Get approveDate 审批日期.
     *
     * @return the string
     */
    public Date getApproveDate(){
        return approveDate;
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
     * Set productType 产品类型.
     */
    public void setProductType(String productType){
        this.productType = productType;
    }

    /**
     * Get productType 产品类型.
     *
     * @return the string
     */
    public String getProductType(){
        return productType;
    }

    /**
     * Set receiptRate 收款利率.
     */
    public void setReceiptRate(String receiptRate){
        this.receiptRate = receiptRate;
    }

    /**
     * Get receiptRate 收款利率.
     *
     * @return the string
     */
    public String getReceiptRate(){
        return receiptRate;
    }

    /**
     * Set repayPeriod 放款期数.
     */
    public void setRepayPeriod(Integer repayPeriod){
        this.repayPeriod = repayPeriod;
    }

    /**
     * Get repayPeriod 放款期数.
     *
     * @return the string
     */
    public Integer getRepayPeriod(){
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
     * Set interestAccu 截至当前累计已还本金金额.
     */
    public void setInterestAccu(Long interestAccu){
        this.interestAccu = interestAccu;
    }

    /**
     * Get interestAccu 截至当前累计已还本金金额.
     *
     * @return the string
     */
    public Long getInterestAccu(){
        return interestAccu;
    }

    /**
     * Set overdueTimes 逾期次数.
     */
    public void setOverdueTimes(Integer overdueTimes){
        this.overdueTimes = overdueTimes;
    }

    /**
     * Get overdueTimes 逾期次数.
     *
     * @return the string
     */
    public Integer getOverdueTimes(){
        return overdueTimes;
    }

    /**
     * Set platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     */
    public void setPlatformRate(String platformRate){
        this.platformRate = platformRate;
    }

    /**
     * Get platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）.
     *
     * @return the string
     */
    public String getPlatformRate(){
        return platformRate;
    }

    /**
     * Set accountAmount 建账金额.
     */
    public void setAccountAmount(Long accountAmount){
        this.accountAmount = accountAmount;
    }

    /**
     * Get accountAmount 建账金额.
     *
     * @return the string
     */
    public Long getAccountAmount(){
        return accountAmount;
    }

    /**
     * Set capitalAmount 本金金额.
     */
    public void setCapitalAmount(Long capitalAmount){
        this.capitalAmount = capitalAmount;
    }

    /**
     * Get capitalAmount 本金金额.
     *
     * @return the string
     */
    public Long getCapitalAmount(){
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
    public void setMaxOverdueDay(Integer maxOverdueDay){
        this.maxOverdueDay = maxOverdueDay;
    }

    /**
     * Get maxOverdueDay 最大逾期天数.
     *
     * @return the string
     */
    public Integer getMaxOverdueDay(){
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
    public void setPunishFeeAccu(Long punishFeeAccu){
        this.punishFeeAccu = punishFeeAccu;
    }

    /**
     * Get punishFeeAccu 截至当前罚息费用总额.
     *
     * @return the string
     */
    public Long getPunishFeeAccu(){
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
    public void setCapitalAdvance(Long capitalAdvance){
        this.capitalAdvance = capitalAdvance;
    }

    /**
     * Get capitalAdvance 预收本金.
     *
     * @return the string
     */
    public Long getCapitalAdvance(){
        return capitalAdvance;
    }

    /**
     * Set contractAmount 合同金额.
     */
    public void setContractAmount(Long contractAmount){
        this.contractAmount = contractAmount;
    }

    /**
     * Get contractAmount 合同金额.
     *
     * @return the string
     */
    public Long getContractAmount(){
        return contractAmount;
    }

    /**
     * Set currOverdueDay 当前逾期天数.
     */
    public void setCurrOverdueDay(Integer currOverdueDay){
        this.currOverdueDay = currOverdueDay;
    }

    /**
     * Get currOverdueDay 当前逾期天数.
     *
     * @return the string
     */
    public Integer getCurrOverdueDay(){
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
     * Set serviceFeeAccu 截至当前服务费用总额.
     */
    public void setServiceFeeAccu(Long serviceFeeAccu){
        this.serviceFeeAccu = serviceFeeAccu;
    }

    /**
     * Get serviceFeeAccu 截至当前服务费用总额.
     *
     * @return the string
     */
    public Long getServiceFeeAccu(){
        return serviceFeeAccu;
    }

    /**
     * Set interestAdvance 预收利息.
     */
    public void setInterestAdvance(Long interestAdvance){
        this.interestAdvance = interestAdvance;
    }

    /**
     * Get interestAdvance 预收利息.
     *
     * @return the string
     */
    public Long getInterestAdvance(){
        return interestAdvance;
    }

    /**
     * Set repayAcctMobile 还款账号预留手机号.
     */
    public void setRepayAcctMobile(String repayAcctMobile){
        this.repayAcctMobile = repayAcctMobile;
    }

    /**
     * Get repayAcctMobile 还款账号预留手机号.
     *
     * @return the string
     */
    public String getRepayAcctMobile(){
        return repayAcctMobile;
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
     * Set totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     */
    public void setTotalCapitalLeft(Long totalCapitalLeft){
        this.totalCapitalLeft = totalCapitalLeft;
    }

    /**
     * Get totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）.
     *
     * @return the string
     */
    public Long getTotalCapitalLeft(){
        return totalCapitalLeft;
    }

    /**
     * Set repayFloatingRate 上浮比率（-20% — +20%）.
     */
    public void setRepayFloatingRate(String repayFloatingRate){
        this.repayFloatingRate = repayFloatingRate;
    }

    /**
     * Get repayFloatingRate 上浮比率（-20% — +20%）.
     *
     * @return the string
     */
    public String getRepayFloatingRate(){
        return repayFloatingRate;
    }
}

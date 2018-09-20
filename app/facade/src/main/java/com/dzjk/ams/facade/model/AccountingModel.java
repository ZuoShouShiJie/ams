package com.dzjk.ams.facade.model;

import java.util.Date;

/** @author climb.s
 * @date 2018/2/11 06:30 */
public class AccountingModel {
	/** id ID. */
	private String	id;
	/** boId 借款编号. */
	private Long	boId;
	/** route 路由. */
	private String	route;
	/** certNo 证件号. */
	private String	certNo;
	/** mobile 手机号. */
	private String	mobile;
	/** creater 创建人. */
	private String	creater;
	/** certType 证件类型. */
	private String	certType;
	/** lendDate 实际放款日期. */
	private Date	lendDate;
	/** lendTime 实际放款时间. */
	private Date	lendTime;
	/** modifier 修改人. */
	private String	modifier;
	/** rateType 利率类型. */
	private String	rateType;
	/** userName 借款人姓名. */
	private String	userName;
	/** accountId 借款人账号. */
	private String	accountId;
	/** isFullFee 是否一次性收取平台费（IF CHANNEL=1）. */
	private String	isFullFee;
	/** loanUsage 借款用途. */
	private String	loanUsage;
	/** productId 产品编号. */
	private Long	productId;
	/** repayDate 指定还款日期. */
	private Date	repayDate;
	/** repayRate 原始还款利率. */
	private String	repayRate;
	/** repayType 放款类型. */
	private String	repayType;
	/** contractNo 合同编号（借据编号）LIST(可以单个合同，也支持多合同). */
	private String	contractNo;
	/** createTime 创建时间. */
	private Date	createTime;
	/** lendAmount 实际放款金额. */
	private Long	lendAmount;
	/** loanAmount 借款金额. */
	private Long	loanAmount;
	/** merchantId 商户编码. */
	private Long	merchantId;
	/** modifyTime 修改时间. */
	private Date	modifyTime;
	/** approveDate 审批日期. */
	private Date	approveDate;
	/** approveTime 审批时间. */
	private Date	approveTime;
	/** productType 产品类型. */
	private String	productType;
	/** receiptRate 收款利率. */
	private String	receiptRate;
	/** repayPeriod 放款期数. */
	private Integer	repayPeriod;
	/** repayStatus 当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）. */
	private String	repayStatus;
	/** contractType 合同类型（1：单合同/单借据，2：多合同/多借据）. */
	private String	contractType;
	/** interestAccu 截至当前累计已还本金金额. */
	private Long	interestAccu;
	/** overdueTimes 逾期次数. */
	private Integer	overdueTimes;
	/** platformRate 平台收益率（IF CHANNEL=1,通过撮合平台需要计算平台收益）. */
	private String	platformRate;
	/** accountAmount 建账金额. */
	private Long	accountAmount;
	/** capitalAmount 本金金额. */
	private Long	capitalAmount;
	/** lastRepayDate 最后还款日. */
	private Date	lastRepayDate;
	/** maxOverdueDay 最大逾期天数. */
	private Integer	maxOverdueDay;
	/** nextRepayDate 下一还款日. */
	private Date	nextRepayDate;
	/** punishFeeAccu 截至当前罚息费用总额. */
	private Long	punishFeeAccu;
	/** repayAcctBank 还款账号开户行. */
	private String	repayAcctBank;
	/** capitalAdvance 预收本金. */
	private Long	capitalAdvance;
	/** contractAmount 合同金额. */
	private Long	contractAmount;
	/** currOverdueDay 当前逾期天数. */
	private Integer	currOverdueDay;
	/** firstRepayDate 起始还款日. */
	private Date	firstRepayDate;
	/** repayAccountNo 还款绑定账号. */
	private String	repayAccountNo;
	/** serviceFeeAccu 截至当前服务费用总额. */
	private Long	serviceFeeAccu;
	/** interestAdvance 预收利息. */
	private Long	interestAdvance;
	/** repayAcctMobile 还款账号预留手机号. */
	private String	repayAcctMobile;
	/** repayAccountName 还款账号开户名. */
	private String	repayAccountName;
	/** totalCapitalLeft 截至当前剩余本金（用于全额提前还款试算）. */
	private Long	totalCapitalLeft;
	/** repayFloatingRate 上浮比率（-20% — +20%）. */
	private String	repayFloatingRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIsFullFee() {
        return isFullFee;
    }

    public void setIsFullFee(String isFullFee) {
        this.isFullFee = isFullFee;
    }

    public String getLoanUsage() {
        return loanUsage;
    }

    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(String repayRate) {
        this.repayRate = repayRate;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLendAmount() {
        return lendAmount;
    }

    public void setLendAmount(Long lendAmount) {
        this.lendAmount = lendAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getReceiptRate() {
        return receiptRate;
    }

    public void setReceiptRate(String receiptRate) {
        this.receiptRate = receiptRate;
    }

    public Integer getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(Integer repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Long getInterestAccu() {
        return interestAccu;
    }

    public void setInterestAccu(Long interestAccu) {
        this.interestAccu = interestAccu;
    }

    public Integer getOverdueTimes() {
        return overdueTimes;
    }

    public void setOverdueTimes(Integer overdueTimes) {
        this.overdueTimes = overdueTimes;
    }

    public String getPlatformRate() {
        return platformRate;
    }

    public void setPlatformRate(String platformRate) {
        this.platformRate = platformRate;
    }

    public Long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Long accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Long getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(Long capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public Date getLastRepayDate() {
        return lastRepayDate;
    }

    public void setLastRepayDate(Date lastRepayDate) {
        this.lastRepayDate = lastRepayDate;
    }

    public Integer getMaxOverdueDay() {
        return maxOverdueDay;
    }

    public void setMaxOverdueDay(Integer maxOverdueDay) {
        this.maxOverdueDay = maxOverdueDay;
    }

    public Date getNextRepayDate() {
        return nextRepayDate;
    }

    public void setNextRepayDate(Date nextRepayDate) {
        this.nextRepayDate = nextRepayDate;
    }

    public Long getPunishFeeAccu() {
        return punishFeeAccu;
    }

    public void setPunishFeeAccu(Long punishFeeAccu) {
        this.punishFeeAccu = punishFeeAccu;
    }

    public String getRepayAcctBank() {
        return repayAcctBank;
    }

    public void setRepayAcctBank(String repayAcctBank) {
        this.repayAcctBank = repayAcctBank;
    }

    public Long getCapitalAdvance() {
        return capitalAdvance;
    }

    public void setCapitalAdvance(Long capitalAdvance) {
        this.capitalAdvance = capitalAdvance;
    }

    public Long getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Long contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Integer getCurrOverdueDay() {
        return currOverdueDay;
    }

    public void setCurrOverdueDay(Integer currOverdueDay) {
        this.currOverdueDay = currOverdueDay;
    }

    public Date getFirstRepayDate() {
        return firstRepayDate;
    }

    public void setFirstRepayDate(Date firstRepayDate) {
        this.firstRepayDate = firstRepayDate;
    }

    public String getRepayAccountNo() {
        return repayAccountNo;
    }

    public void setRepayAccountNo(String repayAccountNo) {
        this.repayAccountNo = repayAccountNo;
    }

    public Long getServiceFeeAccu() {
        return serviceFeeAccu;
    }

    public void setServiceFeeAccu(Long serviceFeeAccu) {
        this.serviceFeeAccu = serviceFeeAccu;
    }

    public Long getInterestAdvance() {
        return interestAdvance;
    }

    public void setInterestAdvance(Long interestAdvance) {
        this.interestAdvance = interestAdvance;
    }

    public String getRepayAcctMobile() {
        return repayAcctMobile;
    }

    public void setRepayAcctMobile(String repayAcctMobile) {
        this.repayAcctMobile = repayAcctMobile;
    }

    public String getRepayAccountName() {
        return repayAccountName;
    }

    public void setRepayAccountName(String repayAccountName) {
        this.repayAccountName = repayAccountName;
    }

    public Long getTotalCapitalLeft() {
        return totalCapitalLeft;
    }

    public void setTotalCapitalLeft(Long totalCapitalLeft) {
        this.totalCapitalLeft = totalCapitalLeft;
    }

    public String getRepayFloatingRate() {
        return repayFloatingRate;
    }

    public void setRepayFloatingRate(String repayFloatingRate) {
        this.repayFloatingRate = repayFloatingRate;
    }
}

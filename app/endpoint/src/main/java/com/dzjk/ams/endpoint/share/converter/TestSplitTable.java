package com.dzjk.ams.endpoint.share.converter;

import com.dzjk.ams.dal.dataobject.AccountingDO;
import com.dzjk.ams.facade.model.AccountingModel;

/** @author climb.s
 * @date 2018/2/11 06:39 */
public class TestSplitTable {

	public static AccountingDO reConverter(final AccountingModel target) {
		AccountingDO toVo = new AccountingDO();
		toVo.setRepayFloatingRate(target.getRepayFloatingRate());
		toVo.setTotalCapitalLeft(target.getTotalCapitalLeft());
		toVo.setRepayAccountName(target.getRepayAccountName());
		toVo.setRepayAcctMobile(target.getRepayAcctMobile());
		toVo.setInterestAdvance(target.getInterestAdvance());
		toVo.setServiceFeeAccu(target.getServiceFeeAccu());
		toVo.setRepayAccountNo(target.getRepayAccountNo());
		toVo.setFirstRepayDate(target.getFirstRepayDate());
		toVo.setCurrOverdueDay(target.getCurrOverdueDay());
		toVo.setContractAmount(target.getContractAmount());
		toVo.setCapitalAdvance(target.getCapitalAdvance());
		toVo.setRepayAcctBank(target.getRepayAcctBank());
		toVo.setPunishFeeAccu(target.getPunishFeeAccu());
		toVo.setNextRepayDate(target.getNextRepayDate());
		toVo.setMaxOverdueDay(target.getMaxOverdueDay());
		toVo.setLastRepayDate(target.getLastRepayDate());
		toVo.setCapitalAmount(target.getCapitalAmount());
		toVo.setAccountAmount(target.getAccountAmount());
		toVo.setPlatformRate(target.getPlatformRate());
		toVo.setOverdueTimes(target.getOverdueTimes());
		toVo.setInterestAccu(target.getInterestAccu());
		toVo.setContractType(target.getContractType());
		toVo.setRepayStatus(target.getRepayStatus());
		toVo.setRepayPeriod(target.getRepayPeriod());
		toVo.setReceiptRate(target.getReceiptRate());
		toVo.setProductType(target.getProductType());
		toVo.setApproveTime(target.getApproveTime());
		toVo.setApproveDate(target.getApproveDate());
		toVo.setModifyTime(target.getModifyTime());
		toVo.setMerchantId(target.getMerchantId());
		toVo.setLoanAmount(target.getLoanAmount());
		toVo.setLendAmount(target.getLendAmount());
		toVo.setCreateTime(target.getCreateTime());
		toVo.setContractNo(target.getContractNo());
		toVo.setRepayType(target.getRepayType());
		toVo.setRepayRate(target.getRepayRate());
		toVo.setRepayDate(target.getRepayDate());
		toVo.setProductId(target.getProductId());
		toVo.setLoanUsage(target.getLoanUsage());
		toVo.setIsFullFee(target.getIsFullFee());
		toVo.setAccountId(target.getAccountId());
		toVo.setUserName(target.getUserName());
		toVo.setRateType(target.getRateType());
		toVo.setModifier(target.getModifier());
		toVo.setLendTime(target.getLendTime());
		toVo.setLendDate(target.getLendDate());
		toVo.setCertType(target.getCertType());
		toVo.setCreater(target.getCreater());
		toVo.setMobile(target.getMobile());
		toVo.setCertNo(target.getCertNo());
		toVo.setRoute(target.getRoute());
		toVo.setBoId(target.getBoId());
		toVo.setId(target.getId());
		return toVo;
	}
}

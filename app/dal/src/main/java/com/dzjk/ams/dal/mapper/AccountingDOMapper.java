package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.AccountingDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_ACCOUNTING.
 * AMS_ACCOUNTING
 */
public interface AccountingDOMapper{

    /**
     * desc:插入表:AMS_ACCOUNTING.<br/>
     * descSql =  INSERT INTO AMS_ACCOUNTING_${route}( ID ,ROUTE )VALUES( #{id,jdbcType=VARCHAR} , #{route,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insertByRoute(AccountingDO entity);
    /**
     * desc:更新表:AMS_ACCOUNTING.<br/>
     * descSql =  UPDATE AMS_ACCOUNTING_#{route} SET BO_ID = #{boId,jdbcType=BIGINT} ,ROUTE = #{route,jdbcType=VARCHAR} ,CERT_NO = #{certNo,jdbcType=VARCHAR} ,MOBILE = #{mobile,jdbcType=VARCHAR} ,CREATER = #{creater,jdbcType=VARCHAR} ,CERT_TYPE = #{certType,jdbcType=VARCHAR} ,LEND_DATE = #{lendDate,jdbcType=TIMESTAMP} ,LEND_TIME = #{lendTime,jdbcType=TIMESTAMP} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,RATE_TYPE = #{rateType,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,ACCOUNT_ID = #{accountId,jdbcType=VARCHAR} ,IS_FULL_FEE = #{isFullFee,jdbcType=VARCHAR} ,LOAN_USAGE = #{loanUsage,jdbcType=VARCHAR} ,PRODUCT_ID = #{productId,jdbcType=BIGINT} ,REPAY_DATE = #{repayDate,jdbcType=TIMESTAMP} ,REPAY_RATE = #{repayRate,jdbcType=VARCHAR} ,REPAY_TYPE = #{repayType,jdbcType=VARCHAR} ,CONTRACT_NO = #{contractNo,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,LEND_AMOUNT = #{lendAmount,jdbcType=BIGINT} ,LOAN_AMOUNT = #{loanAmount,jdbcType=BIGINT} ,MERCHANT_ID = #{merchantId,jdbcType=BIGINT} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} ,APPROVE_DATE = #{approveDate,jdbcType=TIMESTAMP} ,APPROVE_TIME = #{approveTime,jdbcType=TIMESTAMP} ,PRODUCT_TYPE = #{productType,jdbcType=VARCHAR} ,RECEIPT_RATE = #{receiptRate,jdbcType=VARCHAR} ,REPAY_PERIOD = #{repayPeriod,jdbcType=INTEGER} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,CONTRACT_TYPE = #{contractType,jdbcType=VARCHAR} ,INTEREST_ACCU = #{interestAccu,jdbcType=BIGINT} ,OVERDUE_TIMES = #{overdueTimes,jdbcType=INTEGER} ,PLATFORM_RATE = #{platformRate,jdbcType=VARCHAR} ,ACCOUNT_AMOUNT = #{accountAmount,jdbcType=BIGINT} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=BIGINT} ,LAST_REPAY_DATE = #{lastRepayDate,jdbcType=TIMESTAMP} ,MAX_OVERDUE_DAY = #{maxOverdueDay,jdbcType=INTEGER} ,NEXT_REPAY_DATE = #{nextRepayDate,jdbcType=TIMESTAMP} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=BIGINT} ,REPAY_ACCT_BANK = #{repayAcctBank,jdbcType=VARCHAR} ,CAPITAL_ADVANCE = #{capitalAdvance,jdbcType=BIGINT} ,CONTRACT_AMOUNT = #{contractAmount,jdbcType=BIGINT} ,CURR_OVERDUE_DAY = #{currOverdueDay,jdbcType=INTEGER} ,FIRST_REPAY_DATE = #{firstRepayDate,jdbcType=TIMESTAMP} ,REPAY_ACCOUNT_NO = #{repayAccountNo,jdbcType=VARCHAR} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=BIGINT} ,INTEREST_ADVANCE = #{interestAdvance,jdbcType=BIGINT} ,REPAY_ACCT_MOBILE = #{repayAcctMobile,jdbcType=VARCHAR} ,REPAY_ACCOUNT_NAME = #{repayAccountName,jdbcType=VARCHAR} ,TOTAL_CAPITAL_LEFT = #{totalCapitalLeft,jdbcType=BIGINT} ,REPAY_FLOATING_RATE = #{repayFloatingRate,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    Long updateByRoute(AccountingDO entity);
    /**
     * desc:根据主键删除数据:AMS_ACCOUNTING.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNTING_#{route} WHERE ID = #{id,jdbcType=VARCHAR}
    * @param params params
    * the define of params
    *     id id
    *     route route
     * @return Long
     */
    Long deleteByPrimaryByRoute(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNTING.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNTING_#{route} WHERE ID = #{id,jdbcType=VARCHAR}
    * @param params params
    * the define of params
    *     id id
    *     route route
     * @return AccountingDO
     */
    AccountingDO getByPrimaryByRoute(Map<String,Object> params);
}

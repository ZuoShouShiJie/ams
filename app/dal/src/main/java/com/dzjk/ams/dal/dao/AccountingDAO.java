package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.AccountingDO;
import com.dzjk.ams.dal.mapper.AccountingDOMapper;

import javax.annotation.Resource;

/**
* The Table AMS_ACCOUNTING.
* AMS_ACCOUNTING
*/
@Repository
public class AccountingDAO{

    @Resource
    private AccountingDOMapper accountingDOMapper;

    /**
     * desc:插入表:AMS_ACCOUNTING.<br/>
     * descSql =  INSERT INTO AMS_ACCOUNTING_${route}( ID ,ROUTE )VALUES( #{id,jdbcType=VARCHAR} , #{route,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insertByRoute(AccountingDO entity){
        return accountingDOMapper.insertByRoute(entity);
    }
    /**
     * desc:更新表:AMS_ACCOUNTING.<br/>
     * descSql =  UPDATE AMS_ACCOUNTING_#{route} SET BO_ID = #{boId,jdbcType=BIGINT} ,ROUTE = #{route,jdbcType=VARCHAR} ,CERT_NO = #{certNo,jdbcType=VARCHAR} ,MOBILE = #{mobile,jdbcType=VARCHAR} ,CREATER = #{creater,jdbcType=VARCHAR} ,CERT_TYPE = #{certType,jdbcType=VARCHAR} ,LEND_DATE = #{lendDate,jdbcType=TIMESTAMP} ,LEND_TIME = #{lendTime,jdbcType=TIMESTAMP} ,MODIFIER = #{modifier,jdbcType=VARCHAR} ,RATE_TYPE = #{rateType,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,ACCOUNT_ID = #{accountId,jdbcType=VARCHAR} ,IS_FULL_FEE = #{isFullFee,jdbcType=VARCHAR} ,LOAN_USAGE = #{loanUsage,jdbcType=VARCHAR} ,PRODUCT_ID = #{productId,jdbcType=BIGINT} ,REPAY_DATE = #{repayDate,jdbcType=TIMESTAMP} ,REPAY_RATE = #{repayRate,jdbcType=VARCHAR} ,REPAY_TYPE = #{repayType,jdbcType=VARCHAR} ,CONTRACT_NO = #{contractNo,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,LEND_AMOUNT = #{lendAmount,jdbcType=BIGINT} ,LOAN_AMOUNT = #{loanAmount,jdbcType=BIGINT} ,MERCHANT_ID = #{merchantId,jdbcType=BIGINT} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} ,APPROVE_DATE = #{approveDate,jdbcType=TIMESTAMP} ,APPROVE_TIME = #{approveTime,jdbcType=TIMESTAMP} ,PRODUCT_TYPE = #{productType,jdbcType=VARCHAR} ,RECEIPT_RATE = #{receiptRate,jdbcType=VARCHAR} ,REPAY_PERIOD = #{repayPeriod,jdbcType=INTEGER} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,CONTRACT_TYPE = #{contractType,jdbcType=VARCHAR} ,INTEREST_ACCU = #{interestAccu,jdbcType=BIGINT} ,OVERDUE_TIMES = #{overdueTimes,jdbcType=INTEGER} ,PLATFORM_RATE = #{platformRate,jdbcType=VARCHAR} ,ACCOUNT_AMOUNT = #{accountAmount,jdbcType=BIGINT} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=BIGINT} ,LAST_REPAY_DATE = #{lastRepayDate,jdbcType=TIMESTAMP} ,MAX_OVERDUE_DAY = #{maxOverdueDay,jdbcType=INTEGER} ,NEXT_REPAY_DATE = #{nextRepayDate,jdbcType=TIMESTAMP} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=BIGINT} ,REPAY_ACCT_BANK = #{repayAcctBank,jdbcType=VARCHAR} ,CAPITAL_ADVANCE = #{capitalAdvance,jdbcType=BIGINT} ,CONTRACT_AMOUNT = #{contractAmount,jdbcType=BIGINT} ,CURR_OVERDUE_DAY = #{currOverdueDay,jdbcType=INTEGER} ,FIRST_REPAY_DATE = #{firstRepayDate,jdbcType=TIMESTAMP} ,REPAY_ACCOUNT_NO = #{repayAccountNo,jdbcType=VARCHAR} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=BIGINT} ,INTEREST_ADVANCE = #{interestAdvance,jdbcType=BIGINT} ,REPAY_ACCT_MOBILE = #{repayAcctMobile,jdbcType=VARCHAR} ,REPAY_ACCOUNT_NAME = #{repayAccountName,jdbcType=VARCHAR} ,TOTAL_CAPITAL_LEFT = #{totalCapitalLeft,jdbcType=BIGINT} ,REPAY_FLOATING_RATE = #{repayFloatingRate,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    public Long updateByRoute(AccountingDO entity){
        return accountingDOMapper.updateByRoute(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_ACCOUNTING.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNTING_#{route} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @param route route
     * @return Long
     */
    public Long deleteByPrimaryByRoute(String id,String route){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("route",route);
        return accountingDOMapper.deleteByPrimaryByRoute(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNTING.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNTING_#{route} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @param route route
     * @return AccountingDO
     */
    public AccountingDO getByPrimaryByRoute(String id,String route){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("route",route);
        return accountingDOMapper.getByPrimaryByRoute(params);

    }
}

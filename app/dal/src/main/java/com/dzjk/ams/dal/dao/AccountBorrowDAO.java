package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.AccountBorrowDO;
import java.util.List;
import com.dzjk.ams.dal.mapper.AccountBorrowDOMapper;

/**
* The Table AMS_ACCOUNT_BORROW.
* AMS_ACCOUNT_BORROW
*/
@Repository("ams.AccountBorrowDAO")
public class AccountBorrowDAO{

    @Autowired
    private AccountBorrowDOMapper accountBorrowDOMapper;

    /**
     * desc:插入表:AMS_ACCOUNT_BORROW.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_BORROW( ID ,BO_ID ,ORG_ID ,STATUS ,USER_ID ,CHANNEL ,BR_USER_ID ,LEND_TIME ,RATE_TYPE ,APPLY_TIME ,CREATED_BY ,IS_FULL_FEE ,LOAN_USAGE ,REPAY_DATE ,REPAY_RATE ,REPAY_TYPE ,UPDATED_BY ,CONTRACT_NO ,LEND_AMOUNT ,LOAN_AMOUNT ,APPROVE_TIME ,CREATED_TIME ,PRODUCT_CODE ,PRODUCT_TYPE ,RECEIPT_RATE ,REPAY_PERIOD ,REPAY_STATUS ,UPDATED_TIME ,CONTRACT_TYPE ,INTEREST_ACCU ,OVERDUE_TIMES ,PLATFORM_RATE ,ACCOUNT_AMOUNT ,CAPITAL_AMOUNT ,LAST_REPAY_DATE ,MAX_OVERDUE_DAY ,NEXT_REPAY_DATE ,PUNISH_FEE_ACCU ,REPAY_ACCT_BANK ,CAPITAL_ADVANCE ,CONTRACT_AMOUNT ,CURR_OVERDUE_DAY ,FIRST_REPAY_DATE ,REPAY_ACCOUNT_NO ,REPAY_ACCT_PHONE ,SERVICE_FEE_ACCU ,INTEREST_ADVANCE ,REPAY_ACCOUNT_NAME ,TOTAL_CAPITAL_ACCU ,TOTAL_CAPITAL_LEFT ,REPAY_FLOATING_RATE )VALUES( #{id,jdbcType=BIGINT} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{channel,jdbcType=VARCHAR} , #{brUserId,jdbcType=VARCHAR} , #{lendTime,jdbcType=TIMESTAMP} , #{rateType,jdbcType=VARCHAR} , #{applyTime,jdbcType=TIMESTAMP} , #{createdBy,jdbcType=VARCHAR} , #{isFullFee,jdbcType=VARCHAR} , #{loanUsage,jdbcType=VARCHAR} , #{repayDate,jdbcType=VARCHAR} , #{repayRate,jdbcType=DECIMAL} , #{repayType,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{contractNo,jdbcType=VARCHAR} , #{lendAmount,jdbcType=DECIMAL} , #{loanAmount,jdbcType=DECIMAL} , #{approveTime,jdbcType=TIMESTAMP} , #{createdTime,jdbcType=TIMESTAMP} , #{productCode,jdbcType=VARCHAR} , #{productType,jdbcType=VARCHAR} , #{receiptRate,jdbcType=DECIMAL} , #{repayPeriod,jdbcType=VARCHAR} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{contractType,jdbcType=VARCHAR} , #{interestAccu,jdbcType=DECIMAL} , #{overdueTimes,jdbcType=VARCHAR} , #{platformRate,jdbcType=DECIMAL} , #{accountAmount,jdbcType=DECIMAL} , #{capitalAmount,jdbcType=DECIMAL} , #{lastRepayDate,jdbcType=DATE} , #{maxOverdueDay,jdbcType=VARCHAR} , #{nextRepayDate,jdbcType=DATE} , #{punishFeeAccu,jdbcType=DECIMAL} , #{repayAcctBank,jdbcType=VARCHAR} , #{capitalAdvance,jdbcType=DECIMAL} , #{contractAmount,jdbcType=DECIMAL} , #{currOverdueDay,jdbcType=VARCHAR} , #{firstRepayDate,jdbcType=DATE} , #{repayAccountNo,jdbcType=VARCHAR} , #{repayAcctPhone,jdbcType=VARCHAR} , #{serviceFeeAccu,jdbcType=DECIMAL} , #{interestAdvance,jdbcType=DECIMAL} , #{repayAccountName,jdbcType=VARCHAR} , #{totalCapitalAccu,jdbcType=DECIMAL} , #{totalCapitalLeft,jdbcType=DECIMAL} , #{repayFloatingRate,jdbcType=DECIMAL} )
     * @param entity entity
     * @return Long
     */
    public Long insert(AccountBorrowDO entity){
        return accountBorrowDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_ACCOUNT_BORROW.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_BORROW SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,CHANNEL = #{channel,jdbcType=VARCHAR} ,BR_USER_ID = #{brUserId,jdbcType=VARCHAR} ,LEND_TIME = #{lendTime,jdbcType=TIMESTAMP} ,RATE_TYPE = #{rateType,jdbcType=VARCHAR} ,APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,IS_FULL_FEE = #{isFullFee,jdbcType=VARCHAR} ,LOAN_USAGE = #{loanUsage,jdbcType=VARCHAR} ,REPAY_DATE = #{repayDate,jdbcType=VARCHAR} ,REPAY_RATE = #{repayRate,jdbcType=DECIMAL} ,REPAY_TYPE = #{repayType,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CONTRACT_NO = #{contractNo,jdbcType=VARCHAR} ,LEND_AMOUNT = #{lendAmount,jdbcType=DECIMAL} ,LOAN_AMOUNT = #{loanAmount,jdbcType=DECIMAL} ,APPROVE_TIME = #{approveTime,jdbcType=TIMESTAMP} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,PRODUCT_CODE = #{productCode,jdbcType=VARCHAR} ,PRODUCT_TYPE = #{productType,jdbcType=VARCHAR} ,RECEIPT_RATE = #{receiptRate,jdbcType=DECIMAL} ,REPAY_PERIOD = #{repayPeriod,jdbcType=VARCHAR} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,CONTRACT_TYPE = #{contractType,jdbcType=VARCHAR} ,INTEREST_ACCU = #{interestAccu,jdbcType=DECIMAL} ,OVERDUE_TIMES = #{overdueTimes,jdbcType=VARCHAR} ,PLATFORM_RATE = #{platformRate,jdbcType=DECIMAL} ,ACCOUNT_AMOUNT = #{accountAmount,jdbcType=DECIMAL} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,LAST_REPAY_DATE = #{lastRepayDate,jdbcType=DATE} ,MAX_OVERDUE_DAY = #{maxOverdueDay,jdbcType=VARCHAR} ,NEXT_REPAY_DATE = #{nextRepayDate,jdbcType=DATE} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=DECIMAL} ,REPAY_ACCT_BANK = #{repayAcctBank,jdbcType=VARCHAR} ,CAPITAL_ADVANCE = #{capitalAdvance,jdbcType=DECIMAL} ,CONTRACT_AMOUNT = #{contractAmount,jdbcType=DECIMAL} ,CURR_OVERDUE_DAY = #{currOverdueDay,jdbcType=VARCHAR} ,FIRST_REPAY_DATE = #{firstRepayDate,jdbcType=DATE} ,REPAY_ACCOUNT_NO = #{repayAccountNo,jdbcType=VARCHAR} ,REPAY_ACCT_PHONE = #{repayAcctPhone,jdbcType=VARCHAR} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=DECIMAL} ,INTEREST_ADVANCE = #{interestAdvance,jdbcType=DECIMAL} ,REPAY_ACCOUNT_NAME = #{repayAccountName,jdbcType=VARCHAR} ,TOTAL_CAPITAL_ACCU = #{totalCapitalAccu,jdbcType=DECIMAL} ,TOTAL_CAPITAL_LEFT = #{totalCapitalLeft,jdbcType=DECIMAL} ,REPAY_FLOATING_RATE = #{repayFloatingRate,jdbcType=DECIMAL} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(AccountBorrowDO entity){
        return accountBorrowDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_BORROW.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_BORROW WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return Long
     */
    public Long deleteByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountBorrowDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_BORROW.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_BORROW WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return AccountBorrowDO
     */
    public AccountBorrowDO getByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountBorrowDOMapper.getByPrimary(params);

    }
    /**
     * desc:queryAccountInfo.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_BORROW WHERE 1= 1 AND USER_ID = #{userId,jdbcType=VARCHAR} AND BO_ID = #{boId,jdbcType=VARCHAR} AND ORG_ID = #{orgId,jdbcType=INTEGER} 
     * @param orgId orgId
     * @param boId boId
     * @param userId userId
     * @return List<AccountBorrowDO>
     */
    public List<AccountBorrowDO> queryAccountInfo(Long orgId,String boId,String userId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("orgId",orgId);
        params.put("boId",boId);
        params.put("userId",userId);
        return accountBorrowDOMapper.queryAccountInfo(params);
    }

    public Long updateBorrowSuccess(AccountBorrowDO entity){
        return accountBorrowDOMapper.updateBorrowSuccess(entity);
    }
    public Long updateBorrowFail(AccountBorrowDO entity){
        return accountBorrowDOMapper.updateBorrowFail(entity);
    }

    /**
     * 修改还款状态
     * @param entity
     * @return
     */
    public Long updateRepayStatus(AccountBorrowDO entity){
        return accountBorrowDOMapper.updateRepayStatus(entity);
    }

    /**
     * 修改产品费率
     * @param entity
     * @return
     */
    public Long updateRepayRate(AccountBorrowDO entity){
        return accountBorrowDOMapper.updateRepayRate(entity);
    }


    public Long updateStatus(AccountBorrowDO entity){
        return accountBorrowDOMapper.updateStatus(entity);
    }


}

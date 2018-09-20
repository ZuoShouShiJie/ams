package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.AccountEarningsDO;
import com.dzjk.ams.dal.dataobject.AccountEarningsExDO;
import java.util.List;
import java.lang.Integer;
import java.util.Map;

import com.dzjk.ams.dal.dataobject.AccountRepayExDO;
import com.dzjk.ams.dal.dataobject.AccountRepayPlanDO;
import com.dzjk.ams.dal.paging.QueryPlatEarningsPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_ACCOUNT_EARNINGS.
 * AMS_ACCOUNT_EARNINGS
 */
public interface AccountEarningsDOMapper{

    /**
     * desc:插入表:AMS_ACCOUNT_EARNINGS.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_EARNINGS( ID ,BO_ID ,ORG_ID ,STATUS ,BO_USER_ID ,ACCOUNT_ID ,CREATED_BY ,IS_FULL_FEE ,PERIOD_NUM ,REPAY_DATE ,UPDATED_BY ,OVERDUE_DAY ,CREATED_TIME ,REPAY_STATUS ,UPDATED_TIME ,SERVICE_FEE_ID ,CAPITAL_AMOUNT ,PUNISH_FEE_ACCU ,REAL_REPAY_DATE ,INTEREST_AMOUNT ,SERVICE_FEE_ACCU ,PUNISH_UPDATED_TIME ,MERCHANT_SERVICE_FEE )VALUES( #{id,jdbcType=INTEGER} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=INTEGER} , #{status,jdbcType=VARCHAR} , #{boUserId,jdbcType=VARCHAR} , #{accountId,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{isFullFee,jdbcType=VARCHAR} , #{periodNum,jdbcType=VARCHAR} , #{repayDate,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{overdueDay,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{serviceFeeId,jdbcType=VARCHAR} , #{capitalAmount,jdbcType=DECIMAL} , #{punishFeeAccu,jdbcType=DECIMAL} , #{realRepayDate,jdbcType=VARCHAR} , #{interestAmount,jdbcType=DECIMAL} , #{serviceFeeAccu,jdbcType=DECIMAL} , #{punishUpdatedTime,jdbcType=TIMESTAMP} , #{merchantServiceFee,jdbcType=DECIMAL} )
     * @param entity entity
     * @return Long
     */
    Long insert(AccountEarningsDO entity);
    /**
     * desc:更新表:AMS_ACCOUNT_EARNINGS.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_EARNINGS SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,BO_USER_ID = #{boUserId,jdbcType=VARCHAR} ,ACCOUNT_ID = #{accountId,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,IS_FULL_FEE = #{isFullFee,jdbcType=VARCHAR} ,PERIOD_NUM = #{periodNum,jdbcType=VARCHAR} ,REPAY_DATE = #{repayDate,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,OVERDUE_DAY = #{overdueDay,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,SERVICE_FEE_ID = #{serviceFeeId,jdbcType=VARCHAR} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=DECIMAL} ,REAL_REPAY_DATE = #{realRepayDate,jdbcType=VARCHAR} ,INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=DECIMAL} ,PUNISH_UPDATED_TIME = #{punishUpdatedTime,jdbcType=TIMESTAMP} ,MERCHANT_SERVICE_FEE = #{merchantServiceFee,jdbcType=DECIMAL} WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(AccountEarningsDO entity);
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_EARNINGS.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_EARNINGS WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return Long
     */
    Long deleteByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_EARNINGS.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_EARNINGS WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return AccountEarningsDO
     */
    AccountEarningsDO getByPrimary(Map<String,Object> params);
    /**
     * desc:根据userId和借款编号查询.<br/>
     * descSql =  SELECT earnings.*,sum(fee.fee_amount) as 'serviceFee' FROM AMS_ACCOUNT_EARNINGS earnings,ams_account_earnings_service_fee fee WHERE earnings.status=1 and earnings.service_fee_id = fee.service_fee_id and fee.fee_type=#{feeType,jdbcType=VARCHAR} and earnings.USER_ID = #{userId,jdbcType=VARCHAR} AND earnings.BO_ID = #{boId,jdbcType=VARCHAR} limit #{pageNo,jdbcType=INTEGER},#{pageRec,jdbcType=INTEGER}
    * the define of params
    *     boId boId
    *     userId userId
    *     feeType feeType
    *     pageNo pageNo
    *     pageRec pageRec
     * @return List<AccountEarningsExDO>
     */
    List<AccountEarningsExDO> queryPlatEarnings(QueryPlatEarningsPage page);

    /**
     * desc:总条数.<br/>
     * descSql =  SELECT count(*) FROM AMS_ACCOUNT_EARNINGS earnings,ams_account_earnings_service_fee fee WHERE earnings.status=1 and earnings.service_fee_id = fee.service_fee_id and fee.fee_type=#{feeType,jdbcType=VARCHAR} and earnings.USER_ID = #{userId,jdbcType=VARCHAR} AND earnings.BO_ID = #{boId,jdbcType=VARCHAR} 
    * the define of params
    *     boId boId
    *     userId userId
    *     feeType feeType
     * @return Integer
     */
    Integer queryEarningsCount(QueryPlatEarningsPage page);

    Long updateStatus(AccountEarningsDO entity);
    Long updatePlanInfo(AccountEarningsDO entity);
    Long updatePlanFail(AccountEarningsDO entity);

    AccountEarningsExDO queryRepayStatus(AccountEarningsDO entity);
}

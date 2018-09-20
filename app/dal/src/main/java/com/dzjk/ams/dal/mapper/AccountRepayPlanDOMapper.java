package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.*;

import java.util.List;
import java.lang.Integer;
import java.util.Map;

import com.dzjk.ams.dal.paging.QueryRepayPlanPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_ACCOUNT_REPAY_PLAN.
 * AMS_ACCOUNT_REPAY_PLAN
 */
public interface AccountRepayPlanDOMapper{

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_PLAN( ID ,BO_ID ,ORG_ID ,STATUS ,USER_ID ,CHANNEL ,CREATED_BY ,PERIOD_NUM ,PUNISH_FEE ,REPAY_DATE ,UPDATED_BY ,OVERDUE_DAY ,SERVICE_FEE ,CREATED_TIME ,REPAY_STATUS ,UPDATED_TIME ,INTEREST_ACCU ,RETURN_AMOUNT ,SERVICE_FEE_ID ,CAPITAL_AMOUNT ,PUNISH_FEE_ACCU ,REAL_REPAY_DATE ,INTEREST_AMOUNT ,PUNISH_FEE_OWNER ,SERVICE_FEE_ACCU ,TOTAL_CAPITAL_ACCU ,TOTAL_CAPITAL_LEFT ,PUNISH_UPDATED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{channel,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{periodNum,jdbcType=VARCHAR} , #{punishFee,jdbcType=DECIMAL} , #{repayDate,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{overdueDay,jdbcType=VARCHAR} , #{serviceFee,jdbcType=DECIMAL} , #{createdTime,jdbcType=TIMESTAMP} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{interestAccu,jdbcType=DECIMAL} , #{returnAmount,jdbcType=DECIMAL} , #{serviceFeeId,jdbcType=VARCHAR} , #{capitalAmount,jdbcType=DECIMAL} , #{punishFeeAccu,jdbcType=DECIMAL} , #{realRepayDate,jdbcType=VARCHAR} , #{interestAmount,jdbcType=DECIMAL} , #{punishFeeOwner,jdbcType=VARCHAR} , #{serviceFeeAccu,jdbcType=DECIMAL} , #{totalCapitalAccu,jdbcType=DECIMAL} , #{totalCapitalLeft,jdbcType=DECIMAL} , #{punishUpdatedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(AccountRepayPlanDO entity);
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_PLAN SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,CHANNEL = #{channel,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,PERIOD_NUM = #{periodNum,jdbcType=VARCHAR} ,PUNISH_FEE = #{punishFee,jdbcType=DECIMAL} ,REPAY_DATE = #{repayDate,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,OVERDUE_DAY = #{overdueDay,jdbcType=VARCHAR} ,SERVICE_FEE = #{serviceFee,jdbcType=DECIMAL} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,INTEREST_ACCU = #{interestAccu,jdbcType=DECIMAL} ,RETURN_AMOUNT = #{returnAmount,jdbcType=DECIMAL} ,SERVICE_FEE_ID = #{serviceFeeId,jdbcType=VARCHAR} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=DECIMAL} ,REAL_REPAY_DATE = #{realRepayDate,jdbcType=VARCHAR} ,INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL} ,PUNISH_FEE_OWNER = #{punishFeeOwner,jdbcType=VARCHAR} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=DECIMAL} ,TOTAL_CAPITAL_ACCU = #{totalCapitalAccu,jdbcType=DECIMAL} ,TOTAL_CAPITAL_LEFT = #{totalCapitalLeft,jdbcType=DECIMAL} ,PUNISH_UPDATED_TIME = #{punishUpdatedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(AccountRepayPlanDO entity);
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_PLAN WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param params params
     * the define of params
     *     id id
     *     orgId orgId
     * @return Long
     */
    Long deleteByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_PLAN WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param params params
     * the define of params
     *     id id
     *     orgId orgId
     * @return AccountRepayPlanDO
     */
    AccountRepayPlanDO getByPrimary(Map<String,Object> params);
    /**
     * desc:通过userId 和boId查询还款计划.<br/>
     * descSql =  SELECT repay.ID,repay.BO_ID,repay.ORG_ID,repay.STATUS,repay.USER_ID,repay.CHANNEL,repay.CREATED_BY,repay.PERIOD_NUM,repay.PUNISH_FEE,repay.REPAY_DATE,repay.UPDATED_BY,repay.OVERDUE_DAY, repay.SERVICE_FEE,repay.CREATED_TIME,repay.REPAY_STATUS,repay.UPDATED_TIME,repay.INTEREST_ACCU,repay.RETURN_AMOUNT,repay.SERVICE_FEE_ID,repay.CAPITAL_AMOUNT,repay.PUNISH_FEE_ACCU,repay.REAL_REPAY_DATE,repay.INTEREST_AMOUNT,repay.PUNISH_FEE_OWNER,repay.SERVICE_FEE_ACCU, repay.TOTAL_CAPITAL_ACCU,repay.TOTAL_CAPITAL_LEFT,repay.PUNISH_UPDATED_TIME, sum(fee.fee_amount) as 'allServiceFee' FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR} limit #{pageNo,jdbcType=INTEGER},#{pageRec,jdbcType=INTEGER}

     * the define of params
     *     boId boId
     *     userId userId
     *     feeType feeType
     *     pageNo pageNo
     *     pageRec pageRec
     *     repayStatus repayStatus
     * @return List<AccountRepayExDO>
     */
    List<AccountRepayExDO> queryRepayPlanById(QueryRepayPlanPage page);
    /**
     * desc:.<br/>
     * descSql =  SELECT count(*) FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR}
     * @param params params
     * the define of params
     *     boId boId
     *     userId userId
     *     feeType feeType
     *     repayStatus repayStatus
     * @return Integer
     */
    Integer queryRepayPlanCount(QueryRepayPlanPage page);
    /**
     * desc:通过userId 和boId查询还款计划.<br/>
     * descSql =  SELECT repay.ID,repay.BO_ID,repay.ORG_ID,repay.STATUS,repay.USER_ID,repay.CHANNEL,repay.CREATED_BY,repay.PERIOD_NUM,repay.PUNISH_FEE,repay.REPAY_DATE,repay.UPDATED_BY,repay.OVERDUE_DAY, repay.SERVICE_FEE,repay.CREATED_TIME,repay.REPAY_STATUS,repay.UPDATED_TIME,repay.INTEREST_ACCU,repay.RETURN_AMOUNT,repay.SERVICE_FEE_ID,repay.CAPITAL_AMOUNT,repay.PUNISH_FEE_ACCU,repay.REAL_REPAY_DATE,repay.INTEREST_AMOUNT,repay.PUNISH_FEE_OWNER,repay.SERVICE_FEE_ACCU, repay.TOTAL_CAPITAL_ACCU,repay.TOTAL_CAPITAL_LEFT,repay.PUNISH_UPDATED_TIME, sum(fee.fee_amount) as 'allServiceFee' FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR}
     * @param params params
     * the define of params
     *     boId boId
     *     userId userId
     *     feeType feeType
     *     repayStatus repayStatus
     * @return List<AccountRepayExDO>
     */
    List<AccountRepayExDO> queryPreRepayTry(Map<String,Object> params);

    Long updateStatus(AccountRepayPlanDO entity);
    Long updatePlanInfo(AccountRepayPlanDO entity);
    Long updatePlanFail(AccountRepayPlanDO entity);


    AccountRepayExDO queryRepayStatus(AccountRepayPlanDO entity);

    List<AccountRepayExDO> queryRepayPlanByDate(AccountRepayPlanDO entity);

    //查询还款扣款文件字段
    List<TodayRepaymentDO> selectByAccountRepayPlanRepaymentDO(Map<String,Object> params);

    //查询当天还款文件字段
    List<TodayRepaymentDO> selectByTodayRepaymentDO(Map<String,Object> params);

}

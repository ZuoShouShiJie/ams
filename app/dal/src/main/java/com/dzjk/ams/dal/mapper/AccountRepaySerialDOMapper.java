package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.AccountRepaySerialDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_ACCOUNT_REPAY_SERIAL.
 * AMS_ACCOUNT_REPAY_SERIAL
 */
public interface AccountRepaySerialDOMapper{

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_SERIAL( ID ,BO_ID ,ORG_ID ,STATUS ,USER_ID ,CREATED_BY ,PERIOD_NUM ,REPAY_TIME ,REPAY_TYPE ,UPDATED_BY ,CREATED_TIME ,REPAY_AMOUNT ,REPAY_STATUS ,UPDATED_TIME ,SERIAL_NUMBER ,CAPITAL_AMOUNT ,INTEREST_AMOUNT )VALUES( #{id,jdbcType=BIGINT} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{periodNum,jdbcType=VARCHAR} , #{repayTime,jdbcType=TIMESTAMP} , #{repayType,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{repayAmount,jdbcType=DECIMAL} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{serialNumber,jdbcType=VARCHAR} , #{capitalAmount,jdbcType=DECIMAL} , #{interestAmount,jdbcType=DECIMAL} )
     * @param entity entity
     * @return Long
     */
    Long insert(AccountRepaySerialDO entity);
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_SERIAL SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,PERIOD_NUM = #{periodNum,jdbcType=VARCHAR} ,REPAY_TIME = #{repayTime,jdbcType=TIMESTAMP} ,REPAY_TYPE = #{repayType,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,REPAY_AMOUNT = #{repayAmount,jdbcType=DECIMAL} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,SERIAL_NUMBER = #{serialNumber,jdbcType=VARCHAR} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    Long update(AccountRepaySerialDO entity);
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_SERIAL WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return Long
     */
    Long deleteByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERIAL WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return AccountRepaySerialDO
     */
    AccountRepaySerialDO getByPrimary(Map<String,Object> params);
}

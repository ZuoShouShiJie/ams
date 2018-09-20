package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.AccountRepayServiceFeeDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_ACCOUNT_REPAY_SERVICE_FEE.
 * AMS_ACCOUNT_REPAY_SERVICE_FEE
 */
public interface AccountRepayServiceFeeDOMapper{

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_SERVICE_FEE( ID ,ORG_ID ,STATUS ,FEE_NAME ,FEE_TYPE ,CREATED_BY ,FEE_AMOUNT ,UPDATED_BY ,CREATED_TIME ,UPDATED_TIME ,SERVICE_FEE_ID )VALUES( #{id,jdbcType=INTEGER} , #{orgId,jdbcType=INTEGER} , #{status,jdbcType=VARCHAR} , #{feeName,jdbcType=VARCHAR} , #{feeType,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{feeAmount,jdbcType=DECIMAL} , #{updatedBy,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{updatedTime,jdbcType=TIMESTAMP} , #{serviceFeeId,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(AccountRepayServiceFeeDO entity);
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_SERVICE_FEE SET STATUS = #{status,jdbcType=VARCHAR} ,FEE_NAME = #{feeName,jdbcType=VARCHAR} ,FEE_TYPE = #{feeType,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,FEE_AMOUNT = #{feeAmount,jdbcType=DECIMAL} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,SERVICE_FEE_ID = #{serviceFeeId,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(AccountRepayServiceFeeDO entity);
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return Long
     */
    Long deleteByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
    * @param params params
    * the define of params
    *     id id
    *     orgId orgId
     * @return AccountRepayServiceFeeDO
     */
    AccountRepayServiceFeeDO getByPrimary(Map<String,Object> params);
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE status=1 and fee_type=#{feeType,jdbcType=VARCHAR} and service_fee_id = #{serviceFeeId,jdbcType=VARCHAR} AND ORG_ID = #{orgId,jdbcType=INTEGER} 
    * @param params params
    * the define of params
    *     orgId orgId
    *     feeType feeType
    *     serviceFeeId serviceFeeId
     * @return List<AccountRepayServiceFeeDO>
     */
    List<AccountRepayServiceFeeDO> getRepayFee(Map<String,Object> params);
}

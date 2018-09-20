package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.AccountRepayServiceFeeDO;
import java.util.List;
import com.dzjk.ams.dal.mapper.AccountRepayServiceFeeDOMapper;

/**
* The Table AMS_ACCOUNT_REPAY_SERVICE_FEE.
* AMS_ACCOUNT_REPAY_SERVICE_FEE
*/
@Repository("ams.AccountRepayServiceFeeDAO")
public class AccountRepayServiceFeeDAO{

    @Autowired
    private AccountRepayServiceFeeDOMapper accountRepayServiceFeeDOMapper;

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_SERVICE_FEE( ID ,ORG_ID ,STATUS ,FEE_NAME ,FEE_TYPE ,CREATED_BY ,FEE_AMOUNT ,UPDATED_BY ,CREATED_TIME ,UPDATED_TIME ,SERVICE_FEE_ID )VALUES( #{id,jdbcType=INTEGER} , #{orgId,jdbcType=INTEGER} , #{status,jdbcType=VARCHAR} , #{feeName,jdbcType=VARCHAR} , #{feeType,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{feeAmount,jdbcType=DECIMAL} , #{updatedBy,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{updatedTime,jdbcType=TIMESTAMP} , #{serviceFeeId,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(AccountRepayServiceFeeDO entity){
        return accountRepayServiceFeeDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_SERVICE_FEE SET STATUS = #{status,jdbcType=VARCHAR} ,FEE_NAME = #{feeName,jdbcType=VARCHAR} ,FEE_TYPE = #{feeType,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,FEE_AMOUNT = #{feeAmount,jdbcType=DECIMAL} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,SERVICE_FEE_ID = #{serviceFeeId,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(AccountRepayServiceFeeDO entity){
        return accountRepayServiceFeeDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
     * @param id id
     * @param orgId orgId
     * @return Long
     */
    public Long deleteByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepayServiceFeeDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE ID = #{id,jdbcType=INTEGER} AND ORG_ID = #{orgId,jdbcType=INTEGER}
     * @param id id
     * @param orgId orgId
     * @return AccountRepayServiceFeeDO
     */
    public AccountRepayServiceFeeDO getByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepayServiceFeeDOMapper.getByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERVICE_FEE.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERVICE_FEE WHERE status=1 and fee_type=#{feeType,jdbcType=VARCHAR} and service_fee_id = #{serviceFeeId,jdbcType=VARCHAR} AND ORG_ID = #{orgId,jdbcType=INTEGER} 
     * @param orgId orgId
     * @param feeType feeType
     * @param serviceFeeId serviceFeeId
     * @return List<AccountRepayServiceFeeDO>
     */
    public List<AccountRepayServiceFeeDO> getRepayFee(Long orgId,String feeType,String serviceFeeId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("orgId",orgId);
        params.put("feeType",feeType);
        params.put("serviceFeeId",serviceFeeId);
        return accountRepayServiceFeeDOMapper.getRepayFee(params);

    }
}

package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.AccountRepaySerialDO;
import com.dzjk.ams.dal.mapper.AccountRepaySerialDOMapper;

/**
* The Table AMS_ACCOUNT_REPAY_SERIAL.
* AMS_ACCOUNT_REPAY_SERIAL
*/
@Repository("ams.AccountRepaySerialDAO")
public class AccountRepaySerialDAO{

    @Autowired
    private AccountRepaySerialDOMapper accountRepaySerialDOMapper;

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_SERIAL( ID ,BO_ID ,ORG_ID ,STATUS ,USER_ID ,CREATED_BY ,PERIOD_NUM ,REPAY_TIME ,REPAY_TYPE ,UPDATED_BY ,CREATED_TIME ,REPAY_AMOUNT ,REPAY_STATUS ,UPDATED_TIME ,SERIAL_NUMBER ,CAPITAL_AMOUNT ,INTEREST_AMOUNT )VALUES( #{id,jdbcType=BIGINT} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{periodNum,jdbcType=VARCHAR} , #{repayTime,jdbcType=TIMESTAMP} , #{repayType,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{repayAmount,jdbcType=DECIMAL} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{serialNumber,jdbcType=VARCHAR} , #{capitalAmount,jdbcType=DECIMAL} , #{interestAmount,jdbcType=DECIMAL} )
     * @param entity entity
     * @return Long
     */
    public Long insert(AccountRepaySerialDO entity){
        return accountRepaySerialDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_SERIAL SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,PERIOD_NUM = #{periodNum,jdbcType=VARCHAR} ,REPAY_TIME = #{repayTime,jdbcType=TIMESTAMP} ,REPAY_TYPE = #{repayType,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,REPAY_AMOUNT = #{repayAmount,jdbcType=DECIMAL} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,SERIAL_NUMBER = #{serialNumber,jdbcType=VARCHAR} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(AccountRepaySerialDO entity){
        return accountRepaySerialDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_SERIAL WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return Long
     */
    public Long deleteByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepaySerialDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_SERIAL.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_SERIAL WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return AccountRepaySerialDO
     */
    public AccountRepaySerialDO getByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepaySerialDOMapper.getByPrimary(params);

    }
}

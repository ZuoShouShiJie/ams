package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import com.dzjk.ams.dal.dataobject.AccountRepayPlanRepaymentDO;
import com.dzjk.ams.dal.dataobject.TodayRepaymentDO;
import com.dzjk.ams.dal.paging.QueryRepayPlanPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.AccountRepayPlanDO;
import java.util.List;
import com.dzjk.ams.dal.dataobject.AccountRepayExDO;
import java.lang.Integer;
import com.dzjk.ams.dal.mapper.AccountRepayPlanDOMapper;

/**
 * The Table AMS_ACCOUNT_REPAY_PLAN.
 * AMS_ACCOUNT_REPAY_PLAN
 */
@Repository("ams.AccountRepayPlanDAO")
public class AccountRepayPlanDAO{

    @Autowired
    private AccountRepayPlanDOMapper accountRepayPlanDOMapper;

    /**
     * desc:插入表:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_ACCOUNT_REPAY_PLAN( ID ,BO_ID ,ORG_ID ,STATUS ,USER_ID ,CHANNEL ,CREATED_BY ,PERIOD_NUM ,PUNISH_FEE ,REPAY_DATE ,UPDATED_BY ,OVERDUE_DAY ,SERVICE_FEE ,CREATED_TIME ,REPAY_STATUS ,UPDATED_TIME ,INTEREST_ACCU ,RETURN_AMOUNT ,SERVICE_FEE_ID ,CAPITAL_AMOUNT ,PUNISH_FEE_ACCU ,REAL_REPAY_DATE ,INTEREST_AMOUNT ,PUNISH_FEE_OWNER ,SERVICE_FEE_ACCU ,TOTAL_CAPITAL_ACCU ,TOTAL_CAPITAL_LEFT ,PUNISH_UPDATED_TIME )VALUES( #{id,jdbcType=BIGINT} , #{boId,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{channel,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{periodNum,jdbcType=VARCHAR} , #{punishFee,jdbcType=DECIMAL} , #{repayDate,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{overdueDay,jdbcType=VARCHAR} , #{serviceFee,jdbcType=DECIMAL} , #{createdTime,jdbcType=TIMESTAMP} , #{repayStatus,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{interestAccu,jdbcType=DECIMAL} , #{returnAmount,jdbcType=DECIMAL} , #{serviceFeeId,jdbcType=VARCHAR} , #{capitalAmount,jdbcType=DECIMAL} , #{punishFeeAccu,jdbcType=DECIMAL} , #{realRepayDate,jdbcType=VARCHAR} , #{interestAmount,jdbcType=DECIMAL} , #{punishFeeOwner,jdbcType=VARCHAR} , #{serviceFeeAccu,jdbcType=DECIMAL} , #{totalCapitalAccu,jdbcType=DECIMAL} , #{totalCapitalLeft,jdbcType=DECIMAL} , #{punishUpdatedTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  UPDATE AMS_ACCOUNT_REPAY_PLAN SET BO_ID = #{boId,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,CHANNEL = #{channel,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,PERIOD_NUM = #{periodNum,jdbcType=VARCHAR} ,PUNISH_FEE = #{punishFee,jdbcType=DECIMAL} ,REPAY_DATE = #{repayDate,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,OVERDUE_DAY = #{overdueDay,jdbcType=VARCHAR} ,SERVICE_FEE = #{serviceFee,jdbcType=DECIMAL} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,REPAY_STATUS = #{repayStatus,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,INTEREST_ACCU = #{interestAccu,jdbcType=DECIMAL} ,RETURN_AMOUNT = #{returnAmount,jdbcType=DECIMAL} ,SERVICE_FEE_ID = #{serviceFeeId,jdbcType=VARCHAR} ,CAPITAL_AMOUNT = #{capitalAmount,jdbcType=DECIMAL} ,PUNISH_FEE_ACCU = #{punishFeeAccu,jdbcType=DECIMAL} ,REAL_REPAY_DATE = #{realRepayDate,jdbcType=VARCHAR} ,INTEREST_AMOUNT = #{interestAmount,jdbcType=DECIMAL} ,PUNISH_FEE_OWNER = #{punishFeeOwner,jdbcType=VARCHAR} ,SERVICE_FEE_ACCU = #{serviceFeeAccu,jdbcType=DECIMAL} ,TOTAL_CAPITAL_ACCU = #{totalCapitalAccu,jdbcType=DECIMAL} ,TOTAL_CAPITAL_LEFT = #{totalCapitalLeft,jdbcType=DECIMAL} ,PUNISH_UPDATED_TIME = #{punishUpdatedTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  DELETE FROM AMS_ACCOUNT_REPAY_PLAN WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return Long
     */
    public Long deleteByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepayPlanDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_ACCOUNT_REPAY_PLAN.<br/>
     * descSql =  SELECT * FROM AMS_ACCOUNT_REPAY_PLAN WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return AccountRepayPlanDO
     */
    public AccountRepayPlanDO getByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return accountRepayPlanDOMapper.getByPrimary(params);

    }
    /**
     * desc:通过userId 和boId查询还款计划.<br/>
     * descSql =  SELECT repay.ID,repay.BO_ID,repay.ORG_ID,repay.STATUS,repay.USER_ID,repay.CHANNEL,repay.CREATED_BY,repay.PERIOD_NUM,repay.PUNISH_FEE,repay.REPAY_DATE,repay.UPDATED_BY,repay.OVERDUE_DAY, repay.SERVICE_FEE,repay.CREATED_TIME,repay.REPAY_STATUS,repay.UPDATED_TIME,repay.INTEREST_ACCU,repay.RETURN_AMOUNT,repay.SERVICE_FEE_ID,repay.CAPITAL_AMOUNT,repay.PUNISH_FEE_ACCU,repay.REAL_REPAY_DATE,repay.INTEREST_AMOUNT,repay.PUNISH_FEE_OWNER,repay.SERVICE_FEE_ACCU, repay.TOTAL_CAPITAL_ACCU,repay.TOTAL_CAPITAL_LEFT,repay.PUNISH_UPDATED_TIME, sum(fee.fee_amount) as 'allServiceFee' FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR} limit #{pageNo,jdbcType=INTEGER},#{pageRec,jdbcType=INTEGER}

     * @return List<AccountRepayExDO>
     */
    public QueryRepayPlanPage queryRepayPlanById(QueryRepayPlanPage page){
        int total = accountRepayPlanDOMapper.queryRepayPlanCount(page);
        if (total>0){
            page.setDatas(accountRepayPlanDOMapper.queryRepayPlanById(page));
        }
        page.setTotal(total);
        return page;

    }
    /**
     * desc:.<br/>
     * descSql =  SELECT count(*) FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR}
     * @return Integer
     */
    public Integer queryRepayPlanCount(QueryRepayPlanPage page){
        Map<String,Object> params=new HashMap<String,Object>();
        return accountRepayPlanDOMapper.queryRepayPlanCount(page);

    }
    /**
     * desc:通过userId 和boId查询还款计划.<br/>
     * descSql =  SELECT repay.ID,repay.BO_ID,repay.ORG_ID,repay.STATUS,repay.USER_ID,repay.CHANNEL,repay.CREATED_BY,repay.PERIOD_NUM,repay.PUNISH_FEE,repay.REPAY_DATE,repay.UPDATED_BY,repay.OVERDUE_DAY, repay.SERVICE_FEE,repay.CREATED_TIME,repay.REPAY_STATUS,repay.UPDATED_TIME,repay.INTEREST_ACCU,repay.RETURN_AMOUNT,repay.SERVICE_FEE_ID,repay.CAPITAL_AMOUNT,repay.PUNISH_FEE_ACCU,repay.REAL_REPAY_DATE,repay.INTEREST_AMOUNT,repay.PUNISH_FEE_OWNER,repay.SERVICE_FEE_ACCU, repay.TOTAL_CAPITAL_ACCU,repay.TOTAL_CAPITAL_LEFT,repay.PUNISH_UPDATED_TIME, sum(fee.fee_amount) as 'allServiceFee' FROM AMS_ACCOUNT_REPAY_PLAN repay,AMS_ACCOUNT_REPAY_SERVICE_FEE fee WHERE repay.status=1 and repay.service_fee_id=fee.service_fee_id and repay.repay_status in #{repayStatus,jdbcType=VARCHAR} and fee.fee_type=#{feeType,jdbcType=VARCHAR} and repay.USER_ID = #{userId,jdbcType=VARCHAR} AND repay.BO_ID = #{boId,jdbcType=VARCHAR}
     * @param boId boId
     * @param userId userId
     * @param feeType feeType
     * @param repayStatus repayStatus
     * @return List<AccountRepayExDO>
     */
    public List<AccountRepayExDO> queryPreRepayTry(String boId,String userId,String feeType,List<String> repayStatus){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("boId",boId);
        params.put("userId",userId);
        params.put("feeType",feeType);
        params.put("repayStatus",repayStatus);
        return accountRepayPlanDOMapper.queryPreRepayTry(params);

    }

    public Long updateStatus(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.updateStatus(entity);
    }

    public Long updatePlanInfo(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.updatePlanInfo(entity);
    }

    public Long updatePlanFail(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.updatePlanFail(entity);
    }


    public AccountRepayExDO queryRepayStatus(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.queryRepayStatus(entity);
    }

    public List<AccountRepayExDO> queryRepayPlanByDate(AccountRepayPlanDO entity){
        return accountRepayPlanDOMapper.queryRepayPlanByDate(entity);
    }

    //查询还款扣款文件字段
    public List<TodayRepaymentDO> selectByAccountRepayPlanRepaymentDO(Map<String,Object> params){
        return accountRepayPlanDOMapper.selectByAccountRepayPlanRepaymentDO( params);
    }

    //查询当天还款文件字段
    public List<TodayRepaymentDO> selectByTodayRepaymentDO(Map<String,Object> params){
        return accountRepayPlanDOMapper.selectByTodayRepaymentDO( params);
    }

}

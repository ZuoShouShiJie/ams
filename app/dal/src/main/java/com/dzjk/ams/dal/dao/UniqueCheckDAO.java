package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.UniqueCheckDO;
import com.dzjk.ams.dal.mapper.UniqueCheckDOMapper;

import javax.annotation.Resource;

/**
* The Table AMS_UNIQUE_CHECK.
* AMS_UNIQUE_CHECK
*/
@Repository
public class UniqueCheckDAO{

    @Resource
    private UniqueCheckDOMapper uniqueCheckDOMapper;

    /**
     * desc:插入表:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_UNIQUE_CHECK( UNIQUEID ,CREATE_TIME ,MODIFY_TIME )VALUES( #{uniqueid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{modifyTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    public Long insert(UniqueCheckDO entity){
        return uniqueCheckDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_UNIQUE_CHECK.<br/>
     * descSql =  UPDATE AMS_UNIQUE_CHECK SET CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    public Long update(UniqueCheckDO entity){
        return uniqueCheckDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  DELETE FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return Long
     */
    public Long deleteByPrimary(String uniqueid){
        return uniqueCheckDOMapper.deleteByPrimary(uniqueid);

    }
    /**
     * desc:根据主键获取数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT * FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return UniqueCheckDO
     */
    public UniqueCheckDO getByPrimary(String uniqueid){
        return uniqueCheckDOMapper.getByPrimary(uniqueid);

    }
    /**
     * desc:根据主键获取数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT * FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return UniqueCheckDO
     */
    public UniqueCheckDO getByPrimaryByTest(String uniqueid){
        return uniqueCheckDOMapper.getByPrimaryByTest(uniqueid);

    }
}

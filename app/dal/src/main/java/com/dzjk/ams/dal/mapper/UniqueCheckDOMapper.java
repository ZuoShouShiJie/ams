package com.dzjk.ams.dal.mapper;

import com.dzjk.ams.dal.dataobject.UniqueCheckDO;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table AMS_UNIQUE_CHECK.
 * AMS_UNIQUE_CHECK
 */
public interface UniqueCheckDOMapper{

    /**
     * desc:插入表:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_UNIQUE_CHECK( UNIQUEID ,CREATE_TIME ,MODIFY_TIME )VALUES( #{uniqueid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{modifyTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return Long
     */
    Long insert(UniqueCheckDO entity);
    /**
     * desc:更新表:AMS_UNIQUE_CHECK.<br/>
     * descSql =  UPDATE AMS_UNIQUE_CHECK SET CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODIFY_TIME = #{modifyTime,jdbcType=TIMESTAMP} WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    Long update(UniqueCheckDO entity);
    /**
     * desc:根据主键删除数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  DELETE FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return Long
     */
    Long deleteByPrimary(String uniqueid);
    /**
     * desc:根据主键获取数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT * FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return UniqueCheckDO
     */
    UniqueCheckDO getByPrimary(String uniqueid);
    /**
     * desc:根据主键获取数据:AMS_UNIQUE_CHECK.<br/>
     * descSql =  SELECT * FROM AMS_UNIQUE_CHECK WHERE UNIQUEID = #{uniqueid,jdbcType=VARCHAR}
     * @param uniqueid uniqueid
     * @return UniqueCheckDO
     */
    UniqueCheckDO getByPrimaryByTest(String uniqueid);
}

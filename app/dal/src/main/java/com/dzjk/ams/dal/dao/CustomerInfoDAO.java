package com.dzjk.ams.dal.dao;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.dzjk.ams.dal.dataobject.CustomerInfoDO;
import com.dzjk.ams.dal.mapper.CustomerInfoDOMapper;

/**
* The Table AMS_CUSTOMER_INFO.
* AMS_CUSTOMER_INFO
*/
@Repository("ams.CustomerInfoDAO")
public class CustomerInfoDAO{

    @Autowired
    private CustomerInfoDOMapper customerInfoDOMapper;

    /**
     * desc:插入表:AMS_CUSTOMER_INFO.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO AMS_CUSTOMER_INFO( ID ,ID_NO ,EMAIL ,ORG_ID ,CARD_NO ,DEGREE ,GENDER ,ID_TYPE ,MOBILE ,STATUS ,USER_ID ,EMP_CITY ,EMP_NAME ,EMP_TYPE ,EMP_ZONE ,BANK_CODE ,EMP_PHONE ,EMP_TITLE ,USER_NAME ,CREATED_BY ,HOME_PHONE ,UPDATED_BY ,CON_ADDRESS ,CON_ZIPCODE ,EMP_ADDRESS ,CHILD_STATUS ,CONTACT_NAME ,CREATED_TIME ,EMP_PROVINCE ,HOME_ADDRESS ,ORG_AUTH_TYPE ,UPDATED_TIME ,YEARS_OF_WORK ,EMP_POSTITION ,EMP_STRUCTURE ,GRADUATE_INST ,GRADUATE_YEAR ,CONTACT_MOBILE ,MARITAL_STATUS ,QUALIFICATION ,HOUSE_CONDITION ,SOCAIL_IDENTITY ,CONTACT_RELATION )VALUES( #{id,jdbcType=BIGINT} , #{idNo,jdbcType=VARCHAR} , #{email,jdbcType=VARCHAR} , #{orgId,jdbcType=BIGINT} , #{cardNo,jdbcType=VARCHAR} , #{degree,jdbcType=VARCHAR} , #{gender,jdbcType=VARCHAR} , #{idType,jdbcType=VARCHAR} , #{mobile,jdbcType=VARCHAR} , #{status,jdbcType=VARCHAR} , #{userId,jdbcType=VARCHAR} , #{empCity,jdbcType=VARCHAR} , #{empName,jdbcType=VARCHAR} , #{empType,jdbcType=VARCHAR} , #{empZone,jdbcType=VARCHAR} , #{bankCode,jdbcType=VARCHAR} , #{empPhone,jdbcType=VARCHAR} , #{empTitle,jdbcType=VARCHAR} , #{userName,jdbcType=VARCHAR} , #{createdBy,jdbcType=VARCHAR} , #{homePhone,jdbcType=VARCHAR} , #{updatedBy,jdbcType=VARCHAR} , #{conAddress,jdbcType=VARCHAR} , #{conZipcode,jdbcType=VARCHAR} , #{empAddress,jdbcType=VARCHAR} , #{childStatus,jdbcType=VARCHAR} , #{contactName,jdbcType=VARCHAR} , #{createdTime,jdbcType=TIMESTAMP} , #{empProvince,jdbcType=VARCHAR} , #{homeAddress,jdbcType=VARCHAR} , #{orgAuthType,jdbcType=VARCHAR} , #{updatedTime,jdbcType=TIMESTAMP} , #{yearsOfWork,jdbcType=VARCHAR} , #{empPostition,jdbcType=VARCHAR} , #{empStructure,jdbcType=VARCHAR} , #{graduateInst,jdbcType=VARCHAR} , #{graduateYear,jdbcType=VARCHAR} , #{contactMobile,jdbcType=VARCHAR} , #{maritalStatus,jdbcType=VARCHAR} , #{qualification,jdbcType=VARCHAR} , #{houseCondition,jdbcType=VARCHAR} , #{socailIdentity,jdbcType=VARCHAR} , #{contactRelation,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(CustomerInfoDO entity){
        return customerInfoDOMapper.insert(entity);

    }
    /**
     * desc:更新表:AMS_CUSTOMER_INFO.<br/>
     * descSql =  UPDATE AMS_CUSTOMER_INFO SET ID_NO = #{idNo,jdbcType=VARCHAR} ,EMAIL = #{email,jdbcType=VARCHAR} ,CARD_NO = #{cardNo,jdbcType=VARCHAR} ,DEGREE = #{degree,jdbcType=VARCHAR} ,GENDER = #{gender,jdbcType=VARCHAR} ,ID_TYPE = #{idType,jdbcType=VARCHAR} ,MOBILE = #{mobile,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=VARCHAR} ,USER_ID = #{userId,jdbcType=VARCHAR} ,EMP_CITY = #{empCity,jdbcType=VARCHAR} ,EMP_NAME = #{empName,jdbcType=VARCHAR} ,EMP_TYPE = #{empType,jdbcType=VARCHAR} ,EMP_ZONE = #{empZone,jdbcType=VARCHAR} ,BANK_CODE = #{bankCode,jdbcType=VARCHAR} ,EMP_PHONE = #{empPhone,jdbcType=VARCHAR} ,EMP_TITLE = #{empTitle,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,CREATED_BY = #{createdBy,jdbcType=VARCHAR} ,HOME_PHONE = #{homePhone,jdbcType=VARCHAR} ,UPDATED_BY = #{updatedBy,jdbcType=VARCHAR} ,CON_ADDRESS = #{conAddress,jdbcType=VARCHAR} ,CON_ZIPCODE = #{conZipcode,jdbcType=VARCHAR} ,EMP_ADDRESS = #{empAddress,jdbcType=VARCHAR} ,CHILD_STATUS = #{childStatus,jdbcType=VARCHAR} ,CONTACT_NAME = #{contactName,jdbcType=VARCHAR} ,CREATED_TIME = #{createdTime,jdbcType=TIMESTAMP} ,EMP_PROVINCE = #{empProvince,jdbcType=VARCHAR} ,HOME_ADDRESS = #{homeAddress,jdbcType=VARCHAR} ,ORG_AUTH_TYPE = #{orgAuthType,jdbcType=VARCHAR} ,UPDATED_TIME = #{updatedTime,jdbcType=TIMESTAMP} ,YEARS_OF_WORK = #{yearsOfWork,jdbcType=VARCHAR} ,EMP_POSTITION = #{empPostition,jdbcType=VARCHAR} ,EMP_STRUCTURE = #{empStructure,jdbcType=VARCHAR} ,GRADUATE_INST = #{graduateInst,jdbcType=VARCHAR} ,GRADUATE_YEAR = #{graduateYear,jdbcType=VARCHAR} ,CONTACT_MOBILE = #{contactMobile,jdbcType=VARCHAR} ,MARITAL_STATUS = #{maritalStatus,jdbcType=VARCHAR} ,QUALIFICATION = #{qualification,jdbcType=VARCHAR} ,HOUSE_CONDITION = #{houseCondition,jdbcType=VARCHAR} ,SOCAIL_IDENTITY = #{socailIdentity,jdbcType=VARCHAR} ,CONTACT_RELATION = #{contactRelation,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param entity entity
     * @return Long
     */
    public Long update(CustomerInfoDO entity){
        return customerInfoDOMapper.update(entity);

    }
    /**
     * desc:根据主键删除数据:AMS_CUSTOMER_INFO.<br/>
     * descSql =  DELETE FROM AMS_CUSTOMER_INFO WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return Long
     */
    public Long deleteByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return customerInfoDOMapper.deleteByPrimary(params);

    }
    /**
     * desc:根据主键获取数据:AMS_CUSTOMER_INFO.<br/>
     * descSql =  SELECT * FROM AMS_CUSTOMER_INFO WHERE ID = #{id,jdbcType=BIGINT} AND ORG_ID = #{orgId,jdbcType=BIGINT}
     * @param id id
     * @param orgId orgId
     * @return CustomerInfoDO
     */
    public CustomerInfoDO getByPrimary(Long id,Long orgId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("id",id);
        params.put("orgId",orgId);
        return customerInfoDOMapper.getByPrimary(params);

    }
    /**
     * desc:获取AMS_CUSTOMER_INFO.<br/>
     * descSql =  SELECT * FROM AMS_CUSTOMER_INFO WHERE 1=1 AND USER_NAME = #{userName,jdbcType=VARCHAR} AND ID_TYPE = #{idType,jdbcType=VARCHAR} AND ID_NO = #{idNo,jdbcType=VARCHAR} AND ORG_ID = #{orgId,jdbcType=INTEGER} 
     * @param idNo idNo
     * @param idType idType
     * @param userName userName
     * @return CustomerInfoDO
     */
    public CustomerInfoDO queryCustomerInfo(String idNo,String idType,String userName){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("idNo",idNo);
        params.put("idType",idType);
        params.put("userName",userName);
        return customerInfoDOMapper.queryCustomerInfo(params);

    }
    /**
     * desc:.<br/>
     * descSql =  SELECT * FROM AMS_CUSTOMER_INFO WHERE 1=1 AND USER_ID = #{userId,jdbcType=VARCHAR} AND ORG_ID = #{orgId,jdbcType=INTEGER} 
     * @param userId userId
     * @return CustomerInfoDO
     */
    public CustomerInfoDO queryCustomerInfoByUserId(String userId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("userId",userId);
        return customerInfoDOMapper.queryCustomerInfoByUserId(params);

    }

    public CustomerInfoDO queryCustomerInfoByIdNo(String idNo,String idType){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("idNo",idNo);
        params.put("idType",idType);
        return customerInfoDOMapper.queryCustomerInfoByIdNo(params);

    }

    public Long updateUserInfo(CustomerInfoDO entity){
        return customerInfoDOMapper.updateUserInfo(entity);

    }
}

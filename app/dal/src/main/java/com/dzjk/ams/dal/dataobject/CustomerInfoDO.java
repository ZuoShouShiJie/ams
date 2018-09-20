package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table AMS_CUSTOMER_INFO
 */
public class CustomerInfoDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * idNo ID_NO.
     */
    private String idNo;
    /**
     * email EMAIL.
     */
    private String email;
    /**
     * orgId ORG_ID.
     */
    private Long orgId;
    /**
     * cardNo 第一次平台交易验证银行卡卡号.
     */
    private String cardNo;
    /**
     * degree 学位.
     */
    private String degree;
    /**
     * gender GENDER.
     */
    private String gender;
    /**
     * idType ID_TYPE.
     */
    private String idType;
    /**
     * mobile MOBILE.
     */
    private String mobile;
    /**
     * status 状态.
     */
    private String status;
    /**
     * userId 客户帐号.
     */
    private String userId;
    /**
     * empCity EMP_CITY.
     */
    private String empCity;
    /**
     * empName EMP_NAME.
     */
    private String empName;
    /**
     * empType 单位行业类别.
     */
    private String empType;
    /**
     * empZone 单位所在区.
     */
    private String empZone;
    /**
     * bankCode 第一次平台交易验证银行卡对应银行行号.
     */
    private String bankCode;
    /**
     * empPhone EMP_PHONE.
     */
    private String empPhone;
    /**
     * empTitle 当前职称.
     */
    private String empTitle;
    /**
     * userName 客户姓名.
     */
    private String userName;
    /**
     * createdBy 客户信息表.
     */
    private String createdBy;
    /**
     * homePhone HOME_PHONE.
     */
    private String homePhone;
    /**
     * updatedBy UPDATED_BY.
     */
    private String updatedBy;
    /**
     * conAddress 通讯地址.
     */
    private String conAddress;
    /**
     * conZipcode CON_ZIPCODE.
     */
    private String conZipcode;
    /**
     * empAddress EMP_ADDRESS.
     */
    private String empAddress;
    /**
     * childStatus 子女状况.
     */
    private String childStatus;
    /**
     * contactName 联系人姓名.
     */
    private String contactName;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * empProvince 社会身份.
     */
    private String empProvince;
    /**
     * homeAddress 住宅详细地址.
     */
    private String homeAddress;
    /**
     * orgAuthType 认证类型（证件类型。。。）.
     */
    private String orgAuthType;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * yearsOfWork YEARS_OF_WORK.
     */
    private String yearsOfWork;
    /**
     * empPostition EMP_POSTITION.
     */
    private String empPostition;
    /**
     * empStructure EMP_STRUCTURE.
     */
    private String empStructure;
    /**
     * graduateInst 毕业院校.
     */
    private String graduateInst;
    /**
     * graduateYear GRADUATE_YEAR.
     */
    private String graduateYear;
    /**
     * contactMobile 联系人姓名.
     */
    private String contactMobile;
    /**
     * maritalStatus 婚姻状况.
     */
    private String maritalStatus;
    /**
     * qualification 教育程度（最高学历）.
     */
    private String qualification;
    /**
     * houseCondition HOUSE_CONDITION.
     */
    private String houseCondition;
    /**
     * socailIdentity SOCAIL_IDENTITY.
     */
    private String socailIdentity;
    /**
     * contactRelation 联系人和客户关系.
     */
    private String contactRelation;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set idNo ID_NO.
     */
    public void setIdNo(String idNo){
        this.idNo = idNo;
    }

    /**
     * Get idNo ID_NO.
     *
     * @return the string
     */
    public String getIdNo(){
        return idNo;
    }

    /**
     * Set email EMAIL.
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Get email EMAIL.
     *
     * @return the string
     */
    public String getEmail(){
        return email;
    }

    /**
     * Set orgId ORG_ID.
     */
    public void setOrgId(Long orgId){
        this.orgId = orgId;
    }

    /**
     * Get orgId ORG_ID.
     *
     * @return the string
     */
    public Long getOrgId(){
        return orgId;
    }

    /**
     * Set cardNo 第一次平台交易验证银行卡卡号.
     */
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    }

    /**
     * Get cardNo 第一次平台交易验证银行卡卡号.
     *
     * @return the string
     */
    public String getCardNo(){
        return cardNo;
    }

    /**
     * Set degree 学位.
     */
    public void setDegree(String degree){
        this.degree = degree;
    }

    /**
     * Get degree 学位.
     *
     * @return the string
     */
    public String getDegree(){
        return degree;
    }

    /**
     * Set gender GENDER.
     */
    public void setGender(String gender){
        this.gender = gender;
    }

    /**
     * Get gender GENDER.
     *
     * @return the string
     */
    public String getGender(){
        return gender;
    }

    /**
     * Set idType ID_TYPE.
     */
    public void setIdType(String idType){
        this.idType = idType;
    }

    /**
     * Get idType ID_TYPE.
     *
     * @return the string
     */
    public String getIdType(){
        return idType;
    }

    /**
     * Set mobile MOBILE.
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
     * Get mobile MOBILE.
     *
     * @return the string
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * Set status 状态.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status 状态.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set userId 客户帐号.
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * Get userId 客户帐号.
     *
     * @return the string
     */
    public String getUserId(){
        return userId;
    }

    /**
     * Set empCity EMP_CITY.
     */
    public void setEmpCity(String empCity){
        this.empCity = empCity;
    }

    /**
     * Get empCity EMP_CITY.
     *
     * @return the string
     */
    public String getEmpCity(){
        return empCity;
    }

    /**
     * Set empName EMP_NAME.
     */
    public void setEmpName(String empName){
        this.empName = empName;
    }

    /**
     * Get empName EMP_NAME.
     *
     * @return the string
     */
    public String getEmpName(){
        return empName;
    }

    /**
     * Set empType 单位行业类别.
     */
    public void setEmpType(String empType){
        this.empType = empType;
    }

    /**
     * Get empType 单位行业类别.
     *
     * @return the string
     */
    public String getEmpType(){
        return empType;
    }

    /**
     * Set empZone 单位所在区.
     */
    public void setEmpZone(String empZone){
        this.empZone = empZone;
    }

    /**
     * Get empZone 单位所在区.
     *
     * @return the string
     */
    public String getEmpZone(){
        return empZone;
    }

    /**
     * Set bankCode 第一次平台交易验证银行卡对应银行行号.
     */
    public void setBankCode(String bankCode){
        this.bankCode = bankCode;
    }

    /**
     * Get bankCode 第一次平台交易验证银行卡对应银行行号.
     *
     * @return the string
     */
    public String getBankCode(){
        return bankCode;
    }

    /**
     * Set empPhone EMP_PHONE.
     */
    public void setEmpPhone(String empPhone){
        this.empPhone = empPhone;
    }

    /**
     * Get empPhone EMP_PHONE.
     *
     * @return the string
     */
    public String getEmpPhone(){
        return empPhone;
    }

    /**
     * Set empTitle 当前职称.
     */
    public void setEmpTitle(String empTitle){
        this.empTitle = empTitle;
    }

    /**
     * Get empTitle 当前职称.
     *
     * @return the string
     */
    public String getEmpTitle(){
        return empTitle;
    }

    /**
     * Set userName 客户姓名.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * Get userName 客户姓名.
     *
     * @return the string
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Set createdBy 客户信息表.
     */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    /**
     * Get createdBy 客户信息表.
     *
     * @return the string
     */
    public String getCreatedBy(){
        return createdBy;
    }

    /**
     * Set homePhone HOME_PHONE.
     */
    public void setHomePhone(String homePhone){
        this.homePhone = homePhone;
    }

    /**
     * Get homePhone HOME_PHONE.
     *
     * @return the string
     */
    public String getHomePhone(){
        return homePhone;
    }

    /**
     * Set updatedBy UPDATED_BY.
     */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }

    /**
     * Get updatedBy UPDATED_BY.
     *
     * @return the string
     */
    public String getUpdatedBy(){
        return updatedBy;
    }

    /**
     * Set conAddress 通讯地址.
     */
    public void setConAddress(String conAddress){
        this.conAddress = conAddress;
    }

    /**
     * Get conAddress 通讯地址.
     *
     * @return the string
     */
    public String getConAddress(){
        return conAddress;
    }

    /**
     * Set conZipcode CON_ZIPCODE.
     */
    public void setConZipcode(String conZipcode){
        this.conZipcode = conZipcode;
    }

    /**
     * Get conZipcode CON_ZIPCODE.
     *
     * @return the string
     */
    public String getConZipcode(){
        return conZipcode;
    }

    /**
     * Set empAddress EMP_ADDRESS.
     */
    public void setEmpAddress(String empAddress){
        this.empAddress = empAddress;
    }

    /**
     * Get empAddress EMP_ADDRESS.
     *
     * @return the string
     */
    public String getEmpAddress(){
        return empAddress;
    }

    /**
     * Set childStatus 子女状况.
     */
    public void setChildStatus(String childStatus){
        this.childStatus = childStatus;
    }

    /**
     * Get childStatus 子女状况.
     *
     * @return the string
     */
    public String getChildStatus(){
        return childStatus;
    }

    /**
     * Set contactName 联系人姓名.
     */
    public void setContactName(String contactName){
        this.contactName = contactName;
    }

    /**
     * Get contactName 联系人姓名.
     *
     * @return the string
     */
    public String getContactName(){
        return contactName;
    }

    /**
     * Set createdTime CREATED_TIME.
     */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }

    /**
     * Get createdTime CREATED_TIME.
     *
     * @return the string
     */
    public Date getCreatedTime(){
        return createdTime;
    }

    /**
     * Set empProvince 社会身份.
     */
    public void setEmpProvince(String empProvince){
        this.empProvince = empProvince;
    }

    /**
     * Get empProvince 社会身份.
     *
     * @return the string
     */
    public String getEmpProvince(){
        return empProvince;
    }

    /**
     * Set homeAddress 住宅详细地址.
     */
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }

    /**
     * Get homeAddress 住宅详细地址.
     *
     * @return the string
     */
    public String getHomeAddress(){
        return homeAddress;
    }

    /**
     * Set orgAuthType 认证类型（证件类型。。。）.
     */
    public void setOrgAuthType(String orgAuthType){
        this.orgAuthType = orgAuthType;
    }

    /**
     * Get orgAuthType 认证类型（证件类型。。。）.
     *
     * @return the string
     */
    public String getOrgAuthType(){
        return orgAuthType;
    }

    /**
     * Set updatedTime UPDATED_TIME.
     */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }

    /**
     * Get updatedTime UPDATED_TIME.
     *
     * @return the string
     */
    public Date getUpdatedTime(){
        return updatedTime;
    }

    /**
     * Set yearsOfWork YEARS_OF_WORK.
     */
    public void setYearsOfWork(String yearsOfWork){
        this.yearsOfWork = yearsOfWork;
    }

    /**
     * Get yearsOfWork YEARS_OF_WORK.
     *
     * @return the string
     */
    public String getYearsOfWork(){
        return yearsOfWork;
    }

    /**
     * Set empPostition EMP_POSTITION.
     */
    public void setEmpPostition(String empPostition){
        this.empPostition = empPostition;
    }

    /**
     * Get empPostition EMP_POSTITION.
     *
     * @return the string
     */
    public String getEmpPostition(){
        return empPostition;
    }

    /**
     * Set empStructure EMP_STRUCTURE.
     */
    public void setEmpStructure(String empStructure){
        this.empStructure = empStructure;
    }

    /**
     * Get empStructure EMP_STRUCTURE.
     *
     * @return the string
     */
    public String getEmpStructure(){
        return empStructure;
    }

    /**
     * Set graduateInst 毕业院校.
     */
    public void setGraduateInst(String graduateInst){
        this.graduateInst = graduateInst;
    }

    /**
     * Get graduateInst 毕业院校.
     *
     * @return the string
     */
    public String getGraduateInst(){
        return graduateInst;
    }

    /**
     * Set graduateYear GRADUATE_YEAR.
     */
    public void setGraduateYear(String graduateYear){
        this.graduateYear = graduateYear;
    }

    /**
     * Get graduateYear GRADUATE_YEAR.
     *
     * @return the string
     */
    public String getGraduateYear(){
        return graduateYear;
    }

    /**
     * Set contactMobile 联系人姓名.
     */
    public void setContactMobile(String contactMobile){
        this.contactMobile = contactMobile;
    }

    /**
     * Get contactMobile 联系人姓名.
     *
     * @return the string
     */
    public String getContactMobile(){
        return contactMobile;
    }

    /**
     * Set maritalStatus 婚姻状况.
     */
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    /**
     * Get maritalStatus 婚姻状况.
     *
     * @return the string
     */
    public String getMaritalStatus(){
        return maritalStatus;
    }

    /**
     * Set qualification 教育程度（最高学历）.
     */
    public void setQualification(String qualification){
        this.qualification = qualification;
    }

    /**
     * Get qualification 教育程度（最高学历）.
     *
     * @return the string
     */
    public String getQualification(){
        return qualification;
    }

    /**
     * Set houseCondition HOUSE_CONDITION.
     */
    public void setHouseCondition(String houseCondition){
        this.houseCondition = houseCondition;
    }

    /**
     * Get houseCondition HOUSE_CONDITION.
     *
     * @return the string
     */
    public String getHouseCondition(){
        return houseCondition;
    }

    /**
     * Set socailIdentity SOCAIL_IDENTITY.
     */
    public void setSocailIdentity(String socailIdentity){
        this.socailIdentity = socailIdentity;
    }

    /**
     * Get socailIdentity SOCAIL_IDENTITY.
     *
     * @return the string
     */
    public String getSocailIdentity(){
        return socailIdentity;
    }

    /**
     * Set contactRelation 联系人和客户关系.
     */
    public void setContactRelation(String contactRelation){
        this.contactRelation = contactRelation;
    }

    /**
     * Get contactRelation 联系人和客户关系.
     *
     * @return the string
     */
    public String getContactRelation(){
        return contactRelation;
    }
}

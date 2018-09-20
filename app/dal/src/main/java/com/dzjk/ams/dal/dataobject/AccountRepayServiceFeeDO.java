package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The table AMS_ACCOUNT_REPAY_SERVICE_FEE
 */
public class AccountRepayServiceFeeDO implements Serializable{

    /**
     * id ID.
     */
    private Long id;
    /**
     * orgId ORG_ID.
     */
    private Long orgId;
    /**
     * status STATUS.
     */
    private String status;
    /**
     * feeName FEE_NAME.
     */
    private String feeName;
    /**
     * feeType FEE_TYPE.
     */
    private String feeType;
    /**
     * createdBy CREATED_BY.
     */
    private String createdBy;
    /**
     * feeAmount FEE_AMOUNT.
     */
    private BigDecimal feeAmount;
    /**
     * updatedBy UPDATED_BY.
     */
    private String updatedBy;
    /**
     * createdTime CREATED_TIME.
     */
    private Date createdTime;
    /**
     * updatedTime UPDATED_TIME.
     */
    private Date updatedTime;
    /**
     * serviceFeeId SERVICE_FEE_ID.
     */
    private String serviceFeeId;

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
     * Set status STATUS.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status STATUS.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
    }

    /**
     * Set feeName FEE_NAME.
     */
    public void setFeeName(String feeName){
        this.feeName = feeName;
    }

    /**
     * Get feeName FEE_NAME.
     *
     * @return the string
     */
    public String getFeeName(){
        return feeName;
    }

    /**
     * Set feeType FEE_TYPE.
     */
    public void setFeeType(String feeType){
        this.feeType = feeType;
    }

    /**
     * Get feeType FEE_TYPE.
     *
     * @return the string
     */
    public String getFeeType(){
        return feeType;
    }

    /**
     * Set createdBy CREATED_BY.
     */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    /**
     * Get createdBy CREATED_BY.
     *
     * @return the string
     */
    public String getCreatedBy(){
        return createdBy;
    }

    /**
     * Set feeAmount FEE_AMOUNT.
     */
    public void setFeeAmount(BigDecimal feeAmount){
        this.feeAmount = feeAmount;
    }

    /**
     * Get feeAmount FEE_AMOUNT.
     *
     * @return the string
     */
    public BigDecimal getFeeAmount(){
        return feeAmount;
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
     * Set serviceFeeId SERVICE_FEE_ID.
     */
    public void setServiceFeeId(String serviceFeeId){
        this.serviceFeeId = serviceFeeId;
    }

    /**
     * Get serviceFeeId SERVICE_FEE_ID.
     *
     * @return the string
     */
    public String getServiceFeeId(){
        return serviceFeeId;
    }
}

package com.dzjk.ams.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * The table AMS_UNIQUE_CHECK
 */
public class UniqueCheckDO implements Serializable{

    /**
     * tradeNo 交易流水号.
     */
    private String tradeNo;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * modifiedTime MODIFIED_TIME.
     */
    private Date modifiedTime;

    /**
     * Set tradeNo 交易流水号.
     */
    public void setTradeNo(String tradeNo){
        this.tradeNo = tradeNo;
    }

    /**
     * Get tradeNo 交易流水号.
     *
     * @return the string
     */
    public String getTradeNo(){
        return tradeNo;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set modifiedTime MODIFIED_TIME.
     */
    public void setModifiedTime(Date modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    /**
     * Get modifiedTime MODIFIED_TIME.
     *
     * @return the string
     */
    public Date getModifiedTime(){
        return modifiedTime;
    }
}

package com.dzjk.ams.facade.model;

import java.util.Date;

/**
 * Created by daixiaohu on 2018/2/28.
 */
public class LoanDetailInfoVo extends BaseVo{
    private String userName;
    private String userId;
    private String idType;
    private String idNo;
    private String orgId;
    private String boId;
    private Integer pageNo;
    private Integer pageRec;
    private Integer pageCount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageRec() {
        return pageRec;
    }

    public void setPageRec(Integer pageRec) {
        this.pageRec = pageRec;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}

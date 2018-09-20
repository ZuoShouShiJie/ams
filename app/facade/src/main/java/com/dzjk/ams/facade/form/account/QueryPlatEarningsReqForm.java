package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public class QueryPlatEarningsReqForm extends BaseVo {
    private String boId;
    private String orgId;
    private String startDate;
    private String endDate;
    private String productCode;
    private String idNo;
    private String idType;
    private String userId;
    private Integer pageNo;
    private Integer pageRec;

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

}

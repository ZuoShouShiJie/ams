package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.PreRepayTryVo;

/**
 * Created by daixiaohu on 2018/3/12.
 */
public class PreRepayTryReqForm extends BaseVo {
    private String userName     ;
    private String idType       ;
    private String idNo         ;
    private String userId       ;
    private String orgId        ;
    private String boId         ;
    private String applyDate    ;
    private String applyTime    ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}

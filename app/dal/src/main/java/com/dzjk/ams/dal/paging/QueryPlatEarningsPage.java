package com.dzjk.ams.dal.paging;

import com.dzjk.ams.dal.dataobject.AccountEarningsDO;
import com.dzjk.ams.dal.dataobject.AccountEarningsExDO;
import com.dzjk.common.paging.BasePage;

import java.util.Date;

/**
 * Created by daixiaohu on 2018/3/29.
 */
public class QueryPlatEarningsPage extends BasePage<AccountEarningsExDO> {
    private String boId;
    private String userId;
    private Long orgId;
    private Date startDate;
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

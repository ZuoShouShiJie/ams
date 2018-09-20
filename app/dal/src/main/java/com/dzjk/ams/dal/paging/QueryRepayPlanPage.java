package com.dzjk.ams.dal.paging;

import com.dzjk.ams.dal.dataobject.AccountRepayExDO;
import com.dzjk.common.paging.BasePage;

/**
 * Created by daixiaohu on 2018/4/9.
 */
public class QueryRepayPlanPage extends BasePage<AccountRepayExDO> {
    private String boId;
    private String userId;
    private Long orgId;

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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}

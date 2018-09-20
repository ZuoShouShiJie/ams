package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.QueryPlatEarningsVo;

import java.util.List;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public class QueryPlatEarningsRespForm extends BaseVo {
private Integer pageNo;
private Integer pageRec;
private Integer pageCount;
private List<QueryPlatEarningsVo> queryPlatEarnings;

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

    public List<QueryPlatEarningsVo> getQueryPlatEarnings() {
        return queryPlatEarnings;
    }

    public void setQueryPlatEarnings(List<QueryPlatEarningsVo> queryPlatEarnings) {
        this.queryPlatEarnings = queryPlatEarnings;
    }
}

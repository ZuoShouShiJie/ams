package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.LoanDetailInfoVo;
import com.dzjk.ams.facade.model.QueryRepayPlanVo;

import java.util.List;

/**
 * Created by daixiaohu on 2018/2/27.
 */
public class QueryRepayPlanRespForm extends BaseVo {
    private LoanDetailInfoVo loanDetailInfo;
    private List<QueryRepayPlanVo> detailList;

    public LoanDetailInfoVo getLoanDetailInfo() {
        return loanDetailInfo;
    }

    public void setLoanDetailInfo(LoanDetailInfoVo loanDetailInfo) {
        this.loanDetailInfo = loanDetailInfo;
    }

    public List<QueryRepayPlanVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<QueryRepayPlanVo> detailList) {
        this.detailList = detailList;
    }
}

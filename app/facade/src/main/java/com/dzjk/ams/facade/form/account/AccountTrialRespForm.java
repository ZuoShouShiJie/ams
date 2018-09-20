package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.TrialDetailListVo;
import com.dzjk.ams.facade.model.TrialLoanDetailInfoVo;

import java.util.List;

/**
 * Created by daixiaohu on 2018/3/2.
 */
public class AccountTrialRespForm extends BaseVo {
    private TrialLoanDetailInfoVo loanDetailInfo;
    private List<TrialDetailListVo> detailList;

    public TrialLoanDetailInfoVo getLoanDetailInfo() {
        return loanDetailInfo;
    }

    public void setLoanDetailInfo(TrialLoanDetailInfoVo loanDetailInfo) {
        this.loanDetailInfo = loanDetailInfo;
    }

    public List<TrialDetailListVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TrialDetailListVo> detailList) {
        this.detailList = detailList;
    }
}

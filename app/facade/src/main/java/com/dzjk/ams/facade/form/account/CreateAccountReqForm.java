package com.dzjk.ams.facade.form.account;

import com.dzjk.ams.facade.model.BaseVo;
import com.dzjk.ams.facade.model.CreateCusBaseInfoVo;
import com.dzjk.ams.facade.model.CreateLoanDetailInfoVo;

/**
 * Created by daixiaohu on 2018/3/5.
 */
public class CreateAccountReqForm extends BaseVo {
    private String userId;
    private CreateCusBaseInfoVo cusBaseInfo;
    private CreateLoanDetailInfoVo loanDetailInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CreateCusBaseInfoVo getCusBaseInfo() {
        return cusBaseInfo;
    }

    public void setCusBaseInfo(CreateCusBaseInfoVo cusBaseInfo) {
        this.cusBaseInfo = cusBaseInfo;
    }

    public CreateLoanDetailInfoVo getLoanDetailInfo() {
        return loanDetailInfo;
    }

    public void setLoanDetailInfo(CreateLoanDetailInfoVo loanDetailInfo) {
        this.loanDetailInfo = loanDetailInfo;
    }
}

package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/6/4.
 */
public enum ServiceCode {
    AccountTrial("AccountTrial","借款前账务试算"),
    CreateAccount("CreateAccount","审贷建账"),
    QueryAccount("QueryAccount","账务查询"),
    QueryRepayPlan("QueryRepayPlan","还款计划查询"),
    QueryPlatEarnings("QueryPlatEarnings","撮合平台收益计划查询"),
    PrePrpayTry("PrePrpayTry","提前还款试算"),
    ManualRepay("ManualRepay","还款交易接口"),
    QueryAccountStatus("QueryAccountStatus","查询建账是否成功"),
    AccountUpdate("AccountUpdate","账务变更"),
    CapitalCostTrial("CapitalCostTrial","资金端成本试算查询"),
    ;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ServiceCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

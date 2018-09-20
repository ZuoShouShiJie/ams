package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public enum AccountRepayStatus {
    //当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）

    NORMAL("1","正常"),
    PREPART_REPAY("2","提前部分还款"),
    PREALL_REPAY("3","提前全部还款"),
    OVERDUE("4","逾期"),
    REPLACE_REPAYED("5","代偿结清"),
    PURSUE_REPAYED("6","追偿结清"),
    BAD_ACCOUNT("7","坏账")


    ;
    private String code;
    private String msg;

    AccountRepayStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

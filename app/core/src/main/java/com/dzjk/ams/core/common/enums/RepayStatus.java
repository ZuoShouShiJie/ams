package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public enum RepayStatus {
    //还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，7：提前总账务结清，6：坏账，9：代扣中)
    NORMAL("1","正常"),
    PART_REPAY_PAYED("2","提前部分还款"),
    ALL_PREREPAY_PAYED("3","提前全部还款"),
    OVERDUE("4","逾期"),
    REPLACEREPAY_PAYED("5","代偿结清"),
    CATCH_PAYED("6","追偿结清"),
    BAD_PAYED("7","坏账");

    private String code;
    private String msg;

    RepayStatus(String code, String msg) {
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

package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public enum PlanRepayStatus {
    //还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，7：提前总账务结清，6：坏账，9：代扣中)
UNDUE("0","未到期"),
    OVERDUE("1","已逾期"),
    NORMAL_REPAY_PAYED("2","正常还款结清"),
    PREREPAY_PAYED("3","提前还款结清"),
    OVERREPAY_PAYED("4","逾期还款结清"),
    REPLACEREPAY_PAYED("5","代偿还款结清"),
    PREALL_PAYED("7","提前总账务结清"),
    BAD_ACCOUNT("6","坏账"),
    WITHHOLDING("9","代扣中");


    private String code;
    private String msg;

    PlanRepayStatus(String code, String msg) {
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

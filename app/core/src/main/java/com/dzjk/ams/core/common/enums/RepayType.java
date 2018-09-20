package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/13.
 */
public enum RepayType {
    ALLPRE_REPAYED("1", "借款人全额提前还款账务结清"),
    PARTPRE_REPAYED("2", "借款人部分提前手动还款账务变更"),
    MERCH_ADJUST("3", "商户利率调整导致的账务调整"),
    DEBIT_UPDATE("4", "发生债转，合同或借据信息变更"),
    REPLACE_REPAYED("5", "发生代偿，追偿结清"),
    BAD_ACCOUNT("6", "商户确定的催收无果或其他原因等导致的坏账"),
    NORMAL("7", "正常代扣");
    private String code;
    private String msg;

    RepayType(String code, String msg) {
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

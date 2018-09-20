package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/18.
 */
public enum GenderEnum {
    ManGender("1","男"),
    WomanGender("2","女")
    ;
    private String code;
    private String msg;

    GenderEnum(String code, String msg) {
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

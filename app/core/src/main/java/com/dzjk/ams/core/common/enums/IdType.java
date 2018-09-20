package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/18.
 */
public enum IdType {
    ShengFen("1","身份证")
    ;
    private String code;
    private String msg;

    IdType(String code, String msg) {
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

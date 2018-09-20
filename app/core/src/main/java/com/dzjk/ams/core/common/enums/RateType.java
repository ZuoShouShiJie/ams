package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/14.
 */
public enum RateType {
    NormalRate("11001","正常利率"), //第一位1：正常，2：逾期；第二位1：利率，2：服务费
    PunishRate("21002","罚息利率"),
    TechnologyServiceRate("12003","技术服务费"),
    PlatServiceRate("12004","平台服务费"),
    PunishService("22005","逾期服务费");

    private String code;
    private String msg;

    RateType(String code, String msg) {
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

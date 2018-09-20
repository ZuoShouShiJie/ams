package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/8/23.
 */
public enum RepayModeEnum {
    ACPI("DEBX","等额本息"),
    AP("XXHB","等额本金"),
    APC("APC","等本等息")
    ;
    private String code;
    private String msg;


    public static RepayModeEnum parser(String code) {
        for (RepayModeEnum $switch : RepayModeEnum.values()) {
            try {
                if ($switch.code.equals(code)) {
                    return $switch;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }


    RepayModeEnum(String code, String msg) {
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

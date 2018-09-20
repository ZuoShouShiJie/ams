package com.dzjk.ams.core.common.enums;

/** @author climb.s
 * @date 2018/2/9 16:46 */
public enum Status {
    Valid("1","有效"),
    Invalid("0","失效");

    private String code;
    private String msg;
    Status(String code, String msg) {
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

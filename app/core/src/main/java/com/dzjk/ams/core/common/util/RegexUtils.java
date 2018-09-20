package com.dzjk.ams.core.common.util;

/**
 * Created by daixiaohu on 2018/3/28.
 */
public class RegexUtils {
    public static String digReg="^\\d+$";//纯数字
    public static String teleReg = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";//手机号
    public static  String idCard = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9]$)";//十八位,十五位身份证号
}

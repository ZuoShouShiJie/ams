package com.dzjk.ams.core.common.enums;

/**
 * Created by daixiaohu on 2018/3/5.
 */
public enum ResultEnum {
    UNKONW_ERROR("999999", "未知错误"),
    SUCCESS("000000", "成功"),
    ParamNull("000001", "参数为空"),
    ExistAccount("000003", "账务表已存在"),
    ParamError("000002", "参数错误"),
    Processing("000004", "处理中"),
    RepayAmountLess("000005", "还款金额不足"),
    CustomerNotExist("000006", "客户不存在"),
    ProductInfoIsNull("000007", "产品信息为空"),
    ProductInfoError("000008", "产品返回错误"),
    RepayDateLessApply("000009", "提前还款日应大于申请日期"),
    NoLegal("000010", "不合法"),
    OrgIdNoEqual("000011","不匹配"),
    ShouldBig("000012","应该大于"),
    NoExistAccount("000013","该客户没有相关账务"),
    UpdateAcctFail("000014","没有该账务"),
    CantRepeatUpdate("000015","已正常还款结清,不能重复扣款"),
    CantRepeatOverUpdate("000016","已逾期还款结清,不能重复扣款"),
    ReqMsgIsNull("000017", "主体信息为空！"),
    RepayMode("000018", "还款方式类型不存在！");
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
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

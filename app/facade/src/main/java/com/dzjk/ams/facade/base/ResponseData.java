package com.dzjk.ams.facade.base;

import java.io.Serializable;

/**
 * Created by daixiaohu on 2018/2/11.
 */
public class ResponseData<T>  implements Serializable{
    private String return_code;
    private String return_msg;
    private T data;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", data=" + data +
                '}';
    }
}

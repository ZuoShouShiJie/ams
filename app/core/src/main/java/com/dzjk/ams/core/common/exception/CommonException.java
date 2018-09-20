package com.dzjk.ams.core.common.exception;

import com.dzjk.ams.core.common.enums.ResultEnum;

/**
 * @author climb.s
 * @date 2018/2/6 09:24
 */
public class CommonException extends RuntimeException {

    /*** you shoudld define you errorCode here, this is only an example */
/*	private String errorCode = "CommonError";

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}*/

    private String code;

    public CommonException(ResultEnum resultEnum,String message) {
        super(message);
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
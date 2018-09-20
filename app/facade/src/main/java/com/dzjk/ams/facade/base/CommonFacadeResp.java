package com.dzjk.ams.facade.base;

/** @author climb.s
 * @date 2018/2/6 09:40 */
public abstract class CommonFacadeResp {

	// result**用于返回业务相关的信息
	private String resultCode;
	private String resultMsg;

	// error**用于返回系统错误信息
	private String errorCode;
	private String errrorMsg;

	/** @return the resultCode */
	public String getResultCode() {
		return resultCode;
	}

	/** @param resultCode the resultCode to set */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/** @return the resultMsg */
	public String getResultMsg() {
		return resultMsg;
	}

	/** @param resultMsg the resultMsg to set */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/** @return the errorCode */
	public String getErrorCode() {
		return errorCode;
	}

	/** @param errorCode the errorCode to set */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/** @return the errrorMsg */
	public String getErrrorMsg() {
		return errrorMsg;
	}

	/** @param errrorMsg the errrorMsg to set */
	public void setErrrorMsg(String errrorMsg) {
		this.errrorMsg = errrorMsg;
	}

}

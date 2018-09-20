package com.dzjk.ams.facade.base;

/** @author climb.s
 * @date 2018/2/6 09:40 */
public abstract class AbstractFacadeResp {
	/** the tag to representation the response is a success response or not */
	private boolean	success	= false;

	/** inner error info */
	private String	resultMsg;

	/** the requestId */
	private String	requestId;

	public AbstractFacadeResp(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}

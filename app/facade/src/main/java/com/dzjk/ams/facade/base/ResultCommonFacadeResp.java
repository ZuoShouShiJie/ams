package com.dzjk.ams.facade.base;

/** @author climb.s
 * @date 2018/2/6 09:41 */
public class ResultCommonFacadeResp<T> extends CommonFacadeResp {

	/** the data in the response */
	private T data;

	public ResultCommonFacadeResp() {
		super();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultCommonFacadeResp{" + "data=" + data + '}';
	}

}

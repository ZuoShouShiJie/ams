package com.dzjk.ams.endpoint.action;

import com.dzjk.ams.core.common.exception.CommonException;
import com.dzjk.ams.facade.api.SampleRestFacade;
import com.dzjk.ams.facade.base.RestSampleFacadeResp;
import com.dzjk.ams.facade.model.DemoUserModel;

import javax.ws.rs.PathParam;

/** @author climb.s
 * @date 2018/2/6 10:02 */
public class SampleRestFacadeRestImpl implements SampleRestFacade {

	@Override
	public RestSampleFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException {

		DemoUserModel demoUserModel = new DemoUserModel();
		demoUserModel.setRealName("Real " + userName);
		demoUserModel.setUserName(userName);

		RestSampleFacadeResp<DemoUserModel> result = new RestSampleFacadeResp<DemoUserModel>();
		result.setData(demoUserModel);
		result.setSuccess(true);
		return result;
	}

	@Override
	public RestSampleFacadeResp<Integer> addUserInfo(DemoUserModel user) {
		int id = 1;
		RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
		result.setData(id);
		result.setSuccess(true);
		return result;
	}

	@Override
	public RestSampleFacadeResp<Integer> deleteUser(String userName) {
		int deletedCount = 1;
		RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
		result.setData(deletedCount);
		result.setSuccess(true);
		return result;
	}

	@Override
	public RestSampleFacadeResp<Integer> updateUser(@PathParam("userName") String userName,
													DemoUserModel demoUserModel) {
		int updatedCount = 1;
		RestSampleFacadeResp<Integer> result = new RestSampleFacadeResp<Integer>();
		result.setData(updatedCount);
		result.setSuccess(true);
		return result;
	}
}

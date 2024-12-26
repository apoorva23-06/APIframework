package com.api.base;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	
	private static final String BASE_PATH ="/api/users/";
	
	public Response getProfileAPI(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "profile");
	}

}

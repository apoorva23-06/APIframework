package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileManagementResponse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test
	public void getProfileInfoTest() {
		
		AuthService authService= new AuthService();
		Response response = authService.loginAPI(new LoginRequest("uday1234","uday1234"));
//		JsonPath json = new JsonPath(response.asString());
//		System.out.println(json.getString("token"));
		//System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		Response profileResponse = userProfileManagementService.getProfileAPI(loginResponse.getToken());
		System.out.println(profileResponse.asPrettyString());
		UserProfileManagementResponse userProfileManagementResponse = profileResponse.as(UserProfileManagementResponse.class);
		System.out.println(userProfileManagementResponse.getUsername());
		
	}

}

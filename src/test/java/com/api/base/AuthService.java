package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	//Base Path will be common for all api under Auth service
	private static final String BASE_PATH ="/api/auth/";
	
	
	public Response loginAPI(LoginRequest loginRequest) {
		return postRequest(loginRequest, BASE_PATH+"login");
	}
	
	public Response signUpAPI(SignUpRequest signupRequest) {
		return postRequest(signupRequest, BASE_PATH+"signup");
	}
	
	public Response forgotPasswordAPI(String emailAddress) {
		
		//No need to create POJO class for single field
		HashMap<String,String> payload = new HashMap<String,String>();
		payload.put("email", emailAddress);
		return postRequest(payload, BASE_PATH+"forgot-password");
	}

}

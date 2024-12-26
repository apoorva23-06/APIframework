package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test
	public void signUpTest() {
		AuthService auth = new AuthService();
		
		//Builder design pattern
		SignUpRequest signupRequest = new SignUpRequest.Builder()
				.email("misha34@gmail.com")
				.firstName("misha11")
		.lastName("gupta")
		.password("misha12333")
		.mobileNumber("8864867334")
		.userName("misha23")
		.build();

//		SignUpRequest signupRequest = new SignUpRequest("uday1234", "uday1234", "uday@gmail.com",
//			"uday","gupta","8864867344"	);
	
		
		//Passing payload using POJO
		Response response  = auth.signUpAPI(signupRequest);
		System.out.print(response.asPrettyString());
//		LoginResponse loginResponse = response.as(LoginResponse.class);
//		System.out.println(loginResponse.getToken());
//		System.out.println(loginResponse.getEmail());
//		System.out.println(loginResponse.getRoles());
//		
//		Assert.assertTrue(loginResponse.getToken()!=null);
//		Assert.assertEquals(loginResponse.getId(), 3);
	}

}

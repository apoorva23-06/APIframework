package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPasswordTest() {
		AuthService auth = new AuthService();	
		Response response  = auth.forgotPasswordAPI("disha@gmail.com");
		System.out.print(response.asPrettyString());
	}

}

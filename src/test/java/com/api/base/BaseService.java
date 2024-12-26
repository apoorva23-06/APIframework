package com.api.base;

import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL= "http://64.227.160.186:8080";
	private RequestSpecification request;
	
	
	public BaseService() {
		request = RestAssured.given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		request.header("Authorization","Bearer "+token);
	}
	
	
	//Problem here is that loginRequest reference is passed making it specific only to login payload
	
//	public Response postRequest(LoginRequest loginRequest, String endpoint) {
//		return request.contentType(ContentType.JSON).body(loginRequest).post(endpoint);
//	}
	
	//Pass the reference of parent class
	protected Response postRequest(Object payload, String endpoint) {
		return request.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return request.get(endpoint);
	}
	
}

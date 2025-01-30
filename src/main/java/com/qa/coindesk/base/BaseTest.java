package com.qa.coindesk.base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class BaseTest {

	// Base URL
	protected static final String BASE_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

	// Method to perform GET request 
	public Response sendGetRequest()
	{ 
		return RestAssured.get(BASE_URL);
	}
}

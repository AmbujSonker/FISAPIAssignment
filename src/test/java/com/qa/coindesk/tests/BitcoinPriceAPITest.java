package com.qa.coindesk.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.coindesk.base.BaseTest;

import org.json.JSONObject;

public class BitcoinPriceAPITest extends BaseTest {

    @Test
    public void validateBitcoinPriceAPI() {
        // Step 1: Send GET request
        Response response = sendGetRequest();

        // Step 2: Validate Status Code
        Assert.assertEquals(response.getStatusCode(), 200, "API Response is successful");

        // Step 3: Convert response to JSON
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());

        // Step 4: Verify that response contains USD, GBP, and EUR
        Assert.assertTrue(jsonResponse.getJSONObject("bpi").has("USD"), "USD is present");
        Assert.assertTrue(jsonResponse.getJSONObject("bpi").has("GBP"), "GBP is present");
        Assert.assertTrue(jsonResponse.getJSONObject("bpi").has("EUR"), "EUR is present");

        // Step 5: Validate GBP description
        String gbpDescription = jsonResponse.getJSONObject("bpi").getJSONObject("GBP").getString("description");
        Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description is correct");
    }
}

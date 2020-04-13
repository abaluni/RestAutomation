import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	void RegistrationSuccessful()
	{
		//Specify Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		
		// Request Payload sending along with POST request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "clidrislit1");
		requestParams.put("LastName", "memsg");
		requestParams.put("UserName", "clidrislit1.memsg");
		requestParams.put("Password", "Test123#");
		requestParams.put("Email", "clidrislit.1@memsg.top");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		
		// Response Object
		Response response = httpRequest.request(Method.POST, "/register");
		
		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// Success Code Validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}

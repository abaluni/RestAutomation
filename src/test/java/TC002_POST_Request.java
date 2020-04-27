import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	

	@DataProvider (name="UserData")
	public Object getData() 
	{
		return new Object[][] 
				{
	//				{ "clidrislit4", "memsg", "clidrislit4.memsg", "Test123#", "clidrislit.4@memsg.top"},
	//				{ "clidrislit5", "memsg", "clidrislit5.memsg", "Test123#", "clidrislit.5@memsg.top"},
					{ "clidrislit", "memsg", "clidrislit6.memsg", "Test123#", "clidrislit.6@memsg.top"}
				};
	}
	
	
	@Test(dataProvider="UserData")
	void RegistrationSuccessful(String firstName, String lastName, String userName, String password, String email)
	{
		//Specify Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		
		// Request Payload sending along with POST request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", firstName);
		requestParams.put("LastName", lastName);
		requestParams.put("UserName", userName);
		requestParams.put("Password", password);
		requestParams.put("Email", email);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		
		// Response Object
		Response response = httpRequest.request(Method.POST, "/register");
		
		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Json path object
		JsonPath js = new JsonPath(responseBody);
		Assert.assertEquals("OPERATION_SUCCESS", js.getString("SuccessCode"));
		
		
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);

	}
}

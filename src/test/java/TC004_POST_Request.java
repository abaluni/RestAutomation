import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_POST_Request {
	
	@Test
	void placeOrderFotPet()
	{
		// Base URI
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		// Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		
		// Create Request Payload
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "0");
		requestParams.put("petId", "0");
		requestParams.put("quantity", "0");		
		requestParams.put("shipDate", "2020-04-11T18:46:54.901Z");
		requestParams.put("status", "placed");
		requestParams.put("complete", "true");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST, "/store/order");
		
		// Response Body in String
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		// Check for the response status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}

}

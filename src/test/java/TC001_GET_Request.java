import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void getWeatherDetails()
	{
		//Specify Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		// Print response in Console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// Status Line validation
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_REST_Get {
	@Test
	void getEmployeeDataTest() {
		
		// Base URL
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com/todos";
		
		// Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Create Response Object
		Response response = httpRequest.request(Method.GET, "/1");
		
		// Rest API response data in String format
		String responseData = response.getBody().asString();
		System.out.println(responseData);
		
		// Check for the Status Code
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(200, statusCode);
		
	}

}

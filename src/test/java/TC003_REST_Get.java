import org.testng.annotations.Test;

import core.RestDriver;
import core.RestRequestBuilder;
import core.RestRequestBuilder.RequestContentType;
import core.RestRequestBuilder.RequestMethodType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import requestexecutor.GetRequest;

public class TC003_REST_Get {
	@Test
	void getEmployeeDataTest() {

		// Specify Base URL
		String baseURI = "https://jsonplaceholder.typicode.com/todos";

		// Request Object
		RestDriver _restDriver = new RestDriver();
		GetRequest _request = new GetRequest();

		// Rest Request Builder
		RestRequestBuilder _restRequestBuilder = new RestRequestBuilder();
		_restRequestBuilder.setBaseURI(baseURI);
		_restRequestBuilder.setContentType(RequestContentType.JSON);
		_restRequestBuilder.setMethodType(RequestMethodType.GET);
		_restRequestBuilder.setBasePath("/1");

		_restDriver.createRequest(_restRequestBuilder);

		// API Response & response string
		_request.executeRequest(_restDriver);

		// Status Code Validation
		System.out.println("Status code is: " + _restDriver.getStatusCode());
		Assert.assertEquals(200, _restDriver.getStatusCode());

		// Status Line validation
		System.out.println("Status Line is: " + _restDriver.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", _restDriver.getStatusLine());
		
		// Check for title in response

	}

}

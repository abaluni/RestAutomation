import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.RestDriver;
import core.RestRequestBuilder;
import core.RestRequestBuilder.RequestContentType;
import core.RestRequestBuilder.RequestMethodType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestexecutor.GetRequest;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetailsTest()
	{
		//Specify Base URL
		String baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		
		// Request Object
		RestDriver _restDriver = new RestDriver();
		GetRequest _request = new GetRequest();
		
		// Rest Request Builder
		RestRequestBuilder _restRequestBuilder = new RestRequestBuilder();
		_restRequestBuilder.setBaseURI(baseURI);
		_restRequestBuilder.setContentType(RequestContentType.JSON);
		_restRequestBuilder.setMethodType(RequestMethodType.GET);
		_restRequestBuilder.setBasePath("/Delhi");
		_restDriver.createRequest(_restRequestBuilder);
		
		// API Response & response string
		_request.executeRequest(_restDriver);
		
		// Status Code Validation
		System.out.println("Status code is: " + _restDriver.getStatusCode());
		Assert.assertEquals(_restDriver.getStatusCode(), 200);
		
		// Status Line validation
		System.out.println("Status Line is: " + _restDriver.getStatusLine());
		Assert.assertEquals(_restDriver.getStatusLine(), "HTTP/1.1 200 OK");
	}
}

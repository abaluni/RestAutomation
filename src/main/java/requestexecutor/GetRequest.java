package requestexecutor;

import core.RestDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest implements ExecuteRequestInterface {
	/**
	 * Perform a Get Request
	 * 
	 * @param restDriverObj
	 *                     - RestDriver Object to get request specification and set APIResponse
	 */
	public void executeRequest(RestDriver restDriverObj) {
		// TODO Auto-generated method stub
		RequestSpecification httpRequest = RestAssured.given();		
		Response apiResponse = httpRequest.spec(restDriverObj.getRequestSpecification()).get();
		System.out.println("API Response is:" + apiResponse.asString());
		restDriverObj.setAPIResponse(apiResponse);
	}
	/**
	 * Perform a Get request to a path.Normally the path doesn't have to be fully-qualified 
	 * e.g. you don't need to specify the path as http://localhost:8080/path. In this case it's enough to use /path.
	 * 
	 * @param restDriverObj
	 *                      - RestDriver Object to get request specification and set APIResponse
	 * @param path
	 *                      -The path to send the request
	 * @param pathParams
	 *                     -The path parameters. E.g. if path is "/book/{hotelId}/{roomNumber}" you can do delete("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);                 
	 */
	public void executeRequest(RestDriver restDriverObj, String path, Object... pathParams) {
		RequestSpecification httpRequest = RestAssured.given();
		Response apiResponse = httpRequest.spec(restDriverObj.getRequestSpecification()).get(path,pathParams);
	    System.out.println("API Response is:" + apiResponse.asString());
	    restDriverObj.setAPIResponse(apiResponse);
	}


 }

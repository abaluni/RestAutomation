package core;

import static io.restassured.config.EncoderConfig.encoderConfig;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestDriver {



	/**
	 * Initialize Rest objects.
	 */
	RestRequestBuilder restRequestBuilder_object;
	RestResponseBuilder restResponseBuilder_object;
	RequestSpecBuilder requestSpecBuilder_object;
	RequestSpecification requestSpecification_object;
	ResponseSpecBuilder responseSpecBuilder_object;
	ResponseSpecification responseSpecification_object;
	Response apiResponse_object;

	/**
	 * Constructor for initializing the classes.
	 */
	public RestDriver() {
		restRequestBuilder_object = new RestRequestBuilder();
		requestSpecBuilder_object = new RequestSpecBuilder();

		restResponseBuilder_object = new RestResponseBuilder();
		responseSpecBuilder_object = new ResponseSpecBuilder();
	}

	/**
	 * Getter for RestRequestSpecifications Object.
	 *
	 * @return
	 */
	public RestRequestBuilder getRestRequestBuilder() {
		return this.restRequestBuilder_object;
	}

	/**
	 * Getter for RequestSpecification Object.
	 *
	 * @return - RequestSpecification Object.
	 */

	public RequestSpecification getRequestSpecification() {
		return this.requestSpecification_object;
	}

	/**
	 * Setter for API Response.
	 *
	 * @param response
	 *            - Response Object
	 */
	public void setAPIResponse(Response response) {
		this.apiResponse_object = response;
	}

	/**
	 * Getter for API Response.
	 *
	 * @return - Response Object.
	 */
	private Response getAPIResponse() {
		return this.apiResponse_object;
	}

	/**
	 * Getter for API Response As String.
	 *
	 * @return - API Response As String
	 * @throws Exception
	 */
	public String getAPIResponseAsString() throws Exception {
		if(this.apiResponse_object==null)
		{
			throw new Exception("NULL API response can not be converted to string");
		}
		return this.apiResponse_object.asString();
	}


	/**
	 * Getter for RestResponseSpecifications Object.
	 *
	 * @return - RestResponseSpecifications Object
	 */
	public RestResponseBuilder getRestResponseBuilder() {
		return this.restResponseBuilder_object;
	}

	/**
	 * Getter for ResponseSpecBuilder Object.
	 *
	 * @return - ResponseSpecBuilder Object
	 */
	public ResponseSpecBuilder getResponseSpecBuilder() {
		return this.responseSpecBuilder_object;
	}

	/**
	 * Method to Create Rest Request.
	 *
	 * @param restRequestSpecifications
	 *            - RestRequestSpecifications Object.
	 */
	public void createRequest (RestRequestBuilder restRequestSpecifications){
		// Setting Content Type for Rest Request.
		if (restRequestSpecifications.getContentType() != null) {
			requestSpecBuilder_object.setContentType(restRequestSpecifications.getContentType());
		}

		// Setting Headers for Rest Request.
		if (restRequestSpecifications.header!=null && restRequestSpecifications.header.isEmpty() == false) {

			for (String key : restRequestSpecifications.header.keySet()) {
				requestSpecBuilder_object.addHeader(key,restRequestSpecifications.header.get(key));
			}
		}

		// Setting Base URI for Rest Request.
		requestSpecBuilder_object.setBaseUri(restRequestSpecifications.getBaseURI());
		// Setting Base Path for Rest Request.
		if(restRequestSpecifications.getBasePath()!=null)
		{
			requestSpecBuilder_object.setBasePath(restRequestSpecifications.getBasePath());
		}

		// Setting Query Parameters for Rest Request.
		if (restRequestSpecifications.queryParameters!=null && restRequestSpecifications.queryParameters.isEmpty() == false) {
			for (String key : restRequestSpecifications.queryParameters.keySet()) {
				requestSpecBuilder_object.addQueryParam(key,restRequestSpecifications.queryParameters.get(key));
			}

		}


		// Setting Path Parameters for Rest Request.
		if (restRequestSpecifications.pathParameters!=null && restRequestSpecifications.pathParameters.isEmpty() == false) {
			for (String key : restRequestSpecifications.pathParameters.keySet()) {
				requestSpecBuilder_object.addPathParam(key,restRequestSpecifications.pathParameters.get(key));
			}
		}

		// Building Rest Request.
		this.requestSpecification_object = requestSpecBuilder_object.build();
	}

	/**
	 * Method to create Expected Response.
	 *
	 * @param restResponseSpecifications
	 *            - RestResponseSpecifications Object.
	 */
	public void createExpectedResponse(RestResponseBuilder restResponseSpecifications) {
		if (restResponseSpecifications.expectedStatusCode != 0) {
			responseSpecBuilder_object.expectStatusCode(restResponseSpecifications.getStatusCode());
		}

		if (restResponseSpecifications.expectedStatusLine != null) {
			responseSpecBuilder_object.expectStatusLine(restResponseSpecifications.getStatusLine());
		}
	}

	/**
	 * Method to Validate Expected Response.
	 *
	 */
	public void validateResponse() {
		responseSpecification_object = getResponseSpecBuilder().build();
		getAPIResponse().then().spec(responseSpecification_object);
	}
	/**
	 * Method to get status code (to be used after execution)
	 * @return returns int status code from the api response
	 */
	public int getStatusCode(){
		return apiResponse_object.getStatusCode();
	}
	
	
	/**
	 * Method to get status code (to be used after execution)
	 * @return returns int status code from the api response
	 */
	public String getStatusLine(){
		return apiResponse_object.getStatusLine();
	}

	/**
	 * Method to retrieve the API Response header
	 * @return A Map of Strings with Headers Names as Keys and Header Values as Values
	 */
	public Map<String, String> getResponseHeader()
	{
		Map<String,String> HeaderData = new HashMap<String,String>();
		for(Header header : apiResponse_object.headers())
		{
			HeaderData.put(header.getName().toString(),header.getValue().toString());
		}
		return HeaderData;
	}

}

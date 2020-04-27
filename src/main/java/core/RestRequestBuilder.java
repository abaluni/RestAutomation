package core;

import java.io.File;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class RestRequestBuilder {
	
	String baseURI;
	Method methodType;
	String basePath;
	ContentType contentType;
	Boolean urlEncoding;
	byte[] byteBody;
	RequestSpecification httpRequest;
	
	
	/** Enum for Request Type **/
	public enum RequestMethodType
	{
		POST, 
		PUT, 
		GET,
		PATCH,
		HEAD,
		DELETE,
		OPTIONS
	}	
	
	
	/** Enum for Content Type of Request */
	public enum RequestContentType
	{
		JSON,
		XML,
		TEXT,
		ANY,
		BINARY,
		HTML,
		URLENC
	}
	
	HashMap<String, String> header = new HashMap<String, String>();
	HashMap<String, String> queryParameters = new HashMap<String, String>();
	HashMap<String, String> pathParameters = new HashMap<String, String>();

	/**
	 * @param baseURI - Base URI for Request - Setter method.
	 */
	public void setBaseURI(String baseURI)
	{
		RestAssured.baseURI = baseURI;
	}

	/**
	 * @return - Base URI for Request - Getter method
	 */
	public String getBaseURI()
	{
		return RestAssured.baseURI;
	}
	
	/**
	 * Method to Set Method Type of Rest Request.
	 * @param requestMethodType
	 */
	public void setMethodType(RequestMethodType requestMethodType)
	{
		if(requestMethodType == RequestMethodType.GET)
		{
			this.methodType = methodType.GET;
		}

		else if(requestMethodType == RequestMethodType.POST)
		{
			this.methodType = methodType.POST;
		}

		else if(requestMethodType == RequestMethodType.PUT)
		{
			this.methodType = methodType.PUT;
		}
		
		else if(requestMethodType == RequestMethodType.PATCH)
		{
			this.methodType = methodType.PATCH;
		}

		else if(requestMethodType == RequestMethodType.HEAD)
		{
			this.methodType = methodType.HEAD;
		}

		else if(requestMethodType == RequestMethodType.DELETE)
		{
			this.methodType = methodType.DELETE;
		}

		else if(requestMethodType == RequestMethodType.OPTIONS)
		{
			this.methodType = methodType.OPTIONS;
		}
	}

	/**
	 * Getter for Method Type.
	 * @return - Method Object
	 */
	public Method getMethodType()
	{
		return methodType;
	}
	

	/**
	 * Function to Set Content Type of Rest Request.
	 * @param requestContentType
	 */
	public void setContentType(RequestContentType requestContentType)
	{
		if(requestContentType == RequestContentType.JSON)
		{
			this.contentType = contentType.JSON;
		}

		else if(requestContentType == RequestContentType.XML)
		{
			this.contentType = contentType.XML;
		}

		else if(requestContentType == RequestContentType.TEXT)
		{
			this.contentType = contentType.TEXT;
		}

		else if(requestContentType == RequestContentType.ANY)
		{
			this.contentType = contentType.ANY;
		}

		else if(requestContentType == RequestContentType.BINARY)
		{
			this.contentType = contentType.BINARY;
		}

		else if(requestContentType == RequestContentType.HTML)
		{
			this.contentType = contentType.HTML;
		}

		else if(requestContentType == RequestContentType.URLENC)
		{
			this.contentType = contentType.URLENC;
		}
	}

	/**
	 * Getter for Request Content Type.
	 * @return - ContentType Object
	 */
	public ContentType getContentType()
	{
		return contentType;
	}	
	
	
	/**
	 * Setter for Base Path for Request.
	 * @param basePath - Base Path
	 */
	public void setBasePath(String basePath)
	{
		this.basePath = basePath;
	}

	/**
	 * Getter for Base Path
	 * @return - Base Path
	 */
	public String getBasePath()
	{
		return this.basePath;
	}

	
	/**
	 * Method to set Header of Rest Request.
	 * @param key - Header Key.
	 * @param value - Header Value
	 */
	public void setHeader(String key, String value)
	{
		header.put(key, value);
	}

	public HashMap<String, String> getHeader() {
		return header;
	}
}



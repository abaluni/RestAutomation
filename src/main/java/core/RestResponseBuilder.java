package core;

/**
 * This class is used to store the expected status code and status line from the API Response
 */
public class RestResponseBuilder {

	int expectedStatusCode;
	String expectedStatusLine;

	public void setStatusCode(int statusCode)
	{
		this.expectedStatusCode = statusCode;
	}

	public int getStatusCode()
	{
		return this.expectedStatusCode;
	}

	public void setStatusLine(String statusLine)
	{
		this.expectedStatusLine = statusLine;
	}

	public String getStatusLine()
	{
		return this.expectedStatusLine;
	}

}
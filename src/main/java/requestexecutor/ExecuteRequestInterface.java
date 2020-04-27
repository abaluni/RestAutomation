package requestexecutor;

import core.RestDriver;

/**
 * Base Interface for All Types of Requests that can be executed from the API Framework
 */
public interface ExecuteRequestInterface {

	void executeRequest(RestDriver restDriveObj);
	void executeRequest(RestDriver restDriverObj,String path,Object... pathParams);
	
}

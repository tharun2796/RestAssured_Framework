package interviewQuestions;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ResponseHeaderValidation {

	@Test
	public void reaponseHeaderValidation() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expStatusLine = "HTTP/1.1 200 ";
		String expVary = "Access-Control-Request-Headers";
		String expContentType = "application/json";
		String expPragma = "no-cache";
		String expConnection = "keep-alive";

		Response resp = when().get("/projects/TY_PROJ_25157");

		String actStatusLine = resp.statusLine();
		System.out.println(actStatusLine);
		Assert.assertEquals(actStatusLine, expStatusLine);

		Headers header = resp.getHeaders();
		System.out.println(header);
		
	/*	
        String actVary = resp.getHeader("Vary");	
	    Assert.assertEquals(actVary, expVary);
	
	    String actContentType = resp.getHeader("Content-Type");	
	    Assert.assertEquals(actContentType, expContentType);
	
	    String actPragma = resp.getHeader("Pragma");	
	    Assert.assertEquals(actPragma, expPragma);
	    
	    String actConnection = resp.getHeader("Connection");	
	    Assert.assertEquals(actConnection, expConnection);
	*/
		
	}
	
}

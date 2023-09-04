package interviewQuestions;

import java.util.HashSet;
import java.util.Set;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class HowToKeepSensitiveDataOutOfTheLog {

	public void keepSensitive() {
		Set<String> headers = new HashSet<String>();
		headers.add("X-REGION");
		headers.add("content-type");
		given()
		.baseUri("http://rmgtestingserver:8084")
		.header("X-REGION","NAM")
		
		// To blacklist the headers
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
	
		// To blacklist multiple headers
		//
		.log().all();
		
		when()
	    .get("/employees")
		
	    .then()
	    .assertThat()
	    .log().all();
	    
		
	}
}

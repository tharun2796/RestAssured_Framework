package interviewQuestions;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class MultipleWaysToSendCookies {

	@Test
	public void firstWay() {
		// using cookie method 
              RestAssured.given()
              .cookie("sessionId","abc123")
              .cookie("authToken","xyz987")
              
              .get("/endpoint");
	}

    @Test
	public void secondWay() {
	
    	Map<String, String> cookiesMap = new HashMap<>();
    	cookiesMap.put("sessionId", "abc123");
    	cookiesMap.put("authToken", "xyz987");
    	
    	RestAssured.given()
    	           .cookies(cookiesMap)
    	           .get("/endpoint");
}

   @Test
   public void thirdWay() {
	   
	   RequestSpecification requestSpec = new RequestSpecBuilder()
			   .addCookie("sessionId","abc123")
			   .addCookie("authToken","xyz987")
			   .build();
	   
	   RestAssured.given()
	               .spec(requestSpec)
	               .get("/endpoint");
	
	
}
}

package parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParameter {
	
	@Test
	public void formParam() {
		
		baseURI ="http://rmgtestingserver";
		port = 8084;
		
		given()
		.formParam("createdBy", "Tharun")
		.formParam("projectName", "SMS")
		.formParam("status", "Created")
		.formParam("teamSize", 5)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}

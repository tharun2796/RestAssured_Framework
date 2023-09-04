package differentWaysToPostARequest_RMGYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.CreateProject;

public class CreateProjectUsingPojo {

	public int randomNumber() {
		Random r = new Random();
		int random = r.nextInt(2500);
	    return random;
	}
	
	int random = randomNumber();
	
	@Test
	public void createProjectUsingPojo() {
		baseURI = "http://rmgtestingserver";
        port=8084;
		
        // Create Object for Pojo Class
        CreateProject cp = new CreateProject("Tharun", "StudentManagementSystem"+random, "Created", 5);
        
		// Pre-requisites
		given()
		.body(cp)
		.contentType(ContentType.JSON)

		//Perform action
		.when()
		.post("/addProject")

		// Validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}

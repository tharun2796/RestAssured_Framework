package differentWaysToPostARequest_RMGYantra;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateProjectWithBDD {

	
	public int getRandomNumber() {
		Random ram = new Random();
		int random = ram.nextInt(2500);
		return random;
	}

	int random = getRandomNumber();

	@Test
	public void createProject() {
		baseURI = "http://rmgtestingserver";
        port=8084;
		
        // Create JSON Object
        JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "The Immortal Man");
		jObj.put("projectName", "SSM"+random);
		jObj.put("status","Created");
		jObj.put("teamSize", 3);

		// Pre-requisites
		given()
		.body(jObj)
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

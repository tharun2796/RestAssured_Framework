package differentWaysToPostARequest_RMGYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectWIthHashMap {

	public int getRandomNumber() {
		Random ram = new Random();
		int random = ram.nextInt(2500);
		return random;
	}

	int random = getRandomNumber();

	@Test
	public void createProjectUsingHashMap() {
		baseURI = "http://rmgtestingserver";
        port=8084;
		
        // Create JSON Object
        HashMap hm = new HashMap();
		hm.put("createdBy", "The Immortal Man");
		hm.put("projectName", "SSM"+random);
		hm.put("status","Created");
		hm.put("teamSize", 3);

		// Pre-requisites
		given()
		.body(hm)
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

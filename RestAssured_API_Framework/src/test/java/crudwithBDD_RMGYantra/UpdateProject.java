package crudwithBDD_RMGYantra;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UpdateProject {

	@Test
	public void updateProject() {

		baseURI = "http://rmgtestingserver";
		port=8084;
		
		// Create JSON Object
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "The Follower");
		jObj.put("projectName", "SMS123");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 5);

		//Pre-requisites
		given()
		.body(jObj)
		.contentType(ContentType.JSON)

		//Perfom action
		.when()
		.put("/projects/TY_PROJ_24424")

		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}
}

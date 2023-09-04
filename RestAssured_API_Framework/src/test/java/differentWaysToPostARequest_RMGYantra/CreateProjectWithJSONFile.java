package differentWaysToPostARequest_RMGYantra;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectWithJSONFile {

	@Test
	public void createProjectWithJSONFile() throws FileNotFoundException {
		baseURI = "http://rmgtestingserver";
		port=8084;

		// Create JSON File 
		File fil = new File("./src/test/resources/files/RMGApplication.json");

		// Pre-requisites
		given()
		.body(fil)
		.contentType(ContentType.JSON)

		//Perform action
		.when()
		.post("/addProject")

		// Vallidation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}

}

package differnentWaysToPostARequest_Reqres;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CreateUserWithJSONFile {

	@Test
	public void createUserJSONFile() {

		baseURI="https://reqres.in";

		// Create Object for JSON File
		File f = new File("./src/test/resources/files/ReqresJSONFile.json");

		//Pre-requisites
		given()
		.body(f)
		.contentType(ContentType.JSON)

		// Perform action
		.when()
		.post("/api/users")

		// Validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)	
		.log().all();
	}
}

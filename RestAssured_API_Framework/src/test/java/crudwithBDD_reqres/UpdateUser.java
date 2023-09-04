package crudwithBDD_reqres;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UpdateUser {

	@Test
	public void updateUser() {
		baseURI = "https://reqres.in";

		// Create JSON Object 
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Dilli");
		jObj.put("job", "Prisoner");

		// Pre-requisites
		given()
		.body(jObj)
		.contentType(ContentType.JSON)

		// perform action
		.when()
		.put("/api/users/2")

		// Validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}
}

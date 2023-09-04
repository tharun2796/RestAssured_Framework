package differnentWaysToPostARequest_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateUserWIthHashMap {

	@Test
	public void createUser() {
       
		baseURI = "https://reqres.in";

		// Create JSON Object
		HashMap hm = new HashMap();
		hm.put("name", "Raghavan");
		hm.put("job", "IPS Officer");

		//Pre requisites
		given()
		.body(hm)
		.contentType(ContentType.JSON)

		//Perform actions
		.when()
		.post("/api/users")

		//validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();	

	}

	
}

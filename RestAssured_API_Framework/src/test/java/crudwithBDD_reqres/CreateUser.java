package crudwithBDD_reqres;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;


public class CreateUser {

	@Test
	public void createUser() {

		baseURI = "https://reqres.in";

		// Create JSON Object
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Veera Raghavan");
		jObj.put("job", "Soldier");

		//Pre requisites
		given()
		.body(jObj)
		.contentType(ContentType.JSON)

		//Perform actions
		.when()
		.post("/api/users")

		//validation
		.then()
		.assertThat()
        .time(Matchers.lessThan(6000l),TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();	

	}

}

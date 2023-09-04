package differnentWaysToPostARequest_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import pojo.CreateUser;

public class CreateUserUsingPojo {


	@Test
	public void createUser() {

		baseURI = "https://reqres.in";

		// Create JSON Object
		CreateUser user = new CreateUser("Chandru", "Lawyer");

		//Pre requisites
		given()
		.body(user)
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

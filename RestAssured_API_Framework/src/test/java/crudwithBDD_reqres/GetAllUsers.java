package crudwithBDD_reqres;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllUsers {

	@Test
	public void getAllUsers() {
		baseURI = "https://reqres.in";

		//perform action
		when()
		.get("/api/users?page=2")

		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}

}


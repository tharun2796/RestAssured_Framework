package crudwithBDD_reqres;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingleUser {

	@Test
	public void getUser() {
		baseURI = "https://reqres.in";

		// perform action
		when()
		.get("/api/users/2")

		// validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}

}

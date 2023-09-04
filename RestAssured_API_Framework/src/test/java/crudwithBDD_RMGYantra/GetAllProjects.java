package crudwithBDD_RMGYantra;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
// TY_PROJ_24424
public class GetAllProjects {

	@Test
	public void getAllProjects() {

		baseURI = "http://rmgtestingserver";
		port=8084;
		
		//perform action
		when()
		.get("/projects")

		// Validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}

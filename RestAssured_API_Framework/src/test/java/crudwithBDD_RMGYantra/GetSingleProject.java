package crudwithBDD_RMGYantra;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleProject {

	@Test
	public void getProject() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		
		// Perform action
		when()
		.get("/projects/TY_PROJ_24424")

		// Validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}

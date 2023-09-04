package parameters;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class PathParameter {

	@Test
	public void pathParameter() {

		baseURI ="http://rmgtestingserver"; 
		port = 8084;
		
		given()
		.pathParam("pID","TY_PROJ_13164")
		
		.when()
		.get("/projects/{pID}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}

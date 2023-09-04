package authenticationStandards;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

public class BasicAuthDigest {

	public void loginUsingDigest() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		given()
		.auth().digest("rmgyantra", "rmgy@9999")

		.when()
		.get("/login")

		.then()
		.assertThat()
		.statusCode(202)
		.log().all();

	}
}

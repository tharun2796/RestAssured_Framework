package authenticationStandards;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {

	public int randomNum() {

		Random r = new Random();
		int ran = r.nextInt(2000);
		return ran;
	}

	int random = randomNum();

	@Test
	public void loginUsingBasicAuth() {

		baseURI = "https://api.github.com";

		// create JSONObject
		JSONObject jObj = new JSONObject();
		jObj.put("name", "RestAPIFramework"+random);
		jObj.put("description", "API Framework");
		jObj.put("private",false);

		// Pre-requisites
		given()
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)

		// perform action
		.when()
		.post("/user/repos")

		// validation
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.contentType(ContentType.JSON)
		.log().all();
	}
}

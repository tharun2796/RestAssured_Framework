package requestChaining;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateProjectForRMGYantra {

	public int randomNumber() {

		Random r = new Random();
		int ran = r.nextInt(3000);
		return ran;
	}

	int random = randomNumber();

	@Test
	public void createProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		// create object for JSONObject
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Jagdish");
		jObj.put("projectName", "Mission"+random);
		jObj.put("status", "Created");
		jObj.put("teamSize", 7);

		Response resp = given().body(jObj).contentType(ContentType.JSON)

	    .when().post("/addProject");

		String proID = resp.jsonPath().get("projectId");

		System.out.println(proID);
		resp.then().log().all();

		// getting the project from the previous response
		given().pathParam("pID", proID)

		.when().get("/projects/{pID}")
		.then().log().all();
	}
}

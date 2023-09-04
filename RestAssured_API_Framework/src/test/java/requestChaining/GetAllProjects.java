package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetAllProjects {

	@Test
	public void createUser() {
		
			baseURI = "https://reqres.in";

			// create object for JSONObject
			JSONObject jObj = new JSONObject();
			jObj.put("name", "Kathiresan");
			jObj.put("job", "Farmer");

			Response resp = given().body(jObj).contentType(ContentType.JSON)

		    .when().post("/api/users");

			String proID = resp.jsonPath().get("id");

			System.out.println(proID);
			resp.then().log().all();

			given().pathParam("pID", proID)

			.when().get("/api/users/{pID}")
			.then().log().all();

	}
}

package interviewQuestions;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;


public class ToCheckTheResponseBodyIsJsonObject {

	@Test
	public void checkJsonObject() throws JsonProcessingException, IOException {
		Response response = given()
				.pathParam("pId", "TY_PROJ_2345")

				.when()
				.get("http://rmgtestingserver:8084/projects/{pId}");

		// To capture the respopnse
		String responseBody = response.getBody().asString();

		ObjectMapper omap = new ObjectMapper();
		
		JsonNode jNode = omap.readTree(responseBody);
		//boolean a = jNode.isArray();
		//boolean b = jNode.isInt();
	    //boolean c = jNode.isNull();
		//boolean d = jNode.isObject();
		//boolean e = jNode.isArray();

       // To check the response is a JSONObject or not
		if (jNode.isObject()) {
			System.out.println("Response is a JSON Object");
		}
		else {
			System.out.println("Response is not a JSON Object");
		}
	}
}

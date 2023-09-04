package differentWaysToValidateResponse_Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseBodyValidation {

	
	@Test
	public void dynamicResponse() {
		baseURI="https://reqres.in";
		

		String expData = "george.edwards@reqres.in";

		Response response = given().get("/api/users?page=2");
		List<String> emailIDs = response.jsonPath().get("data.email");

		boolean flag = false;

		for (String eID : emailIDs) {

			if (eID.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}

		Assert.assertTrue(flag);
		System.out.println("Data is Verified");
	}
}

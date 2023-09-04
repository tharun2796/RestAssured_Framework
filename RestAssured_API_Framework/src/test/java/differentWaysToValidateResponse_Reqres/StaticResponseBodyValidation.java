package differentWaysToValidateResponse_Reqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticResponseBodyValidation {

	@Test
	public void staticResponse() {

		baseURI="https://reqres.in";

		String expData = "lindsay.ferguson@reqres.in";

		Response response = given().get("/api/users?page=2");
		String actData = response.jsonPath().get("data[1].email");

		Assert.assertEquals(expData, actData);
		System.out.println("Data is Verified");
	}

}

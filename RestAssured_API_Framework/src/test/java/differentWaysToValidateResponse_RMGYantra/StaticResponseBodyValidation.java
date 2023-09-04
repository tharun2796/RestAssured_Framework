package differentWaysToValidateResponse_RMGYantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseBodyValidation {

	@Test
	public void staticResponse() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		String expData = "TY_PROJ_12319";

		Response response = given().get("/projects");
		String actData = response.jsonPath().get("[1].projectId");

		Assert.assertEquals(expData, actData);
		System.out.println("Data is verified");
	}
}

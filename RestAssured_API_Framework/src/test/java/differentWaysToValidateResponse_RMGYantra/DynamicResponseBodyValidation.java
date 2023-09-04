package differentWaysToValidateResponse_RMGYantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseBodyValidation {

	@Test
	public void dynamicResponse() {

		baseURI="http://rmgtestingserver";
		port=8084;

		String expData = "TY_PROJ_12323";

		Response response = given().get("/projects");
		List<String> projIDs = response.jsonPath().get("projectId");

		boolean flag = false;

		for (String pID : projIDs) {

			if (pID.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}

		Assert.assertTrue(flag);
		System.out.println("Data is Verified");
	}
}

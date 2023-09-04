package crudwithoutBDD_RMGYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	@Test
	public void getProject() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_24344");
		System.out.println(response.asString());
	}
}

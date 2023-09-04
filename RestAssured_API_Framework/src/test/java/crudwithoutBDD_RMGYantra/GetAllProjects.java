package crudwithoutBDD_RMGYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {

	@Test
	public void getAllProjects() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		System.out.println(response.asString());
	}
}

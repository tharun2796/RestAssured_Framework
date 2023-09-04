package crudwithoutBDD_RMGYantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	public void deleteProject() {
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_24344");
		System.out.println(response.asString());
	}
}

package crudwithoutBDD_reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadSingleUser {

	@Test
	public void readUser() {
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.prettyPeek());
	}
}

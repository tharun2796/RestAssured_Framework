package crudwithoutBDD_reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadAllUsers {

	@Test
	public void readAllUsers() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	    System.out.println(response.asString());
	}
}

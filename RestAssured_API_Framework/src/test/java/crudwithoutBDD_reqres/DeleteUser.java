package crudwithoutBDD_reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteUser {

	@Test
	public void deleteUser() {
		Response response = RestAssured.delete("https://reqres.in/api/users/2");
		System.out.println(response.asString());

		Assert.assertEquals(204,response.getStatusCode());
		// e Assert.assertEquals("No Content", response.)
		// e Assert.assertEquals("content/Json", response.getContentType());
	}
}

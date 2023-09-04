package crudwithoutBDD_reqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUser {

	@Test
	public void updateUser() {
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Siva");
		jObj.put("job", "Finisher");

		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);

		Response response = req.patch("https://reqres.in/api/users/2");
		System.out.println(response.asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status code verified");
	}
}

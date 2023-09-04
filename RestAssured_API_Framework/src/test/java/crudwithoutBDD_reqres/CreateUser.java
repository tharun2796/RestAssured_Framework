package crudwithoutBDD_reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@Test
	public void createUser() {
		
		
		// create the pre-requisites
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Siva");
		jObj.put("job", "Trainer");

		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);

		// perform the action
		Response response = req.post("https://reqres.in/api/users");

		// printing the response
		//System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}
}

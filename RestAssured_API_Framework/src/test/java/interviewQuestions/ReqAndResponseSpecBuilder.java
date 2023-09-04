package interviewQuestions;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreateProject;

public class ReqAndResponseSpecBuilder {

	public int randomNum() {
		Random r =new Random();
		int ran = r.nextInt(3000);
		return ran;
	}

	int random = randomNum();

	@Test
	public void requestAndResponseSpecBuilder(){

		CreateProject cp = new CreateProject("Dhoni", "The Finisher"+random, "On-going", 11);

		RequestSpecification req = new RequestSpecBuilder()
		.setBaseUri("http://rmgtestingserver:8084")
		.setContentType(ContentType.JSON).build();

		ResponseSpecification resp = new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(201).build();

		given()
		.spec(req)
		.body(cp)

		.when()
		.post("/addProject")

		.then()
		.spec(resp)
		.log().all();

	}

}

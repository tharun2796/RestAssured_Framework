package crudwithoutBDD_RMGYantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Tharun");
		jObj.put("projectName", "ManagementSystem");
		jObj.put("status", "completed");
		jObj.put("teamSize", 3);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_24344");
	    System.out.println(response.asString());
	}
}

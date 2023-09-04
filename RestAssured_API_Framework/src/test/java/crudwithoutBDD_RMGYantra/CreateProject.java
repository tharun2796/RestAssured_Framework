package crudwithoutBDD_RMGYantra;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(3000);
		return random;
	}
	
	int randomNum = getRandomNumber();
	
	@Test
	public void createProject() {
		
	  JSONObject jObj = new JSONObject();
	  jObj.put("createdBy", "Tharun");
	  jObj.put("projectName", "Management"+randomNum);
	  jObj.put("status", "created");
	  jObj.put("teamSize", 3);
	  
	  RequestSpecification req = RestAssured.given();
	  req.body(jObj);
	  req.contentType(ContentType.JSON);
	  
	  Response response = req.post("http://rmgtestingserver:8084/addProject");
	  System.out.println(response.asString());
	  // System.out.println(response.getStatusLine());
      // System.out.println(response.getTime()); 
      System.out.println(response.contentType());
	}
}

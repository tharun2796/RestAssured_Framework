package endToEndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericutility.DataBaseUtility;
import genericutility.EndPointsLibrary;
import genericutility.IConstants;
import genericutility.JavaUtility;
import genericutility.RestAssuredLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import pojo.CreateProject;

public class EndToEndTesting {

	JavaUtility jLib = new JavaUtility();
	RestAssuredLibrary 	rLib = new RestAssuredLibrary();
	DataBaseUtility dLib = new DataBaseUtility();
	// TY_PROJ_25272
	@Test
	public void createProject() throws Throwable {
		int random = jLib.getRandomNumber();

		// create project pre-requisites
		CreateProject cp = new CreateProject("Tharun","TY_EMP_"+random,"Created", 5);

		// send the request
		baseURI = IConstants.URL;

		Response resp = given()
		                .body(cp)
				        .contentType(ContentType.JSON)

				        .when().post(EndPointsLibrary.createProject);

		// capture the ProjectID
		String expData = rLib.getJsonData(resp, "projectId");
		System.out.println(expData);

		// validate the ID in database
		String query = "select * from project";
		String actData =dLib.executequeryAndVerify(query, 1, expData);
		
		Assert.assertEquals(expData, actData);
		System.out.println("Testcase Pass");
		
		resp.then().log().all();
	}

}

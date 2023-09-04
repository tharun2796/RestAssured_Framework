package datadriventesting;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojo.CreateProject;

public class CreateProjectsUsingDataProvider {

	public int randomNum() {

		Random r = new Random();
		int ran = r.nextInt(2000);
		return ran;
	}

	int random = randomNum();

	@DataProvider(name="getData")
	public Object[][] data() {

		Object[][] obj = new Object[3][4];

		obj[0][0]="Tharun";
		obj[0][1]="SMS"+random;
		obj[0][2]="Created";
		obj[0][3]=3;

		obj[1][0]="Arun";
		obj[1][1]="HMS"+random;
		obj[1][2]="On-going";
		obj[1][3]=5;

		obj[2][0]="Varun";
		obj[2][1]="CRM"+random;
		obj[2][2]="Completed";
		obj[2][3]=7;

		return obj;
	}

	@Test(dataProvider = "getData")
	public void createMultipleProjects(String createdBy, String projectName, String status, int teamSize) {
		CreateProject cp = new CreateProject(createdBy,projectName,status,teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given()
		.body(cp)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(6000l),TimeUnit.MILLISECONDS)
		.log().all();

	}

}

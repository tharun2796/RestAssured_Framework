package crudwithBDD_RMGYantra;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {

	@Test
	public void deleteProject() {

		baseURI = "http://rmgtestingserver";
		port=8084;
		
		//Perform action
		when() 
		.delete("/projects/TY_PROJ_24433")

		//validation
		.then()
		.assertThat()
		.time(Matchers.lessThan(6000l), TimeUnit.MILLISECONDS)
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
	}
}

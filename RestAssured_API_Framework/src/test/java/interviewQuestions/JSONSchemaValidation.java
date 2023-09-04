package interviewQuestions;

import java.io.File;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.main.JsonValidator;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class JSONSchemaValidation {

	@Test
	public void schemaValidation() {
		File f = new File("./src/test/resources/files/JSON Schema.json");
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
	}
}

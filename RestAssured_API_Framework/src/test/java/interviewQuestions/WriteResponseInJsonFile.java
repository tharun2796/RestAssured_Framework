package interviewQuestions;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WriteResponseInJsonFile {

	@Test
	public void writeInFile() throws IOException {
		Response response = when()
				            .get("http://rmgtestingserver:8084/projects");

		//Extract response body as JSON string
		String responseAsString = response.getBody().asString();

		//converting into byte array before writing
		byte[] responseAsStringByte = responseAsString.getBytes();

		// create a target file
		File targetFileForString = new File("src/main/resources/targetFileForString.json");

		// writing into files
		Files.write(responseAsStringByte, targetFileForString);
	}

	// This one is mostly not preferred
	public void writeInFile2() throws IOException {
		Response response = when()
				            .get("http://rmgtestingserver:8084/projects");

		//Extract response body as JSON string
		InputStream responseAsInputStream = response.asInputStream();

		//converting into byte array before writing
		byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
		responseAsInputStream.read(responseAsInputStreamByte);

		// create a target file
		File targetFileForInputStream = new File("src/main/resources/targetFileForInputStream.json");

		// writing into files
		Files.write(responseAsInputStreamByte, targetFileForInputStream);
	}
	
	// This is the most preferred way
	public void writeInFile3() throws IOException {
		Response response = when()
				           .get("http://rmgtestingserver:8084/projects");

	
		//converting into byte array before writing
		byte[] responseAsByteArray = response.asByteArray();

		// create a target file
		File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");

		// writing into files
		Files.write(responseAsByteArray, targetFileForByteArray);
	}
	
	// which way is more optional, if you want to write into a file ?
	// If you notice that we get a response as String or InputStream
	// We just need to convert them to Byte array before writing into a file
    // We are directly getting Byte Array. Hence the third way is more preferred 
}

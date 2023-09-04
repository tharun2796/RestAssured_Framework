package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.EmployeeWithArray;

public class EmployeeWIthArrayDeserialization {

	@Test
	public void empArrayDeserial() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper omap = new ObjectMapper();

		EmployeeWithArray data = omap.readValue(new File("./src/test/resources/files/employeeArrayObject.json"), EmployeeWithArray.class);

		System.out.println(data.getName());
		System.out.println(data.getMailID());
		System.out.println(data.getMob()[0]);
		System.out.println(data.getMob()[1]);
		System.out.println(data.getAge());
	}
}

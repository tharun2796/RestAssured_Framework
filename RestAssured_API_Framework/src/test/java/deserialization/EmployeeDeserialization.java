package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.Employee;

public class EmployeeDeserialization {

	@Test
	public void empDeserial() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap = new ObjectMapper();

		Employee data = omap.readValue(new File("./src/test/resources/files/employee.json"), Employee.class); 

		System.out.println(data.getName());
		System.out.println(data.getMailID());
		System.out.println(data.getMobNo());
		System.out.println(data.getAge());
	}
}

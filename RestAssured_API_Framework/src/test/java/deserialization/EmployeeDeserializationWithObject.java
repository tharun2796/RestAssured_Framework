package deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.EmployeeWithObject;

public class EmployeeDeserializationWithObject {

	@Test
	public void empObjectDeserial() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper omap = new ObjectMapper();

		EmployeeWithObject data = omap.readValue( new File("./src/test/resources/files/empWithObject.json"), EmployeeWithObject.class);

		System.out.println("Employee Name : "+data.getName());
		System.out.println("Employee ID : "+data.getId());
		System.out.println("Employee Primary Mob No : "+data.getMob()[0]);
		System.out.println("Employee Primary Mob No : "+data.getMob()[1]);
		System.out.println("Employee Spouse Name : "+data.getSpouse().getName());
		System.out.println("Employee Spouse age : "+data.getSpouse().getAge());
		System.out.println("Employee Spouse Mob No : "+data.getSpouse().getMob());
	}
}

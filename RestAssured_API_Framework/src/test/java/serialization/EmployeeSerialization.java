package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.Employee;

public class EmployeeSerialization {

	@Test
	public void empSerial() throws JsonGenerationException, JsonMappingException, IOException {
		
		Employee emp = new Employee("Tharun", "tharunmsd27@gmail.com", 9865080244l, 27);

		ObjectMapper omap = new ObjectMapper();
		
	    omap.writerWithDefaultPrettyPrinter().writeValue(new File("./src/test/resources/files/employee.json"),emp);
	}
}

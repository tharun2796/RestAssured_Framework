package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.EmployeeWithArray;

public class EmployeeWithArraySerialization {

	@Test
	public void empArraySerial() throws JsonParseException,JsonMappingException,IOException {

		long[] mob = {9865080244l,8667039257l};

		EmployeeWithArray emp = new EmployeeWithArray("Tharun Kumar M", "tharunmsd27@gmail.com", mob, 27); 

		ObjectMapper omap = new ObjectMapper();

		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./src/test/resources/files/employeeArrayObject.json"), emp);

	}
}

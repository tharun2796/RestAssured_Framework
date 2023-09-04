package serialization;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.EmployeeSpouse;
import pojo.EmployeeWithObject;

public class EmployeeSerializationWithObject {

	public int random() {
		Random r = new Random();
		int ran =r.nextInt(3000);
		return ran;
	}

	int random = random();

	@Test
	public void empWithObjectSerial() throws JsonParseException, JsonMappingException, IOException {

		long[] mob = {9171831319l,7231982428l};

		EmployeeSpouse sp = new EmployeeSpouse("Nisha", 24, 9786354212l);

		EmployeeWithObject emp = new EmployeeWithObject("Karthi", "TY_EMP_"+random, mob,sp);

		ObjectMapper omap = new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./src/test/resources/files/empWithObject.json"), emp);
	}
}

package MustKnownConceptsforAPIAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class ReadJsonDocument {
	
	
	public static void readJsonEveryTime() throws IOException {
		File file=new File("./JsonDocument.json");
		
		List<Object> path=JsonPath.read(file, "$..type");
		
		for(Object property:path) {
			System.out.println(property);
		}
	}
	
	public static void readJsonOneTime() throws IOException {
		InputStream file=new FileInputStream("./JsonDocument.json");
		Object path=Configuration
		.defaultConfiguration()
		.jsonProvider()
		.parse(file.readAllBytes());
		List<Object> property=JsonPath.read(path, "$..type");
		for (Object properties:property) {
			System.out.println(properties);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		readJsonEveryTime();
		readJsonOneTime();

	}

}

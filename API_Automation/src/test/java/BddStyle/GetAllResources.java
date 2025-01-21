package BddStyle;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class GetAllResources {
	
	String baseURI="https://jsonplaceholder.typicode.com/";
	
//	did not use a word "rest assured" at starting as imported static rest assured package
	
	@Test
	public void getAllResources() {
		
		given()
			.baseUri(baseURI)
		.when()
			.get("posts")
		.asPrettyString();
	}
	
	@Test
	public void createResource() {
		
		given()
			.baseUri(baseURI)
			.contentType(ContentType.JSON)
			.body("{\r\n"
						+" \"title\": \"api\",\r\n"
						+" \"body\": \"specification\",\r\n"
						+" \"userId\": 11\r\n"
						+"}")
		.when()
			.post("posts")
		.asPrettyString();
	}
	
	@Test
	public void updateResource() {
		
		given()
			.baseUri(baseURI)
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+" \"title\": \"title is updated\",\r\n"
					+" \"body\": \"body is updated\",\r\n"
					+" \"userId\": 1,\r\n"
					+" \"id\": 4\r\n"
					+"}")
		.when()
			.put("posts/4")
		.asPrettyString();
	}
	
	@Test
	public void deleteResource() {
		
		given()
			.baseUri(baseURI)
		.when()
			.delete("posts/1")
		.asPrettyString();
		
	}
	
	@Test
	public void createResourceFromExternalFile() {
		
		File file=new File("CreateResource.json");
		
		given()
		.baseUri(baseURI)
		.contentType(ContentType.JSON)
		.body(file)
		.when()
			.post("posts")
		.asPrettyString();
	}

}

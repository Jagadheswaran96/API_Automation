package NonBddStyle;

import org.apache.commons.lang3.CharSet;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Resources {
	
//	https://jsonplaceholder.typicode.com/
//	https://jsonplaceholder.typicode.com/guide/

	@Test
	public void getAllResources() {

		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

		RequestSpecification requestSpecification=RestAssured.given();

		Response response=requestSpecification.request(Method.GET,"posts");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());
	}

	@Test
	public void createResource() {

		RestAssured.baseURI="http://localhost:3000/";

		RequestSpecification requestSpecification=
				RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "\"username\": \"Jagadhes\",\r\n"
						+ "\"email\": \"jagadhes@yahoo.com\",\r\n"
						+ "\"password\": \"jagadhes\",\r\n"
						+ "\"confirm-password\": \"jagadhes\"\r\n"
						+ "}");

		Response response= requestSpecification.request(Method.POST,"register");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());

	}
	
	@Test
	public void updateResource() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		RequestSpecification requestSpecification= RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+" \"title\": \"title is updated\",\r\n"
						+" \"body\": \"body is updated\",\r\n"
						+" \"userId\": 1,\r\n"
						+" \"id\": 4\r\n"
						+"}");
		
		Response response= requestSpecification.request(Method.PUT,"posts/4");
		
		System.out.println(response.asPrettyString());
		
		System.out.println(response.getStatusLine());
	}
	
	@Test
	public void deleteResource() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		RequestSpecification requestSpecification= RestAssured.given();
		
		Response response= requestSpecification.request(Method.DELETE,"posts/1");
		
		System.out.println(response.asPrettyString());
		
		System.out.println(response.getStatusLine());
	}
	
	@Test
	public void filterResource() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		RequestSpecification requestSpecification= RestAssured.given();
		
		Response response= requestSpecification.request(Method.GET,"posts?userId=1");
		
		System.out.println(response.asPrettyString());
		
		System.out.println(response.getStatusLine());
	}
	
	@Test
	public void filterNestedResource() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		RequestSpecification requestSpecification= RestAssured.given();
		
		Response response= requestSpecification.request(Method.GET,"posts/1/comments");
		
		System.out.println(response.asPrettyString());
		
		System.out.println(response.getStatusLine());
	}
}

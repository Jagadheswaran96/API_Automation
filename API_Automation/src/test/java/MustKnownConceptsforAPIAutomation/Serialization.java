package MustKnownConceptsforAPIAutomation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Serialization {
	
//	serialization is required process of translating a data structure or object state 
//	into a format that can be stored or transmitted and then reconstructed later
	
	@Test
	public void jsonData() {
	
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("username", "Jagadhes");
		map.put("email", "jagadhes@yahoo.com");
		map.put("password", "jagadhes");
		map.put("confirm-password", "jagadhes");
		
//		Use below code incase if need to add list into Json
//		List<String> list=new ArrayList<>();
//		list.add("name");
//		list.add("age");
//		map.put("bio", list);
		
		System.out.println(map);
		
//		did not use a word "rest assured" at starting as imported static rest assured package
		given()
			.baseUri("http://localhost:3000/")
			.contentType(ContentType.JSON)
			//.header("content-type", "application/json")
			.body(map)
			.log()
			.all()
		.when()
			.post("register")
		.then()
			.log()
			.all();
	}

}

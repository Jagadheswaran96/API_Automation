package Pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUser {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		Users users=new Users();
		users.setUsername("Jagadhes");
		users.setEmail("jagadhes@yahoo.com");
		users.setPassword("jagadhes");
		
		System.out.println(users.getUsername());
		System.out.println(users.getEmail());
		System.out.println(users.getPassword());
		
		ObjectMapper mapper=new ObjectMapper();
		String createUserJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
		System.out.println(createUserJson);
	}
}

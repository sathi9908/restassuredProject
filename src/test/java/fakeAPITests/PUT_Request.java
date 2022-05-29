package fakeAPITests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class PUT_Request {
	
	public static HashMap map=new HashMap();
	@BeforeClass
	public void putData()
	{
		map.put("name","David");
		map.put("location","Germany");
		map.put("phone","8555950360");
		
		String courseArr[]= {"JavaScript","Python"};
		map.put("courses",courseArr);
			
	}
	
	
	@Test
	public void putUser()
	{
		given()
			.contentType("application/json")
			.body(map)
			
		
		.when()
			.put("http://localhost:3000/users/4")
		
		.then()
			.statusCode(200)
			.body("name",equalTo("David"))
			.body("location",equalTo("Germany"))
			.body("courses[0]",equalTo("JavaScript"))
			.body("courses[1]",equalTo("Python"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().body();
		
	}

}

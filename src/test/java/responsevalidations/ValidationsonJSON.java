package responsevalidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ValidationsonJSON {
	
	@Test(priority=1)

	public void sampleRequest()
	{
		/*given()
		
		.when()
			.get("http://localhost:3000/users")
			
		.then()
			.statusCode(200);*/
		given().when().get("http://localhost:3000/users").then().statusCode(200).log().all();
			
	}
	
	@Test(priority=2)
	public void checkJSONdata()
	{
		given()
		
		.when()
			.get("http://localhost:3000/users")
		.then()
			.statusCode(200)
			.body("[1].name",equalTo("Kim"))//single content
			.body("[0].courses",hasItem("Java"))
			.body("[0].courses",hasItems("Java","Selenium")) //multiple contents/values
			.log().body();
			
	}
	@Test(priority=3)
	public void passingParameters()
	{
		given()
		.param("myheader","Indian")  // for passing header info
		.pathParam("myparam","users")// for passing path params
		
		.when()
			.get("http://localhost:3000/{myparam}")// passing path parameter
		.then()
			.statusCode(200);
			
	}
	
}

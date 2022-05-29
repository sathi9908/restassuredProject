package fakeAPITests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DELETE_Request {
	
	
	@Test
	public void deleteUser()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/users/4")
			
		.then()
			.statusCode(200)
			.log().all();
		
	}

}

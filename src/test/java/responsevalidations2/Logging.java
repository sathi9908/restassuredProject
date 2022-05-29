package responsevalidations2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Logging {
	

	@Test
	void testLogging1()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			//.log().all();
			//.log().body();
			//.log().headers();
			//.log().cookies();
			//.log().ifError();
			//.statusCode(201)
		
			//.log().ifValidationFails();
		
			.log().ifStatusCodeIsEqualTo(200);
		
	}

}

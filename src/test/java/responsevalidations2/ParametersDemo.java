package responsevalidations2;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ParametersDemo {
	

	@Test
	void testParams()
	{
		//.get("https://reqres.in/api/users?page=2&id=5")
		given()
			.pathParam("mypath","users")// declare path parameter
			.queryParam("page",2)
			.queryParam("id",5)
		.when()
		.get("https://reqres.in/api/{mypath}")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}

package responsevalidations2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AuthenticationTypes {
	

	//@Test
	void testBasicAuthentication()
	{
		given()
		
		//.auth().basic("ToolsQA", "TestPassword") // Basic Authentication
		//.auth().preemptive().basic("ToolsQA", "TestPassword") // Preemtive authentication
		.auth().digest("ToolsQA", "TestPassword")
		
		.when()
		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
		
		.then()
		.statusCode(200)
		.body("FaultId",equalTo("OPERATION_SUCCESS"))
		.body("Fault", equalTo("Operation completed successfully"))
		.log().body();
			
	}
	

	@Test
	void testBearTokenAuthentication() throws IOException
	{
		String bearToken="E4F284BFADA11D01A52508ED7B92FFD7EE0905659F5DED06A4B73FC7739B48A287648801";
		String bodymsg=generateStringFromResource(".\\resources\\PostData.txt");
		given()
		.headers("Authorization","Bearer " +bearToken)
		.contentType("text/xml")
		.body(bodymsg)
		.when()
		.post("https://certtransaction.elementexpress.com")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}
	public static String generateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));

}
}

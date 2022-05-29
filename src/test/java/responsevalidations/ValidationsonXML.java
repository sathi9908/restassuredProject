package responsevalidations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ValidationsonXML 
{

	@Test(priority=1)

	public void sampleRequest()
	{
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body("CUSTOMER.ID",equalTo("15"))// Single content
			.log().all();
		
	}
	

	@Test(priority=2)

	public void testMultipleContents()
	{
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
			.body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY",equalTo("Seattle"))
			.log().all();
		
	}
	@Test(priority=3)

	public void testMultipleContentsinSingleShot()
	{
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"))
			.log().all();
		
	}
	
	@Test(priority=4)

	public void testUsingXPath()
	{
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.statusCode(200)
			.body(hasXPath("/CUSTOMER/FIRSTNAME"),containsString("Bill"));// Here we used XPath to get value from xml 
			
	}
	
	@Test(priority=5)

	public void testUsingXPath2()
	{
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.statusCode(200)
			.body(hasXPath("/INVOICEList/INVOICE[text()='10']"))// Here we used XPath to check text value presence
			.log().all();
	}
	
	
}

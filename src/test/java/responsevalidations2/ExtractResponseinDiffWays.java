package responsevalidations2;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ExtractResponseinDiffWays {
	
	//@Test(priority=1)
	public void testExtractDetails1()
	{
		//appraoch1
		/*String href=
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos/1")
		.then()
		.statusCode(200)
		.log().all()
		.extract().path("url");*/
		
		String url=given().when().get("http://jsonplaceholder.typicode.com/photos/1").then().statusCode(200).extract().path("url");
		System.out.println(url);
		
	}
	//@Test(priority=2)
	public void testExtractDetails2()
	{
		//appraoch2
		String link1=get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		System.out.println(link1);
		
		//appraoch3
		String link2=get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println(link2);
			
		
	}
	
	@Test(priority=3)
	public void testResponse()    // Here we stored response in to a single variable of type Response
	{
		Response res=
		when()
			.get("http://jsonplaceholder.typicode.com/photos/1")
		.then()

		.extract().response();
		
		System.out.println("response code is.....>"+res.statusCode());
		System.out.println("content type is....>"+res.contentType());
		System.out.println("title is.....>"+res.path("title"));
	}

}

package responsevalidations2;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Headers 
{
	@Test
	public void gogolePlaceAPI()
	{
		Response res=
		given()
		
		.when()
			.get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&key=AIzaSyC9iduUgjxlMMmNveMDN4190L0oL_7xBGM")
		
		.then()
		
		.extract().response();
		
		//Single header info
		String header_contenttype=res.getHeader("Content-Type");
		System.out.println("Content-Type header value is------->"+header_contenttype);
		
		//get all headers info
		io.restassured.http.Headers headers=res.getHeaders();
		
		for(Header h:headers)
		{
			System.out.println(h.getName()+".....>"+h.getValue());
			
		}
		
		
		
		
		
	}

}

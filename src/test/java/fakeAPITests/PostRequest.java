package fakeAPITests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PostRequest 
{
	@Test
	public void createBooking()
	{
		 HashMap<String,Object>data=new HashMap<String,Object>();
		data.put("firstname","sathi");
		data.put("lasttname","gajjala");
		data.put("totalprice","15000");
		data.put("depositpaid","true");
		data.put("additionalneeds","dinner");
		
		HashMap<String,Object> dates=new HashMap<String,Object>();
		dates.put("checkin","2018-01-01");
		dates.put("checkout","2019-01-01");
		
		data.put("bookingdates",dates);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
		
		.log().body();
		
			
		
	}

}

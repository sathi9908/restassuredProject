import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.booking.Booking;
import com.api.booking.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingAPITest 
{
	@Test
	public void bookingAPI()
	{
		String jsonbody=null;
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification request =RestAssured.given().log().all();
		request.contentType("application/json");
		BookingDates bd = new BookingDates("2018-01-01", "2019-01-01");
		Booking booking = new Booking("satheesh","gb", 25000, true,"dinner", bd);
		
		
		//pojo to json conversion
		ObjectMapper obj = new ObjectMapper();
		try {
			jsonbody = obj.writeValueAsString(booking);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonbody);
		request.body(jsonbody);
		Response response=request.post("/booking");
		System.out.println(response.prettyPrint());
		    JsonPath js = response.jsonPath();
		    System.out.println(js.get("booking.firstname"));
		    Assert.assertEquals(js.get("booking.firstname"),booking.getFirstname());
		      int bookingid=js.get("bookingid");
		      System.out.println("booking id is:"+bookingid);
		      Assert.assertNotNull(bookingid);
		     String checkindate= js.get("booking.bookingdates.checkin");
		     System.out.println("checkin date is:"+checkindate);
		     Assert.assertEquals(checkindate,booking.getBookingdates().getCheckin());
		
		
		
		
		
	}
	
	

}

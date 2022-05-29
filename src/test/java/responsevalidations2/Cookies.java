package responsevalidations2;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class Cookies {

	//@Test(priority=1)
	public void testCookies()
	{
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos")
			
		.then()
			.cookie("__cfduid","d1f301db7cc05154922db1fbe4d58cd7d1590713786");//should fail
		
	}
	//@Test(priority=2)
	public void testCookies2()
	{
		Response resp=
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos");
		
		//Get single/specific cookie from response
		
		//String cookie_value=resp.getCookie("__cfduid");
		//System.out.println("Value of the cookie is:"+cookie_value);
		//Get all cookies from response
		
		Map<String, String> cookie_values=resp.getCookies();
			
		for(String i:cookie_values.keySet())
		{

			System.out.println(i+"        "+cookie_values.get(i));
		}
		
	}
	@Test(priority=3)
	public void testDetailedCookieses3()
	{
		Response resp=
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/photos");
		
		Cookie cookie_info=resp.getDetailedCookie("__cfduid");
		
		System.out.println(cookie_info.hasExpiryDate());// expiry date of cokkie
		System.out.println(cookie_info.getExpiryDate());// get expiry date of cookie 
		
		System.out.println(cookie_info.hasValue());  
		System.out.println(cookie_info.getValue());
		
		System.out.println(cookie_info.hasDomain());
		System.out.println(cookie_info.getDomain());
		
		System.out.println(cookie_info.hasPath());
		System.out.println(cookie_info.getPath());
		
		
	}
		
}

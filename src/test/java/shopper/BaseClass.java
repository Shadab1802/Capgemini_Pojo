package shopper;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;

public class BaseClass {
	protected static String shopperId;
	protected static String jwtToken;
	protected static String baseURL = "https://www.shoppersstack.com/shopping";
	@BeforeClass
	
	public void login() {
		HashMap<String,Object> map =  new HashMap<String,Object>();
		
		map.put("email", "bredmi250@gmail.com");
		map.put("password", "Shadab@123");
		map.put("role", "SHOPPER");
		
		Response res = given()
		.contentType("application/json")
		.relaxedHTTPSValidation()
		.body(map)
		
		.when()
		.post("https://www.shoppersstack.com/shopping/users/login");
		
//		res.then().log().all();
		//res.then().assertThat().statusCode(200);
		shopperId = res.jsonPath().getString("data.userId");
		jwtToken = res.jsonPath().getString("data.jwtToken");
		System.out.println("Logged in");
	}
}

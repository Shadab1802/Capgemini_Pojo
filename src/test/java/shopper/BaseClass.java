package shopper;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;

import datadriverntesting.readData.ReadDataFromPropertiesFile;
import io.restassured.response.Response;

public class BaseClass extends ReadDataFromPropertiesFile{
	protected static String shopperId;
	protected static String jwtToken;
	protected static String baseURL = url;
	@BeforeClass
	
	public void login() {
		HashMap<String,Object> map =  new HashMap<String,Object>();
		
		map.put("email", email);
		map.put("password", password);
		map.put("role", role);
		
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

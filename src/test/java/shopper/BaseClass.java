package shopper;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;

import datadriverntesting.readData.ReadDataFromPropertiesFile;
import io.restassured.response.Response;

public class BaseClass extends ReadDataFromPropertiesFile{
	protected static String shopperId;
	protected static String jwtToken;
//	protected static String baseURL = url;
	@BeforeClass
	
	public void login() {
//		System.out.println(baseURL);
		HashMap<String,Object> map =  new HashMap<String,Object>();
		System.out.println(email);
		System.out.println(password);
		map.put("email", email);
		map.put("password", password);
		map.put("role", role);
		
		Response res = given()
		.contentType("application/json")
		.relaxedHTTPSValidation()
		.body(map)
		.when()
		.post("/users/login");
		
//		res.then().log().all();
		//res.then().assertThat().statusCode(200);
//		System.out.println(res.asPrettyString());
		shopperId = res.jsonPath().getString("data.userId");
		jwtToken = res.jsonPath().getString("data.jwtToken");
		if(!jwtToken.isBlank())System.out.println("Logged in");
	}
}

package shopper.Cart;

import static io.restassured.RestAssured.given;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import shopper.BaseClass;
import shopper.Cart.Pojo.AddProductToCartPojo;
import shopper.Cart.Pojo.UpdateProductToCartPojo;

public class Cart extends BaseClass {
	protected List<Integer> productIds;
	private String  itemId;
	private int id = 12;
	
	@Test
	public void fetchAllProducts() {
			Response res = given()
			.auth().oauth2(jwtToken)
			.relaxedHTTPSValidation()
			.contentType("application/json")
			
			.baseUri(baseURL)
			.when()
			.get("/products/alpha");
			
			res.then().assertThat().statusCode(200);			
			productIds = res.jsonPath().get("data.productId");
			System.out.println(productIds.get(id));
	}
	
	@Test(dependsOnMethods = "fetchAllProducts")
	public void AddProductToCart() {
		AddProductToCartPojo product = new AddProductToCartPojo(productIds.get(id).toString(),"5");
		
		Response res = 
				given()
				.auth().oauth2(jwtToken)
				.relaxedHTTPSValidation()
				.contentType("application/json")
				.body(product)
				.pathParam("shopperId", shopperId)
				.baseUri(baseURL)
				.when()
				.post("/shoppers/{shopperId}/carts");
//		System.out.println(res.prettyPrint());
		itemId = res.jsonPath().get("data.itemId").toString();
		
		res.then().assertThat().statusCode(201);
	}
	
	@Test(dependsOnMethods = "AddProductToCart")
	public void UpdateProductInCart() {
		UpdateProductToCartPojo product = new UpdateProductToCartPojo(productIds.get(id).toString(), "60");
		
		Response res = 
				given()
				.auth().oauth2(jwtToken)
				.relaxedHTTPSValidation()
				.contentType("application/json")
				.body(product)
				.pathParam("shopperId", shopperId)
				.pathParam("itemId", itemId)
				.baseUri(baseURL)
				.when()
				.put("/shoppers/{shopperId}/carts/{itemId}");
		
		res.then().assertThat().statusCode(200);
	}
	
	@Test(dependsOnMethods = "UpdateProductInCart")
	public void deleteProductFromCart() {
		Response res = 
				given()
				.auth().oauth2(jwtToken)
				.relaxedHTTPSValidation()
				.pathParams("shopperId",shopperId)
				.pathParam("productId", productIds.get(id))
				.baseUri(baseURL)
				.when()
				.delete("/shoppers/{shopperId}/carts/{productId}");
		
		res.then().assertThat().statusCode(200);
	}
	
}

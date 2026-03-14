package shopper.Cart.Pojo;

public class AddProductToCartPojo {
	private String productId;
	private String quantity;
	
	public AddProductToCartPojo(String productId, String quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}

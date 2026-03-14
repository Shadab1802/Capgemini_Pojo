package shopper.Cart.Pojo;

public class UpdateProductToCartPojo {
	private String productId;
	private String quantity;
	private String itemId;
	
	
	public UpdateProductToCartPojo(String productId, String quantity) {
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


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
}

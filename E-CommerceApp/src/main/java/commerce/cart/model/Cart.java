package commerce.cart.model;

public class Cart extends Product {
	private int quantity;

	public Cart() {

	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

}

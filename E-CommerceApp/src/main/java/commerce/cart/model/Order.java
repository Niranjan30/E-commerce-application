package commerce.cart.model;

public class Order extends Product {
	private int orderId;
	private int userId;
	private int quantity;
	private String date;

	public Order() {

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", quantity=" + quantity + ", date=" + date + "]";
	}

	public Order(int orderId, int userId, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.quantity = quantity;
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

package chapter6.extractvariable;

public class Order {
	private int quantity;
	private int itemPrice;

	public int getQuantity() {
		return quantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public double calculatePrice() {
		return getBasePrice() - getQuantityDiscount() + getShipping(getBasePrice());
	}

	private double getShipping(int basePrice) {
		return Math.min(basePrice * 0.1, 100);
	}

	private double getQuantityDiscount() {
		return Math.max(0, quantity - 500) * itemPrice * 0.05;
	}

	private int getBasePrice() {
		return quantity * itemPrice;
	}
}
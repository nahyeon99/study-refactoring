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
		final int basePrice = quantity * itemPrice;
		final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
		double shipping = Math.min(basePrice * 0.1, 100);
		return basePrice - quantityDiscount + shipping;
	}
}
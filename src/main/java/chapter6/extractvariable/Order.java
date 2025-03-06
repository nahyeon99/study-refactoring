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
		// 가격 = 기본 가격 - 수량 할인 + 배송비
		int basePrice = quantity * itemPrice;
		return basePrice -
			Math.max(0, quantity - 500) * itemPrice * 0.05 +
			Math.min(quantity * itemPrice * 0.1, 100);
	}
}
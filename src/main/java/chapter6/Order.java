package chapter6;

import java.util.List;

public record Order(
	int amount
) {
	public static List<Order> of(List<Integer> amounts) {
		return amounts.stream()
			.map(Order::new)
			.toList();
	}
}

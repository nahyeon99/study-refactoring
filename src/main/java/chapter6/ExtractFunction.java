package chapter6;

import java.time.LocalDate;
import java.util.List;

public class ExtractFunction {

	public void printOwing(Invoice invoice) {
		int outstanding = 0;

		printBanner();

		// 미해결 채무(outstanding)를 계산한다.
		for (Order order : invoice.getOrders()) {
			outstanding += order.amount();
		}

		recordDueDate(invoice);

		printDetails(invoice, outstanding);
	}

	private static void recordDueDate(Invoice invoice) {
		LocalDate today = LocalDate.now();
		invoice.updateDueDate(today.plusDays(30));
	}

	private static void printDetails(Invoice invoice, int outstanding) {
		// 세부사항을 출력한다.
		System.out.println("고객명 : " + invoice.getCustomer());
		System.out.println("채무액 : " + outstanding);
		System.out.println("마감일 : " + invoice.getDueDate().toString());
	}

	private static void printBanner() {
		System.out.println("*** 고객 채무 ***");
	}

	public static void main(String[] args) {
		ExtractFunction extractFunction = new ExtractFunction();
		Invoice invoice = new Invoice(Order.of(List.of(1000, 2000, 3000)), "나현");
		extractFunction.printOwing(invoice);
	}
}

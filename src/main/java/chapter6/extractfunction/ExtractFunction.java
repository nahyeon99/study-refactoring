package chapter6.extractfunction;

import java.time.LocalDate;
import java.util.List;

public class ExtractFunction {

	public void printOwing(Invoice invoice) {
		printBanner();
		int outstanding = calculateOutstanding(invoice);
		recordDueDate(invoice);
		printDetails(invoice, outstanding);
	}

	private int calculateOutstanding(Invoice invoice) {
		int result = 0;
		for (Order order : invoice.getOrders()) {
			result += order.amount();
		}
		return result;
	}

	private void recordDueDate(Invoice invoice) {
		LocalDate today = LocalDate.now();
		invoice.updateDueDate(today.plusDays(30));
	}

	private void printDetails(Invoice invoice, int outstanding) {
		System.out.println("고객명 : " + invoice.getCustomer());
		System.out.println("채무액 : " + outstanding);
		System.out.println("마감일 : " + invoice.getDueDate().toString());
	}

	private void printBanner() {
		System.out.println("*** 고객 채무 ***");
	}

	public static void main(String[] args) {
		ExtractFunction extractFunction = new ExtractFunction();
		Invoice invoice = new Invoice(Order.of(List.of(1000, 2000, 3000)), "나현");
		extractFunction.printOwing(invoice);
	}
}

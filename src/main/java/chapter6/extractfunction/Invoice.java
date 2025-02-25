package chapter6.extractfunction;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Invoice {

	private List<Order> orders;
	private LocalDate dueDate;
	private String customer;

	public Invoice(List<Order> orders, String customer) {
		this.orders = orders;
		this.customer = customer;
	}

	public List<Order> getOrders() {
		return Collections.unmodifiableList(orders);
	}

	public void updateDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getCustomer() {
		return customer;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
}

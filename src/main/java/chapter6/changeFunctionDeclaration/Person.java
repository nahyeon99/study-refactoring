package chapter6.changeFunctionDeclaration;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public boolean inNewEngland(Customer aCustomer) {
		return List.of("MA", "CT", "ME", "VT", "NH", "RI").contains(aCustomer.address().state());
	}

	public void test() {
		List<Customer> someCustomers = new ArrayList<>();
		someCustomers.add(new Customer(new Address("MA")));
		someCustomers.add(new Customer(new Address("MB")));

		List<Customer> newEnglanders = someCustomers.stream()
			.filter(this::inNewEngland)
			.toList();
	}

}

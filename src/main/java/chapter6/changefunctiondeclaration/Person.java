package chapter6.changefunctiondeclaration;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private boolean inNewEngland(String stateCode) {
		return List.of("MA", "CT", "ME", "VT", "NH", "RI").contains(stateCode);
	}

	public void test() {
		List<Customer> someCustomers = new ArrayList<>();
		someCustomers.add(new Customer(new Address("MA")));
		someCustomers.add(new Customer(new Address("MB")));

		List<Customer> newEnglanders = someCustomers.stream()
			.filter(c -> inNewEngland(c.address().state()))
			.toList();
	}

}

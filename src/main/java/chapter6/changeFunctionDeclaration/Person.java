package chapter6.changeFunctionDeclaration;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public boolean inNewEngland(Customer aCustomer) {
		final String stateCode = aCustomer.address().state();
		return xxNEWinNewEngland(stateCode);
	}

	private boolean xxNEWinNewEngland(String stateCode) {
		return List.of("MA", "CT", "ME", "VT", "NH", "RI").contains(stateCode);
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

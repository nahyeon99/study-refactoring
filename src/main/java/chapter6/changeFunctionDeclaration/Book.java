package chapter6.changeFunctionDeclaration;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private List<String> reservations = new ArrayList<>();

	public void addReservation(String customer) {
		this.zz_addReservation(customer, false);
	}

	public void zz_addReservation(String customer, boolean isPriority) {
		this.reservations.add(customer);
	}
}

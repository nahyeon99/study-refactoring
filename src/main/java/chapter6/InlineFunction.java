package chapter6;

import java.util.HashMap;
import java.util.Map;

public class InlineFunction {

	public int rating(Driver aDriver) {
		return aDriver.numberOfLateDelivers() > 5 ? 2 : 1;
	}

	public Map<String, String> reportLines(Customer aCustomer) {
		Map<String, String> outputs = new HashMap<>();
		gatherCustomer(outputs, aCustomer);
		return outputs;
	}

	private void gatherCustomer(Map<String, String> results, Customer aCustomer) {
		results.put("name", aCustomer.name());
		results.put("location", aCustomer.location());
	}

	public static void main(String[] args) {
		InlineFunction inlineFunction = new InlineFunction();
		Map<String, String> results = inlineFunction.reportLines(new Customer("나현", "seoul"));
		results.entrySet()
			.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
}

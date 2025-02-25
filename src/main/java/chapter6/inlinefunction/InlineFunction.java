package chapter6.inlinefunction;

import java.util.HashMap;
import java.util.Map;

public class InlineFunction {

	public int rating(Driver aDriver) {
		return aDriver.numberOfLateDelivers() > 5 ? 2 : 1;
	}

	public Map<String, String> reportLines(Customer aCustomer) {
		Map<String, String> outputs = new HashMap<>();
		outputs.put("name", aCustomer.name());
		outputs.put("location", aCustomer.location());
		return outputs;
	}

	public static void main(String[] args) {
		InlineFunction inlineFunction = new InlineFunction();
		Map<String, String> results = inlineFunction.reportLines(new Customer("나현", "seoul"));
		results.entrySet()
			.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
}

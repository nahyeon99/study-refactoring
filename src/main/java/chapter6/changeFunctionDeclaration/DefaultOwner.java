package chapter6.changeFunctionDeclaration;

import java.util.HashMap;
import java.util.Map;

public class DefaultOwner {

	private Map<String, String> defaultOwner = new HashMap<>();
	private Spaceship spaceship;

	{
		defaultOwner.put("firstName", "나현");
		defaultOwner.put("lastName", "김");
	}

	public DefaultOwner(String firstName, String lastName) {
		HashMap<String, String> defaultOwner = new HashMap<>();
		this.defaultOwner = defaultOwner;
		this.spaceship = Spaceship.from(firstName, lastName);
	}

	public DefaultOwner getDefaultOwner() {
		return new DefaultOwner(defaultOwner.get("firstName"), defaultOwner.get("lastName"));
	}

	public void updateDefaultOwner(String firstName, String lastName) {
		defaultOwner.put("firstName", "마틴");
		defaultOwner.put("lastName", "파울러");
	}
}

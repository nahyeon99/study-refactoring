package chapter6.changeFunctionDeclaration;

import java.util.HashMap;
import java.util.Map;

public class DefaultOwner {

	public Map<String, String> defaultOwner = new HashMap<>();

	private Spaceship spaceship;

	{
		defaultOwner.put("firstName", "나현");
		defaultOwner.put("lastName", "김");
	}

	public DefaultOwner() {
		this.spaceship = new Spaceship(this.defaultOwner);
	}

	public void updateDefaultOwner(String firstName, String lastName) {
		defaultOwner.put("firstName", "마틴");
		defaultOwner.put("lastName", "파울러");
	}
}

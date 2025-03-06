package chapter6.changeFunctionDeclaration;

import java.util.HashMap;
import java.util.Map;

public record Spaceship(
	Map<String, String> defaultOwner
) {
	public Spaceship {
		/* no-op */
		throw new AssertionError();
	}

	public static Spaceship from(String firstName, String lastName) {
		HashMap<String, String> defaultOwner = new HashMap<>();
		defaultOwner.put("firstName", firstName);
		defaultOwner.put("lastName", lastName);
		return new Spaceship(defaultOwner);
	}
}

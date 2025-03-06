package chapter6.introduceparameterobject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Station {
	private String name;
	private List<Rending> rendings;

	public Station(String name, List<Rending> rendings) {
		this.name = name;
		this.rendings = new ArrayList<>(rendings);
	}

	public List<Rending> readingsOutsideRange(int min, int max, NumberRange range) {
		return rendings.stream()
			.filter(r -> r.isOutsideRange(min, max, range))
			.collect(Collectors.toUnmodifiableList());
	}
}

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

	public List<Rending> readingsOutsideRange(NumberRange range) {
		return rendings.stream()
			.filter(r -> !range.contains(r.getTemp()))
			.collect(Collectors.toUnmodifiableList());
	}
}

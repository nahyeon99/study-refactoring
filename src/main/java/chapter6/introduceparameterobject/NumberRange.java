package chapter6.introduceparameterobject;

public record NumberRange(
	int min,
	int max
) {

	public boolean contains(int temp) {
		return temp >= min && temp <= max;
	}
}

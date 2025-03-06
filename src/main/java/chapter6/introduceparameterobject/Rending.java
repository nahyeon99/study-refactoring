package chapter6.introduceparameterobject;

import java.time.LocalDateTime;

public class Rending {

	private int temp;
	public LocalDateTime time;

	public Rending(int temp, LocalDateTime time) {
		this.temp = temp;
		this.time = time;
	}

	public boolean isOutsideRange(NumberRange range) {
		return temp < range.min() || temp > range.max();
	}
}

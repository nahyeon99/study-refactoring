package chapter6.changeFunctionDeclaration;

import java.time.LocalDateTime;

public class Rending {

	private int temp;
	public LocalDateTime time;

	public Rending(int temp, LocalDateTime time) {
		this.temp = temp;
		this.time = time;
	}

	public boolean isOutsideRange(int min, int max) {
		return temp < min || temp > max;
	}
}

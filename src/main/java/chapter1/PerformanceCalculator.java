package chapter1;

import chapter1.dto.Performance;
import chapter1.dto.Play;

public class PerformanceCalculator {

	private final Performance performance;
	private final Play play;

	public PerformanceCalculator(final Performance performance, final Play play) {
		this.performance = performance;
		this.play = play;
	}

	public Performance getPerformance() {
		return performance;
	}

	public Play getPlay() {
		return play;
	}

	public long getAmount() {
		long result = 0;
		switch (play.type()) {
			case "tragedy":
				result = 40_000;
				if (performance.audience() > 30) {
					result += 1_000 * (performance.audience() - 30);
				}
				break;
			case "comedy":
				result = 30_000;
				if (performance.audience() > 20) {
					result += 10_000 + 500 * (performance.audience() - 20);
				}
				result += 300 * performance.audience();
				break;
			default:
				throw new IllegalArgumentException("unknown type: " + play.type());
		}
		return result;
	}
}

package chapter1;

import chapter1.dto.Performance;
import chapter1.dto.Play;

public class PerformanceCalculator {

	private final Performance performance;
	private final Play play;

	protected PerformanceCalculator(final Performance performance, final Play play) {
		this.performance = performance;
		this.play = play;
	}

	public static PerformanceCalculator from(final Performance performance, final Play play) {
		switch (play.type()) {
			case "tragedy":
				return new TragedyCalculator(performance, play);
			case "comedy":
				return new ComedyCalculator(performance, play);
			default:
				throw new IllegalArgumentException("unknown type: " + play.type());
		}
	}

	public Performance getPerformance() {
		return this.performance;
	}

	public Play getPlay() {
		return this.play;
	}

	public long getAmount() {
		long result = 0;
		switch (this.play.type()) {
			case "tragedy":
				result = 40_000;
				if (this.performance.audience() > 30) {
					result += 1_000 * (this.performance.audience() - 30);
				}
				break;
			case "comedy":
				result = 30_000;
				if (this.performance.audience() > 20) {
					result += 10_000 + 500 * (this.performance.audience() - 20);
				}
				result += 300 * this.performance.audience();
				break;
			default:
				throw new IllegalArgumentException("unknown type: " + this.play.type());
		}
		return result;
	}

	public long getVolumeCredits() {
		long result = 0;
		result += Math.max(this.performance.audience() - 30, 0);

		if ("comedy".equals(this.play.type())) {
			result += Math.floor(this.performance.audience() / 5);
		}
		return result;
	}
}

package chapter1;

import chapter1.dto.Performance;
import chapter1.dto.Play;

public class PerformanceCalculator {

	private final Performance performance;
	private final Play play;

	protected PerformanceCalculator(final Performance aPerformance, final Play aPlay) {
		this.performance = aPerformance;
		this.play = aPlay;
	}

	public static PerformanceCalculator from(final Performance aPerformance, final Play aPlay) {
		switch (aPlay.type()) {
			case "tragedy":
				return new TragedyCalculator(aPerformance, aPlay);
			case "comedy":
				return new ComedyCalculator(aPerformance, aPlay);
			default:
				throw new IllegalArgumentException("unknown type: " + aPlay.type());
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
				throw new IllegalStateException("오류 발생");
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

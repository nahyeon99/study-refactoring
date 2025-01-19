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
		throw new IllegalStateException("서브클래스에서 처리하도록 설계되었습니다.");
	}

	public long getVolumeCredits() {
		return Math.max(this.performance.audience() - 30, 0);
	}
}

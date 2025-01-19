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
}

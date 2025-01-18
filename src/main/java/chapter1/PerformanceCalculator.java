package chapter1;

import chapter1.dto.Performance;

public class PerformanceCalculator {

	private final Performance performance;

	public PerformanceCalculator(Performance performance) {
		this.performance = performance;
	}

	public Performance getPerformance() {
		return performance;
	}
}

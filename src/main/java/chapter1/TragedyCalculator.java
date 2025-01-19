package chapter1;

import chapter1.dto.Performance;
import chapter1.dto.Play;

public class TragedyCalculator extends PerformanceCalculator {

	public TragedyCalculator(final Performance performance, final Play play) {
		super(performance, play);
	}

	@Override
	public long getAmount() {
		long result = 40_000;
		if (getPerformance().audience() > 30) {
			result += 1_000 * (getPerformance().audience() - 30);
		}
		return result;
	}
}

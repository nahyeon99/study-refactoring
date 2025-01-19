package chapter1;

import chapter1.dto.Performance;
import chapter1.dto.Play;

public class ComedyCalculator extends PerformanceCalculator {

	public ComedyCalculator(final Performance performance, final Play play) {
		super(performance, play);
	}

	@Override
	public long getAmount() {
		long result = 30_000;
		if (getPerformance().audience() > 20) {
			result += 10_000 + 500 * (getPerformance().audience() - 20);
		}
		result += 300 * getPerformance().audience();
		return result;
	}

	@Override
	public long getVolumeCredits() {
		return super.getVolumeCredits() + (super.getPerformance().audience() / 5);
	}
}

package chapter1.dto;

import java.util.Map;

import chapter1.PerformanceCalculator;

public record EnrichPerformance(
	String playID,
	Integer audience,
	Play play,
	long amount,
	long volumeCredits
) {
	public static EnrichPerformance from(final Performance aPerformance, final Map<String, Play> plays) {
		final PerformanceCalculator calculator = new PerformanceCalculator(aPerformance,
			playFor(aPerformance, plays));

		return new EnrichPerformance(aPerformance.playID(),
			aPerformance.audience(),
			calculator.getPlay(),
			amountFor(aPerformance, calculator.getPlay()),
			volumeCreditsFor(aPerformance, calculator.getPlay()));
	}

	private static long volumeCreditsFor(final Performance aPerformance, final Play play) {
		long result = 0;
		result += Math.max(aPerformance.audience() - 30, 0);

		if ("comedy".equals(play.type())) {
			result += Math.floor(aPerformance.audience() / 5);
		}
		return result;
	}

	private static long amountFor(final Performance aPerformance, final Play play) {
		long result = 0;
		switch (play.type()) {
			case "tragedy":
				result = 40_000;
				if (aPerformance.audience() > 30) {
					result += 1_000 * (aPerformance.audience() - 30);
				}
				break;
			case "comedy":
				result = 30_000;
				if (aPerformance.audience() > 20) {
					result += 10_000 + 500 * (aPerformance.audience() - 20);
				}
				result += 300 * aPerformance.audience();
				break;
			default:
				throw new IllegalArgumentException("unknown type: " + play.type());
		}
		return result;
	}

	private static Play playFor(final Performance aPerformance, final Map<String, Play> plays) {
		return plays.get(aPerformance.playID());
	}
}

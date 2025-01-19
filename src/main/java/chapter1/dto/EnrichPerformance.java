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
			calculator.getAmount(),
			calculator.getVolumeCredits());
	}

	private static Play playFor(final Performance aPerformance, final Map<String, Play> plays) {
		return plays.get(aPerformance.playID());
	}
}

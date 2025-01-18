package chapter1.dto;

import java.util.Map;

public record EnrichPerformance(
	String playID,
	Integer audience,
	Play play
) {
	public EnrichPerformance(final Performance aPerformance, final Map<String, Play> plays) {
		this(aPerformance.playID(), aPerformance.audience(), playFor(aPerformance, plays));
	}

	private static Play playFor(final Performance aPerformance, final Map<String, Play> plays) {
		return plays.get(aPerformance.playID());
	}
}

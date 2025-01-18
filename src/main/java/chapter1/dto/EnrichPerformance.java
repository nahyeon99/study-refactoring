package chapter1.dto;

public record EnrichPerformance(
	String playID,
	Integer audience
) {
	public EnrichPerformance(final Performance performance) {
		this(performance.playID(), performance.audience());
	}
}

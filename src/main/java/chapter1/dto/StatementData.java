package chapter1.dto;

import java.util.List;
import java.util.Map;

public record StatementData(
	String customer,
	List<EnrichPerformance> performances
) {
	public static StatementData from(final Invoice invoice, final Map<String, Play> plays) {
		return new StatementData(invoice.customer(),
			invoice.performances().stream()
				.map(aPerformance -> EnrichPerformance.from(aPerformance, plays))
				.toList());
	}
}

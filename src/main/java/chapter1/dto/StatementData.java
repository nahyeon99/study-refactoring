package chapter1.dto;

import java.util.List;
import java.util.Map;

public record StatementData(
	String customer,
	List<EnrichPerformance> performances,
	long totalAmount,
	long totalVolumeCredits
) {
	public static StatementData from(final Invoice invoice, final Map<String, Play> plays) {
		final List<EnrichPerformance> performances = invoice.performances().stream()
			.map(aPerformance -> EnrichPerformance.from(aPerformance, plays))
			.toList();

		return new StatementData(invoice.customer(),
			performances,
			totalAmount(performances),
			totalVolumeCredits(performances));
	}

	private static long totalAmount(final List<EnrichPerformance> performances) {
		long result = 0;
		for (var performance : performances) {
			result += performance.amount();
		}
		return result;
	}

	private static long totalVolumeCredits(final List<EnrichPerformance> performances) {
		long result = 0;
		for (var performance : performances) {
			result += performance.volumeCredits();
		}
		return result;
	}
}

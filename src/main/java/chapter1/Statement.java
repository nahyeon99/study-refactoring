package chapter1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import chapter1.dto.Invoice;
import chapter1.dto.Performance;
import chapter1.dto.Play;

public class Statement {

	public String statement(Invoice invoice, Map<String, Play> plays) {
		long totalAmount = 0;
		StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + invoice.customer() + ")\n");

		for (Performance performance : invoice.performances()) {
			// 청구 내역을 출력한다.
			result.append(
				String.format(
					"  %s: %s (%d석)\n",
					playFor(plays, performance).name(),
					usd(amountFor(plays, performance)),
					performance.audience()
				)
			);
		}

		for (Performance performance : invoice.performances()) {
			totalAmount += amountFor(plays, performance);
		}

		result.append(String.format("총액: %s\n", usd(totalAmount)));
		result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(invoice, plays)));
		return result.toString();
	}

	private long totalVolumeCredits(Invoice invoice, Map<String, Play> plays) {
		long result = 0;
		for (Performance performance : invoice.performances()) {
			result += volumeCreditsFor(plays, performance);
		}
		return result;
	}

	private String usd(long aNumber) {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(aNumber / 100.0);
	}

	private long volumeCreditsFor(Map<String, Play> plays, Performance aPerformance) {
		long result = 0;
		result += Math.max(aPerformance.audience() - 30, 0);

		if ("comedy".equals(playFor(plays, aPerformance).type())) {
			result += Math.floor(aPerformance.audience() / 5);
		}
		return result;
	}

	private Play playFor(Map<String, Play> plays, Performance aPerformance) {
		return plays.get(aPerformance.playID());
	}

	private long amountFor(Map<String, Play> plays, Performance aPerformance) {
		long result = 0;
		switch (playFor(plays, aPerformance).type()) {
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
				throw new IllegalArgumentException("unknown type: " + playFor(plays, aPerformance).type());
		}
		return result;
	}
}

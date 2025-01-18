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
		long volumnCredits = 0;
		StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + invoice.customer() + ")\n");
		final NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

		for (Performance performance : invoice.performances()) {
			final Play play = playFor(plays, performance);
			long thisAmount = amountFor(performance, play);

			// 포인트를 적립한다.
			volumnCredits += Math.max(performance.audience() - 30, 0);
			// 희극 관객 5명마다 추가 포인트를 제공한다.
			if ("comedy".equals(play.type())) {
				volumnCredits += Math.floor(performance.audience() / 5);
			}

			// 청구 내역을 출력한다.
			result.append(
				String.format(
					"  %s: %s (%d석)\n",
					play.name(),
					format.format(thisAmount / 100.0),
					performance.audience()
				)
			);
			totalAmount += thisAmount;
		}

		result.append(String.format("총액: %s\n", format.format(totalAmount / 100.0)));
		result.append(String.format("적립 포인트: %d점\n", volumnCredits));
		return result.toString();
	}

	private Play playFor(Map<String, Play> plays, Performance aPerformance) {
		return plays.get(aPerformance.playID());
	}

	private long amountFor(Performance aPerformance, Play play) {
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
}

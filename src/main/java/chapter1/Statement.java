package chapter1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import chapter1.dto.Invoice;
import chapter1.dto.Play;
import chapter1.dto.StatementData;

public class Statement {

	public String statement(final Invoice invoice, final Map<String, Play> plays) {
		return renderPlainText(StatementData.from(invoice, plays));
	}

	private String renderPlainText(final StatementData data) {
		StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + data.customer() + ")\n");

		for (var performance : data.performances()) {
			// 청구 내역을 출력한다.
			result.append(
				String.format(
					"  %s: %s (%d석)\n",
					performance.play().name(),
					usd(performance.amount()),
					performance.audience()
				)
			);
		}

		result.append(String.format("총액: %s\n", usd(data.totalAmount())));
		result.append(String.format("적립 포인트: %d점\n", data.totalVolumeCredits()));
		return result.toString();
	}

	private String usd(long aNumber) {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(aNumber / 100.0);
	}
}

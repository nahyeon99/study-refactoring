package chapter1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import chapter1.dto.Invoice;
import chapter1.dto.Play;
import chapter1.dto.StatementData;

public class Statement {

	public String htmlStatement(final Invoice invoice, final Map<String, Play> plays) {
		return renderHtml(StatementData.from(invoice, plays));
	}

	public String statement(final Invoice invoice, final Map<String, Play> plays) {
		return renderPlainText(StatementData.from(invoice, plays));
	}

	private String renderHtml(final StatementData data) {
		var result = new StringBuilder(String.format("<h1>청구 내역 (고객명 : %s)</h1>\n", data.customer()));
		result.append("<table>\n");
		result.append("  <tr><th>연극</th><th>총액</th><th>좌석 수</th><th>금액</th></tr>\n");
		for (var performance : data.performances()) {
			result.append(
				String.format("  <tr><td>%s</td><td>%s</td>", performance.play().name(), performance.audience()));
			result.append(String.format("<td>%s</td></tr>\n", usd(performance.amount())));
		}
		result.append("</table>\n");
		result.append(String.format("<p>총액: <em>%s</em></p>\n", usd(data.totalAmount())));
		result.append(String.format("<p>적립 포인트: <em>%s</em>점</p>\n", data.totalVolumeCredits()));

		return result.toString();
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

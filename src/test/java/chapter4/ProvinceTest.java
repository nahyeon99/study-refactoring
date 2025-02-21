package chapter4;

import static chapter4.JsonProvinceDataLoader.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProvinceTest {

	private Province asiaProvince;

	@BeforeEach
	void setUp() {
		this.asiaProvince = new Province(JSON_PROVINCE_DATA_LOADER.provinceData());
	}

	@Test
	public void 생산_부족분_계산이_성공한다() {
		// when
		Integer shortfall = asiaProvince.getShortfall();

		// then
		assertThat(shortfall).isEqualTo(5);
	}

	@Test
	public void 총수익_계산에_성공한다() {
		// when
		Integer profit = asiaProvince.getProfit();

		// then
		assertThat(profit).isEqualTo(230);
	}

	@Test
	public void production_변경에_성공한다() {
		// when
		asiaProvince.getProducers().get(0).setProduction("20");

		// then
		SoftAssertions.assertSoftly(softly -> {
			assertThat(asiaProvince.getShortfall()).isEqualTo(-6);
			assertThat(asiaProvince.getProfit()).isEqualTo(292);
		});
	}

	@Test
	public void producers_컬렉션이_비어도_성공한다() {
		// when
		Province noProducers = new Province(new ProvinceCreate("No Producers", List.of(), 30, 20));

		// then
		SoftAssertions.assertSoftly(softly -> {
			assertThat(noProducers.getShortfall()).isEqualTo(30);
			assertThat(noProducers.getProfit()).isEqualTo(0);
		});
	}

	@Test
	public void demand가_zero_여도_성공한다() {
		// when
		asiaProvince.setDemand("0");

		// then
		SoftAssertions.assertSoftly(softly -> {
			assertThat(asiaProvince.getShortfall()).isEqualTo(-25);
			assertThat(asiaProvince.getProfit()).isEqualTo(0);
		});
	}

	@Test
	public void demand가_음수여도_성공한다() {
		// when
		asiaProvince.setDemand("-1");

		// then
		SoftAssertions.assertSoftly(softly -> {
			assertThat(asiaProvince.getShortfall()).isEqualTo(-26);
			assertThat(asiaProvince.getProfit()).isEqualTo(-10);
		});
	}

	@Test
	public void demand가_비면_예외를_던진다() {
		// then
		assertThatThrownBy(() -> asiaProvince.setDemand(""))
			.isInstanceOf(NumberFormatException.class);
	}

	private List<Producer> getProducers() {
		List<Producer> results = List.of(
			new Producer(10, "Byzantium", 9),
			new Producer(12, "Attalia", 10),
			new Producer(10, "Sinope", 6)
		);
		return results;
	}
}
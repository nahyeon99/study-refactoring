package chapter4;

import static chapter4.JsonProvinceDataLoader.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

	private List<Producer> getProducers() {
		List<Producer> results = List.of(
			new Producer(10, "Byzantium", 9),
			new Producer(12, "Attalia", 10),
			new Producer(10, "Sinope", 6)
		);
		return results;
	}
}
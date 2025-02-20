package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Province {

	private String name;
	private Integer totalProduction;
	private Integer demand;
	private Integer price;
	private List<Producer> producers = new ArrayList<>();

	private Province(String name,
		Integer totalProduction,
		Integer demand,
		Integer price,
		List<Producer> producers) {
		this.name = name;
		this.totalProduction = totalProduction;
		this.demand = demand;
		this.price = price;
		producers.forEach(this::addProducer);
	}

	public Province(ProvinceData provinceData) {
		this(provinceData.name(), provinceData.totalProduction(), provinceData.demand(), provinceData.price(),
			provinceData.producers());
	}

	public String getName() {
		return name;
	}

	public Integer getTotalProduction() {
		return totalProduction;
	}

	public void setTotalProduction(Integer totalProduction) {
		this.totalProduction = totalProduction;
	}

	public Integer getDemand() {
		return demand;
	}

	public void setDemand(String demandStr) {
		this.demand = Integer.parseInt(demandStr);
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(String priceStr) {
		this.price = Integer.parseInt(priceStr);
	}

	public List<Producer> getProducers() {
		return Collections.unmodifiableList(producers);
	}

	public Integer getShortfall() {
		return this.demand - this.totalProduction;
	}

	public Integer getProfit() {
		return getDemandValue() - getDemandCost();
	}

	private Integer getDemandValue() {
		return getSatisfiedDemand() * this.price;
	}

	private Integer getSatisfiedDemand() {
		return Math.min(this.demand, this.totalProduction);
	}

	private Integer getDemandCost() {
		Integer remainingDemand = this.demand;
		Integer result = 0;
		List<Producer> sortedProducers = this.producers
			.stream()
			.sorted((a, b) -> a.getCost() - b.getCost())
			.toList();

		for (Producer aProducer : sortedProducers) {
			int contribution = Math.min(remainingDemand, aProducer.getProduction());
			remainingDemand -= contribution;
			result += contribution * aProducer.getCost();
		}
		return result;
	}

	private void addProducer(Producer aProducer) {
		this.producers.add(new Producer(this, aProducer));
		this.totalProduction += aProducer.getProduction();
	}
}
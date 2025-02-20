package chapter4;

public class Producer {

	private Province province;
	private Integer cost;
	private String name;
	private Integer production;

	private Producer(Province province, Integer cost, String name, Integer production) {
		this.province = province;
		this.cost = cost;
		this.name = name;
		this.production = production;
	}

	public Producer(Province aProvince, Producer aProducer) {
		this(aProvince, aProducer.cost, aProducer.name, aProducer.production);
	}

	public Integer getProduction() {
		return production;
	}

	public void setProduction(String productionStr) {
		Integer newProduction = Integer.parseInt(productionStr);
		this.province.setTotalProduction(this.province.getTotalProduction() + newProduction - this.production);
		this.production = newProduction;
	}

	public String getName() {
		return name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(String costStr) {
		this.cost = Integer.parseInt(costStr);
	}

	public Province getProvince() {
		return province;
	}
}

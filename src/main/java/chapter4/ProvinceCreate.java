package chapter4;

import java.util.List;

public record ProvinceCreate(
	String name,
	Integer totalProduction,
	Integer demand,
	Integer price,
	List<Producer> producers
) {
}

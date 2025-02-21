package chapter4;

import java.util.List;

public record ProvinceCreate(
	String name,
	List<Producer> producers,
	Integer demand,
	Integer price
) {
}

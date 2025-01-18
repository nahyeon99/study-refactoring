package chapter1.dto;

import java.util.List;

public record StatementData(
	String customer,
	List<Performance> performances
) {
}

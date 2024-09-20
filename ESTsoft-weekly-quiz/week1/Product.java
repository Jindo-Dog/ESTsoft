package chap08.quiz.week1;

import java.math.BigDecimal;

public class Product implements Promotion {
	private String name;
	private BigDecimal price;
	private Double weight;

	Product(String name, BigDecimal price, Double weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public BigDecimal getDiscountAmount() {
		return switch (name) {
			case "grocery" -> new BigDecimal("2000");
			case "beauty" -> new BigDecimal("10000");
			case "largeAppliance" -> new BigDecimal("00");
			default -> new BigDecimal("0");
		};
	}
}

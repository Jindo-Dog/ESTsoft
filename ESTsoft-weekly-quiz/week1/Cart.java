package chap08.quiz.week1;

import java.math.BigDecimal;

public class Cart {
	Product[] products;

	Cart(Product[] products) {
		this.products = products;
	}

	int calculateDeliveryCharge() {
		BigDecimal deliveryCharge = new BigDecimal("0");
		double weight = 0;
		int shippingCost;

		for (Product product : products) {
			weight += product.getWeight();
			deliveryCharge = deliveryCharge.add(new BigDecimal((product.getPrice().subtract(product.getDiscountAmount())).toString()));
		}

		if (weight >= 10) {
			shippingCost = 10000;
		} else if (weight >= 3) {
			shippingCost = 5000;
		} else {
			shippingCost = 1000;
		}

		if (deliveryCharge.compareTo(new BigDecimal("100000")) > 0) {
			shippingCost = 0;
		} else if (deliveryCharge.compareTo(new BigDecimal("30000")) > 0) {
			shippingCost -= 1000;
		}

		return shippingCost;
	}
}

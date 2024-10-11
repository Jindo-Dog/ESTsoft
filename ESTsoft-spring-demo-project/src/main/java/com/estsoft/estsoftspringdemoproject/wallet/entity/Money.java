package com.estsoft.estsoftspringdemoproject.wallet.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class Money {
	@Enumerated(EnumType.STRING)
	private Currency currency;
	private Long amounts;

	public Money() {
	}

	public Money(Long amounts) {
		this.currency = Currency.WON;
		this.amounts = amounts;
	}

	public Money(Currency currency, long amounts) {
		this.currency = currency;
		this.amounts = amounts;
	}

	public Money add(Money money) {
		if (!money.currency.equals(this.currency))
			throw new RuntimeException("not the same currency");
		return new Money(currency, amounts + money.getAmounts());
	}
}

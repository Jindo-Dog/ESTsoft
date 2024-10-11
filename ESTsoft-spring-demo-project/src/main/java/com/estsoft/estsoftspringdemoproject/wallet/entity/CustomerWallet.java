package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.Optional;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "wallet")
@Entity(name = "CustomerWallet")
@DiscriminatorValue("CUSTOMER")
@NoArgsConstructor
@Getter
@Setter
public class CustomerWallet extends Wallet {
	@Transient
	private Account cashback, prepaid, emoney;

	public CustomerWallet(String userId) {
		super(userId);
	}

	public Account cashback() {
		if (cashback != null)
			return cashback;
		this.cashback = findAccountByType(AccountType.CASHBACK).orElseThrow(
			() -> new RuntimeException("chashback not found")
		);

		return this.cashback;
	}

	public Account prepaid() {
		if (prepaid != null)
			return prepaid;
		this.prepaid = findAccountByType(AccountType.PREPAID).orElseThrow(
			() -> new RuntimeException("prepaid not found")
		);

		return this.prepaid;
	}

	public Account emoney() {
		if (emoney != null)
			return emoney;
		this.emoney = findAccountByType(AccountType.EMONEY).orElseThrow(
			() -> new RuntimeException("emoney not found")
		);

		return this.emoney;
	}

	public Optional<Account> findAccountByType(AccountType type) {
		return accounts.stream().filter(a -> a.getType() == type).findFirst();
	}

	// SELECT * FROM wallet WHERE TYPE = 'CUSTOMER' AND user_id = "김씨";
	@Override
	public long getTotalBalance() {
		long sum = cashback().getBalance().getAmounts() + prepaid().getBalance().getAmounts() + emoney().getBalance().getAmounts();
		return sum;
	}
}

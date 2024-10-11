package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.estsoft.estsoftspringdemoproject.wallet.model.AccountDTO;
import com.estsoft.estsoftspringdemoproject.wallet.model.WalletDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
// 이후부터 중요
@DiscriminatorColumn(name = "type")
public abstract class Wallet extends WalletEntityObject {
	// wallletentityobject -> wallet -> CustomerWallet(일반사용자), SystemWallet, MerchantWallet(개인사업자)
	@Getter
	@OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	protected Collection<Account> accounts;

	@Column(name = "user_id")
	private String userId;

	public Wallet(String userId) {
		this.setUserId(userId);
		this.accounts = new ArrayList<>();
	}

	@Transient
	public String getDiscriminatorValue() {
		DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
		return val == null ? null : val.value();
	}

	public abstract long getTotalBalance();

	public Account createAccount(Account account) {
		this.accounts.add(account);
		return account;
	}

	public WalletDTO convertToDTO() {
		List<AccountDTO> accountDTOS = accounts.stream()
			.filter(Account::isVisible)
			.map(Account::convertToDTO)
			.toList();

		return new WalletDTO(id, userId, getDiscriminatorValue(), getTotalBalance(), accountDTOS);
	}
}

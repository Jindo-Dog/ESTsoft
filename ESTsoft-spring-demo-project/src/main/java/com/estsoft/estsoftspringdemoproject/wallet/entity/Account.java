package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.UpdateTimestamp;

import com.estsoft.estsoftspringdemoproject.wallet.model.AccountDTO;

import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
// public class Account extends WalletEntityObject { Account 클래스와 Wallet 클래스 비교
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AccountType type;

	@Column(name = "visible")
	private boolean visible = false;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_id")
	private Wallet wallet;

	@Embedded
	private Money balance;

	@Version
	private int version;

	@UpdateTimestamp
	// @Column(name = "updated_at")
	@Column
	private Date updatedAt;

	@Column(columnDefinition = "TEXT")
	@Convert(converter = WalletMapConverter.class)
	private Map<String, String> metadata = new HashMap<>();

	public Account(Wallet wallet, AccountType type, boolean visible) {
		this.wallet = wallet;
		this.type = type;
		this.balance = new Money(0L);
		this.visible = visible;
	}

	public AccountDTO convertToDTO() {
		return new AccountDTO(id, visible, balance.getCurrency().name(), balance.getAmounts(), type.name());
	}

	public Money balance() {
		return this.balance;
	}

	public void credit(Money amount) {
		this.balance = this.balance.add(amount);
	}
}

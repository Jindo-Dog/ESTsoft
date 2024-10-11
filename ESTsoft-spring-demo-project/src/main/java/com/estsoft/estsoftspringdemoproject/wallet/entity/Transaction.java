package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.Date;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Transaction extends WalletEntityObject {
	private long pid;
	@Column(name = "src_user_id")
	private String srcUserId;
	@Column(name = "src_account_id")
	private long srcAccountId;
	@Column(name = "src_amount")
	private long srcAmount;
	@Column(name = "src_balance")
	private long srcBalance;
	@Enumerated(EnumType.STRING)
	@Column(name = "src_account_type")
	private AccountType srcAccountType;
	@Enumerated(EnumType.STRING)
	@Column(name = "src_currency")
	private Currency srcCurrency;

	@Column(name = "dst_user_id")
	private String dstUserId;
	@Column(name = "dst_account_id")
	private long dstAccountId;
	@Column(name = "dst_amount")
	private long dstAmount;
	@Column(name = "dst_balance")
	private long dstBalance;
	@Enumerated(EnumType.STRING)
	@Column(name = "dst_account_type")
	private AccountType dstAccountType;
	@Enumerated(EnumType.STRING)
	@Column(name = "dst_currency")
	private Currency dstCurrency;

	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;

	public Transaction(
		long correlationId,
		long srcAccountId,
		Currency srcAccountCurrency,
		long srcAmount,
		String srcUserId,
		long srcBalance,
		AccountType srcAccountType,
		long dstAccountId,
		Currency dstAccountCurrency,
		long dstAmount,
		String dstUserId,
		long dstBalance,
		AccountType dstAccountType,
		Map<String, String> metadata) {
		this.pid = correlationId;
		this.srcUserId = srcUserId;
		this.srcAccountId = srcAccountId;
		this.srcCurrency = srcAccountCurrency;
		this.srcAmount = srcAmount;
		this.srcBalance = srcBalance;
		this.srcAccountType = srcAccountType;
		this.dstUserId = dstUserId;
		this.dstAccountId = dstAccountId;
		this.dstCurrency = dstAccountCurrency;
		this.dstAmount = dstAmount;
		this.dstBalance = dstBalance;
		this.dstAccountType = dstAccountType;
		this.setMetadata(metadata);
	}
}
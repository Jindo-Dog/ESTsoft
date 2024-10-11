package com.estsoft.estsoftspringdemoproject.wallet.model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WalletDTO {
	private Long id;
	private String walletOwnerId;
	private String walletType;
	private long balance;
	private Collection<AccountDTO> accounts;
}

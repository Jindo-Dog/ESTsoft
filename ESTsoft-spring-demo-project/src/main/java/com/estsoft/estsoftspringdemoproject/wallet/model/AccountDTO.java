package com.estsoft.estsoftspringdemoproject.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDTO {
	private Long id;
	private boolean visible;
	private String currency;
	private long balance;
	private String type;
}

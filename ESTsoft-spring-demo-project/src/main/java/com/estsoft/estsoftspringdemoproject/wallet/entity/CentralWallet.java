package com.estsoft.estsoftspringdemoproject.wallet.entity;

import lombok.Data;

// 해당 wallet은 db에 만들었다고 가정하고 예제코드 작성됨
// customerWallet, merchantWallet과 동일하게 discriminatorValue 정하고, source Account

@Data
public class CentralWallet {
	private Long id;
	private String userId;
	private Long accountId;
	private long amounts;

	public long getId() {
		return 0l;
	}

	public long getAmounts() {
		return 0l;
	}

	public Long getAccountId() {
		return 0l;
	}

	public String getUserId() {
		return "0";
	}
}

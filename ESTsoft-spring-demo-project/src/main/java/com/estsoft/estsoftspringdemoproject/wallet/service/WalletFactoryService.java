package com.estsoft.estsoftspringdemoproject.wallet.service;

import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringdemoproject.wallet.entity.Account;
import com.estsoft.estsoftspringdemoproject.wallet.entity.AccountType;
import com.estsoft.estsoftspringdemoproject.wallet.entity.CustomerWallet;
import com.estsoft.estsoftspringdemoproject.wallet.entity.MerchantWallet;

@Service
public class WalletFactoryService {
	public CustomerWallet cerateCustomerWallet(String userId) {
		CustomerWallet customerWallet = new CustomerWallet(userId);
		customerWallet.createAccount(new Account(customerWallet, AccountType.CASHBACK, true));
		customerWallet.createAccount(new Account(customerWallet, AccountType.PREPAID, true));
		customerWallet.createAccount(new Account(customerWallet, AccountType.EMONEY, true));
		return customerWallet;
	}

	public MerchantWallet cerateMerchantWallet(String userId) {
		MerchantWallet merchantWallet = new MerchantWallet(userId);
		merchantWallet.createAccount(new Account(merchantWallet, AccountType.EMONEY, true));
		return merchantWallet;
	}
}

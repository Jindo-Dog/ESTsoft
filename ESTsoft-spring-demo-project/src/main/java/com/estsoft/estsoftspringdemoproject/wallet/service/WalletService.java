package com.estsoft.estsoftspringdemoproject.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.estsoftspringdemoproject.wallet.entity.CustomerWallet;
import com.estsoft.estsoftspringdemoproject.wallet.entity.MerchantWallet;
import com.estsoft.estsoftspringdemoproject.wallet.entity.Wallet;
import com.estsoft.estsoftspringdemoproject.wallet.model.WalletDTO;
import com.estsoft.estsoftspringdemoproject.wallet.repository.WalletRepository;

@Service
public class WalletService {
	@Autowired
	private WalletFactoryService walletFactoryService;
	@Autowired
	private WalletRepository walletRepository;

	@Transactional
	public WalletDTO saveWallet(String userId, String type) {
		Wallet wallet = null;

		if (type.equals("CUSTOMER")) {
			wallet = this.createCustomerWallet(userId);
		} else if (type.equals("MERCHANT")) {
			wallet = this.createMetchantWallet(userId);
		} else {
			throw new RuntimeException("NOT SUPPORTED WALLET TYPE : " + type);
		}

		return wallet.convertToDTO();
	}

	@Transactional
	public Wallet createCustomerWallet(String userId) {
		CustomerWallet wallet = walletFactoryService.cerateCustomerWallet(userId);

		Wallet result = walletRepository.save(wallet);

		return result;
	}

	@Transactional
	public Wallet createMetchantWallet(String userId) {
		MerchantWallet wallet = walletFactoryService.cerateMerchantWallet(userId);

		Wallet result = walletRepository.save(wallet);

		return result;
	}
}

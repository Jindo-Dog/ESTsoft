package com.estsoft.estsoftspringdemoproject.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.estsoftspringdemoproject.wallet.entity.AccountType;
import com.estsoft.estsoftspringdemoproject.wallet.entity.Money;
import com.estsoft.estsoftspringdemoproject.wallet.model.WalletDTO;
import com.estsoft.estsoftspringdemoproject.wallet.service.AccountService;
import com.estsoft.estsoftspringdemoproject.wallet.service.WalletService;

@RestController
public class WalletController {
	@Autowired
	private WalletService walletService;
	@Autowired
	private AccountService accountService;

	@PostMapping("/api/wallet/customer/{userId}")
	public ResponseEntity<WalletDTO> createCustomerWallet(@PathVariable String userId) {
		WalletDTO result = walletService.saveWallet(userId, "CUSTOMER");
		return ResponseEntity.ok(result);
	}

	@PostMapping("/api/wallet/merchant/{userId}")
	public ResponseEntity<WalletDTO> createMerchantWallet(@PathVariable String userId) {
		WalletDTO result = walletService.saveWallet(userId, "MERCHANT");
		return ResponseEntity.ok(result);
	}

	@PostMapping("/api/wallet/{accountType}/credit/{userId}")
	public ResponseEntity<String> creditCustomerWallet(
		@PathVariable(name = "accountType") AccountType accountType,
		@PathVariable(name = "userId") String userId,
		@RequestParam(name = "amount") Long amount) {

		accountService.credit(userId, accountType, new Money(amount));

		return ResponseEntity.ok("Success");
	}
}

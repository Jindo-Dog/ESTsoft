package com.estsoft.estsoftspringdemoproject.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estsoft.estsoftspringdemoproject.wallet.entity.CustomerWallet;

public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Long> {
	CustomerWallet findByUserId(String userId);
}

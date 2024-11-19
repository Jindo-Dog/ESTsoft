package com.estsoft.estsoftspringproject.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TDD
// 1. 계좌 생성
// 2. 잔금 조회
// 3. 입.출금
public class AccountTest {
	// 1. 꼐좌 생성
	@Test
	public void testAccount() {
		Account account = new Account(10_000);
		// 잔금 조회가 잘 되는가?
		if (account.getBalance() != 10_000) {
			fail();
		}

		Account account2 = new Account(200_000);
		if (account2.getBalance() != 200_000) {
			fail();
		}

		Account account3 = new Account(500_000);
		if (account3.getBalance() != 500_000) {
			fail();
		}
	}
}

package com.estsoft.estsoftspringproject.tdd;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
		// JUnit, AssertJ
		/*if (account.getBalance() != 10_000) {
			fail();
		}*/
		// hamcrest
		assertThat(account.getBalance(), is(10_000));

		account = new Account(200_000);
		assertThat(account.getBalance(), is(200_000));

		account = new Account(500_000);
		assertThat(account.getBalance(), is(500_000));    // 잔액 조회 기능 검증 완료
	}

	@Test
	public void testDeposit() {
		Account account = new Account(10_000);
		account.deposit(100_000);
		assertThat(account.getBalance(), is(110_000));    // 입금 기능 검증 완료
	}

	@Test
	public void testWithdraw() {
		Account account = new Account(10_000);
		account.withdraw(10_000);
		assertThat(account.getBalance(), is(0));        // 출금 기능 검증 완료
	}
}

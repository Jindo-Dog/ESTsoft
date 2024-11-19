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
		assertThat(account.getBalance(), is(500_000));
	}
}

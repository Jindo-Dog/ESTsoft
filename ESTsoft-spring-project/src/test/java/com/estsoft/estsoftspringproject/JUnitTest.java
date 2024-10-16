package com.estsoft.estsoftspringproject;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
	@Test
	@DisplayName("Assertions 테스트")
	public void test() {
		// given
		int a = 1;
		int b = 2;

		// when: 검증하고 싶은 메소드(코드) 호출
		int sum = a + b;

		// then: when 절에서 실행한 결과를 검증
		// Assertions.assertEquals(3, sum);
		assertThat(sum).isEqualTo(3);

		// assertThat(sum).isEven();
		// assertThat(sum).isOdd();
	}
}

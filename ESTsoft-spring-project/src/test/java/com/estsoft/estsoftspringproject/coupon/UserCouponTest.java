package com.estsoft.estsoftspringproject.coupon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserCouponTest {

	@Test
	public void testAddCoupon() {
		User user = new User("area00");
		assertEquals(0, user.getTotalCouponCount());    // 쿠폰 수령 전

		ICoupon coupon = new DummyCoupon();    // dummy 쿠폰을 만들어서 사용

		user.addCoupon(coupon);
		assertEquals(1, user.getTotalCouponCount());    // 쿠폰 수령 후 쿠폰 수 검증
	}

	@Test
	public void 쿠폰이_유효할_경우에만_유저에게_발급한다() {
		User user = new User("area00");
		assertEquals(0, user.getTotalCouponCount());    // 쿠폰 수령 전

		ICoupon coupon = Mockito.mock(ICoupon.class);    // mock객체 - 행위 정의 가능
		Mockito.when(coupon.isValid()).thenReturn(true);

		BDDMockito.given(coupon.isValid())
			.willReturn(true);    // isValid() 호출시 리턴값은 true

		user.addCoupon(coupon);
		assertEquals(1, user.getTotalCouponCount());    // 쿠폰 수령 후 쿠폰 수 검증
	}
}

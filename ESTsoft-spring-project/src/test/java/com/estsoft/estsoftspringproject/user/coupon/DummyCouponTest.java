package com.estsoft.estsoftspringproject.user.coupon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DummyCouponTest {
	@Test
	public void testGetName() {
		DummyCoupon coupon = new DummyCoupon();
		assertEquals("", coupon.getName());
	}

	@Test
	public void testIsValid() {
		DummyCoupon coupon = new DummyCoupon();
		assertTrue(coupon.isValid());
	}

	@Test
	public void testGetDiscountPercent() {
		DummyCoupon coupon = new DummyCoupon();
		assertEquals(0, coupon.getDiscountPercent());
	}

	@Test
	public void testIsAppliable() {
		DummyCoupon coupon = new DummyCoupon();
		Item item = new Item();
		assertFalse(coupon.isAppliable(item));
	}

	/*@Test
	public void testDoExpire() {
		DummyCoupon coupon = new DummyCoupon();
		coupon.doExpire();
	}*/
}
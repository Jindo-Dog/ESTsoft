package com.estsoft.estsoftspringproject.coupon;

public interface ICoupon {
	public String getName();

	public boolean isValid();

	public int getDiscountPercent();

	boolean isAppliable(Item item);

	public void doExpire();
}

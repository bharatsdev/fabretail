package com.fabretails.discounts.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DiscountByAmountTest {
	DiscountByAmount discountByAmount;
	static final double DISCOUNT_DISCOUNT = 5;

	@Before
	public void setup() {
		discountByAmount = new DiscountByAmount();
		discountByAmount.setDiscountAmount(DISCOUNT_DISCOUNT);
	}

	@Test
	public void whenDiscountThenDiscountResult() {
		assertEquals(new Double(945), new Double(discountByAmount.calculateDiscount(990)));
	}

	@Test
	public void whenDiscountThenDiscount() {
		assertEquals(new Double(DISCOUNT_DISCOUNT), new Double(discountByAmount.getDiscountAmount()));
	}

}

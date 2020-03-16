package com.fabretails.discounts.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountByAmountTest {
	DiscountByAmount discountByAmount;
	static final double DISCOUNT_DISCOUNT = 5;

	@BeforeEach
	public void setup() {
		discountByAmount = new DiscountByAmount();
		discountByAmount.setDiscountAmount(DISCOUNT_DISCOUNT);
	}

	@Test
	void whenDiscountThenDiscountResult() {
		assertEquals(new Double(945),new Double(discountByAmount.calculateDiscount(990)));
	}

	@Test
	void whenDiscountThenDiscount() {
		assertEquals(new Double(DISCOUNT_DISCOUNT),new Double(discountByAmount.getDiscountAmount()));
	}

}

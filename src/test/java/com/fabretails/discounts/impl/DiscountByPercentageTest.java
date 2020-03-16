package com.fabretails.discounts.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountByPercentageTest {

	private DiscountByPercentage discountByPercentage;
	static final double DISCOUNT_PERCENTAGE = 0.10;

	@BeforeEach
	public void setup() {
		discountByPercentage = new DiscountByPercentage(DISCOUNT_PERCENTAGE);
	}

	@Test
	void whenPercentageDiscountThenDiscountResult() {
		assertEquals(new Double(900), new Double(discountByPercentage.calculateDiscount(1000)));
	}

	@Test
	void whenDiscountThenDiscount() {
		assertEquals(new Double(DISCOUNT_PERCENTAGE), new Double(discountByPercentage.getDiscountByPercentage()));
	}
}

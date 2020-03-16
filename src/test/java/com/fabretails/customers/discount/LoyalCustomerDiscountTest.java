package com.fabretails.customers.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoyalCustomerDiscountTest {

	LoyalCustomerDiscount loyalCustomerDiscount;

	@BeforeEach
	void setUp() throws Exception {
		loyalCustomerDiscount = new LoyalCustomerDiscount();
	}

	@Test
	void testLoyalCustomerDiscount() {
		assertEquals(new Double(950.00), new Double(loyalCustomerDiscount.calculateDiscount(1000)));

	}

}

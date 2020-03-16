package com.fabretails.customers.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class LoyalCustomerDiscountTest {

	LoyalCustomerDiscount loyalCustomerDiscount;

	@Before
	public void setUp() throws Exception {
		loyalCustomerDiscount = new LoyalCustomerDiscount();
	}

	@Test
	public void testLoyalCustomerDiscount() {
		assertEquals(new Double(950.00), new Double(loyalCustomerDiscount.calculateDiscount(1000)));

	}

}

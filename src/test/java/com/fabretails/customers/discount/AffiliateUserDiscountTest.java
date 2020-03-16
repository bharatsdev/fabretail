/**
 * 
 */
package com.fabretails.customers.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author b.singh
 *
 */
public class AffiliateUserDiscountTest {
	AffiliateUserDiscount affiliateUserDiscount;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		affiliateUserDiscount = new AffiliateUserDiscount();
	}

	/**
	 * Test method for
	 * {@link com.fabretails.customers.discount.AffiliateUserDiscount#AffiliateUserDiscount()}.
	 */
	@Test
	public void testAffiliateUserDiscount() {
		assertEquals(new Double(900.0), new Double(affiliateUserDiscount.calculateDiscount(1000)));

	}

}

/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountPercentageImpl;

/**
 * @author b.singh
 *
 */
public class LoyalCustomerDiscount extends DiscountPercentageImpl {

	private static final double DISCOUNT = 0.05;

	public LoyalCustomerDiscount() {
		super(DISCOUNT);
	}

}

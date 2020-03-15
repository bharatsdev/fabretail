/**
 * 
 */
package com.fabretails.users.discount;

import com.fabretails.discounttype.impl.DiscountPercentageImpl;

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

/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountPercentageImpl;

/**
 * @author b.singh
 *
 */
public class AffiliateUserDiscount extends DiscountPercentageImpl {
	private static final double DISCOUNT = 0.1;

	public AffiliateUserDiscount() {
		super(DISCOUNT);
	}

}

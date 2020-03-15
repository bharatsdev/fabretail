/**
 * 
 */
package com.fabretails.users.discount;

import com.fabretails.discounttype.impl.DiscountPercentageImpl;

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

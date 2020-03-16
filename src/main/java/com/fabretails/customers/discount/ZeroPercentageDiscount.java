/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountByPercentage;

/**
 * This class will used only if there is not discount applicable on netbill
 * amount
 * 
 * @author b.singh
 *
 */
public class ZeroPercentageDiscount extends DiscountByPercentage {
	private static final double DISCOUNT = 0.0;

	public ZeroPercentageDiscount() {
		super(DISCOUNT);
	}

}

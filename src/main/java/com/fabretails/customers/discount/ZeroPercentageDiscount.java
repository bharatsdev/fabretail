/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountByPercentage;

/**
 * @author b.singh
 *
 */
public class ZeroPercentageDiscount extends DiscountByPercentage {
	private  static final double discount=0.0;

	public ZeroPercentageDiscount() {
		super(discount);
	}

}

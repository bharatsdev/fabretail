/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountPercentageImpl;

/**
 * @author b.singh
 *
 */
public class ZeroPercentageDiscount extends DiscountPercentageImpl {
	private  static final double discount=0.0;

	public ZeroPercentageDiscount() {
		super(discount);
	}

}

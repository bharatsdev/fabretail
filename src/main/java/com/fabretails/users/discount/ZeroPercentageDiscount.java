/**
 * 
 */
package com.fabretails.users.discount;

import com.fabretails.discounttype.impl.DiscountPercentageImpl;

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

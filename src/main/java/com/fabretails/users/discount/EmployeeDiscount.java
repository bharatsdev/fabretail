/**
 * 
 */
package com.fabretails.users.discount;

import com.fabretails.discounttype.impl.DiscountPercentageImpl;

/**
 * @author b.singh
 *
 */
public class EmployeeDiscount extends DiscountPercentageImpl {
	private static final double DISCOUNT = 0.3;

	public EmployeeDiscount() {
		super(DISCOUNT);
	}

}

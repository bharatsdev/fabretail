/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountByPercentage;

/**
 * @author b.singh
 *
 */
public class EmployeeDiscount extends DiscountByPercentage {
	private static final double DISCOUNT = 0.3;

	public EmployeeDiscount() {
		super(DISCOUNT);
	}

}

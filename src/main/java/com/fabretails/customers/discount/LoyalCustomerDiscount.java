/**
 * 
 */
package com.fabretails.customers.discount;

import com.fabretails.discounts.impl.DiscountByPercentage;

/**
 * This class will help in giving the discount to customer if he is
 * LoyalCustomer
 * 
 * @author b.singh
 *
 */
public class LoyalCustomerDiscount extends DiscountByPercentage {

	private static final double DISCOUNT = 0.05;

	public LoyalCustomerDiscount() {
		super(DISCOUNT);
	}

}

/**
 * 
 */
package com.fabretails.discounts.impl;

import com.fabretails.discounts.Discount;

/**
 * @author b.singh
 *
 */
public class DiscountByPercentage implements Discount {

	protected final double discountByPercentage;

	protected DiscountByPercentage(double discount) {
		this.discountByPercentage = discount;
		System.out.println(this.discountByPercentage);
	}

	/**
	 * add percentage discount on final bill and return net bill amount
	 */
	@Override
	public double calculateDiscount(double amount) {
		return amount -= (amount * discountByPercentage);
	}

	public double getDiscountByPercentage() {
		return discountByPercentage;
	}

}

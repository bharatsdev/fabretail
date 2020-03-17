/**
 * 
 */
package com.fabretails.discounts.impl;

/**
 * @author b.singh
 *
 */
public class DiscountByPercentage implements Discount {

	protected final double discountByPercentage;

	protected DiscountByPercentage(double discount) {
		this.discountByPercentage = discount;
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

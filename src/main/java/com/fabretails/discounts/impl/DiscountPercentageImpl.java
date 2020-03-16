/**
 * 
 */
package com.fabretails.discounts.impl;

import com.fabretails.discounts.Discount;

/**
 * @author b.singh
 *
 */
public class DiscountPercentageImpl implements Discount {

	protected final double discountPercentage;

	protected DiscountPercentageImpl(double discount) {
		this.discountPercentage = discount;
	}

	@Override
	public double calculateDiscount(double amount) {
		return amount -= (amount * discountPercentage);
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

}

/**
 * 
 */
package com.fabretails.discounttype.impl;

import com.fabretails.discounttype.Discount;

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

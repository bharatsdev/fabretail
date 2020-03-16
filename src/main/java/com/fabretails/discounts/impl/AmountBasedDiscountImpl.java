/**
 * 
 */
package com.fabretails.discounts.impl;

import com.fabretails.discounts.Discount;

/**
 * @author b.singh
 *
 */
public class AmountBasedDiscountImpl implements Discount {

	private double amountBasedDiscount;

	@Override
	public double calculateDiscount(double amount) {
		this.amountBasedDiscount = (((amount - (amount % 100)) / 100)) * 5;
		return amount -= this.amountBasedDiscount;
	}

	public double getAmountBasedDiscount() {
		return amountBasedDiscount;
	}

}

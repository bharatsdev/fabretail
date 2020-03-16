/**
 * 
 */
package com.fabretails.discounts.impl;

import com.fabretails.discounts.Discount;

/**
 * This Class help in calculation of bill amount after giving the amount
 * discount on bill
 * 
 * @author b.singh
 *
 */
public class DiscountByAmount implements Discount {

	private double discountAmount;

	/**
	 * Return bill amount after giving fix amount disccount of bill
	 */
	@Override
	public double calculateDiscount(double amount) {
		this.discountAmount = (((amount - (amount % 100)) / 100)) * 5;
		amount -= this.discountAmount;
		return amount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}
}

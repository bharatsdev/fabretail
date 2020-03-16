/**
 * 
 */
package com.fabretails.discounts.impl;

import com.fabretails.discounts.Discount;

import lombok.Getter;
import lombok.Setter;

/**
 * @author b.singh
 *
 */
public class DiscountByAmount implements Discount {

	private double discountAmount;

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

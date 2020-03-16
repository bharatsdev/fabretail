/**
 * 
 */
package com.fabretails.bill;

import java.util.stream.Collectors;

import com.fabretails.customers.AffilateCustomer;
import com.fabretails.customers.Customer;
import com.fabretails.customers.EmployeeCustomer;
import com.fabretails.customers.discount.AffiliateCustomerDiscount;
import com.fabretails.customers.discount.EmployeeDiscount;
import com.fabretails.customers.discount.LoyalCustomerDiscount;
import com.fabretails.customers.discount.ZeroPercentageDiscount;
import com.fabretails.discounts.Discount;
import com.fabretails.discounts.impl.DiscountByAmount;
import com.fabretails.discounts.impl.DiscountByPercentage;
import com.fabretails.products.Product;
import com.fabretails.products.impl.NonGrocery;

/**
 * This class will help in calculating the final bill amount
 * 
 * @author b.singh
 *
 */
public class CalculateDiscount {

	public CalculateDiscount() {
	}

	private static class SingletonInstance {
		private static final CalculateDiscount INSTANCE = new CalculateDiscount();

	}

	public static CalculateDiscount getInstance() {
		return SingletonInstance.INSTANCE;
	}

	@SuppressWarnings("unused")
	Discount getCustomerBasedDiscount(Customer customer) {
		DiscountByPercentage discountPercentage = null;
		if (customer instanceof Customer) {
			if (customer.getTotalYears() > 2) {
				LoyalCustomerDiscount loyalCustomerDiscount = new LoyalCustomerDiscount();

				if (discountPercentage == null) {
					discountPercentage = loyalCustomerDiscount;
				} else if (loyalCustomerDiscount.getDiscountByPercentage() > discountPercentage
						.getDiscountByPercentage()) {
					discountPercentage = loyalCustomerDiscount;
				}
			} else {
				discountPercentage = new ZeroPercentageDiscount();
			}
		}
		if (customer instanceof EmployeeCustomer) {
			discountPercentage = new EmployeeDiscount();
		}

		if (customer instanceof AffilateCustomer) {
			AffiliateCustomerDiscount affiliateUserDiscount = new AffiliateCustomerDiscount();
			if (discountPercentage == null) {
				discountPercentage = affiliateUserDiscount;
			} else if (affiliateUserDiscount.getDiscountByPercentage() > discountPercentage.getDiscountByPercentage()) {
				discountPercentage = affiliateUserDiscount;
			}

		}
		return discountPercentage;
	}

	public double calculateNetAmountOnBill(BillAmount bill) {
		proceessBillTotal(bill);
		applyPercentageDiscount(bill);
		applyDiscountOverFinalBill(bill);
		return 0;
	}

	/**
	 * Calculate total bill amount of order
	 * 
	 * @param bill
	 */

	private void proceessBillTotal(BillAmount bill) {
		double netBillAmount = bill.getProductCataglogs().stream()
				.collect(Collectors.summingDouble(Product::getProductAmount));
		bill.setNetAmount(netBillAmount);
	}

	/**
	 * This method will check the type of product and calculate discount amount like
	 * grocery don't have any discount
	 * 
	 * @param bill
	 */
	private void applyPercentageDiscount(BillAmount bill) {
		Discount discount = getCustomerBasedDiscount(bill.getCustomer());
		double discountedBill = 0;
		for (Product product : bill.getProductCataglogs()) {
			if (product instanceof NonGrocery) {
				discountedBill += discount.calculateDiscount(product.getProductAmount());
			} else {
				discountedBill += product.getProductAmount();
			}
		}
		bill.setAmountAfterDiscount(discountedBill);

	}

	public void applyDiscountOverFinalBill(BillAmount bill) {

		Discount discount = new DiscountByAmount();
		bill.setAmountAfterDiscount(discount.calculateDiscount(bill.getAmountAfterDiscount()));

	}
}

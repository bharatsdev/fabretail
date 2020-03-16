/**
 * 
 */
package com.fabretails.bill;

import com.fabretails.customers.AffilateCustomer;
import com.fabretails.customers.Customer;
import com.fabretails.customers.EmployeeCustomer;
import com.fabretails.customers.discount.AffiliateUserDiscount;
import com.fabretails.customers.discount.EmployeeDiscount;
import com.fabretails.customers.discount.LoyalCustomerDiscount;
import com.fabretails.customers.discount.ZeroPercentageDiscount;
import com.fabretails.discounts.Discount;
import com.fabretails.discounts.impl.AmountBasedDiscountImpl;
import com.fabretails.discounts.impl.DiscountPercentageImpl;
import com.fabretails.products.Product;
import com.fabretails.products.impl.NonGrocery;

/**
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
	Discount getCustomerBasedDiscount(Customer c) {
		 DiscountPercentageImpl discountPercentage = null;
		if (c instanceof Customer) {

			if (c.getTotalNoOfYears() > 2) {
				LoyalCustomerDiscount loyalCustomerDiscount = new LoyalCustomerDiscount();

				if (discountPercentage == null) {
					discountPercentage = loyalCustomerDiscount;
				} else if (loyalCustomerDiscount.getDiscountPercentage() > discountPercentage.getDiscountPercentage()) {
					discountPercentage = loyalCustomerDiscount;
				}
			} else {
				discountPercentage = new ZeroPercentageDiscount();
			}
		}
		if (c instanceof EmployeeCustomer) {
			discountPercentage = new EmployeeDiscount();
		}

		if (c instanceof AffilateCustomer) {
			AffiliateUserDiscount affiliateUserDiscount = new AffiliateUserDiscount();
			if (discountPercentage == null) {
				discountPercentage = affiliateUserDiscount;
			} else if (affiliateUserDiscount.getDiscountPercentage() > discountPercentage.getDiscountPercentage()) {
				discountPercentage = affiliateUserDiscount;
			}

		}
		return discountPercentage;
	}

	public double processFinalAmountOnBill(Bill bill) {

		proceessBillTotal(bill);

		applyPercentageDiscount(bill);
		applyDiscountOverFinalBill(bill);

		return 0;
	}

	private void proceessBillTotal(Bill bill) {
		double netBillAmount = 0;
		for (Product product : bill.getProductCataglogs()) {
			netBillAmount += product.getProductAmount();
		}
		bill.setTotalAmount(netBillAmount);
	}

	private void applyPercentageDiscount(Bill bill) {
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

	public void applyDiscountOverFinalBill(Bill bill) {

		Discount discount = new AmountBasedDiscountImpl();
		bill.setAmountAfterDiscount(discount.calculateDiscount(bill.getAmountAfterDiscount()));

	}
}

/**
 * 
 */
package com.fabretails.bill;

import com.fabretails.discounttype.Discount;
import com.fabretails.discounttype.impl.AmountBasedDiscountImpl;
import com.fabretails.discounttype.impl.DiscountPercentageImpl;
import com.fabretails.item.Item;
import com.fabretails.item.ItemNonGrocery;
import com.fabretails.users.AffilateCustomer;
import com.fabretails.users.Customer;
import com.fabretails.users.EmployeeCustomer;
import com.fabretails.users.discount.AffiliateUserDiscount;
import com.fabretails.users.discount.EmployeeDiscount;
import com.fabretails.users.discount.LoyalCustomerDiscount;
import com.fabretails.users.discount.ZeroPercentageDiscount;

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

	private void netAmountOnBill(FinalBill bill) {

	}

	Discount getCustomerBaseDiscount(Customer c) {
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

	public double processFinalAmountOnBill(FinalBill bill) {

		proceessBillTotal(bill);

		prcoessPercentageDiscountOverBillItems(bill);
		prcoessDiscountOverTotal(bill);

		return 0;
	}

	private void proceessBillTotal(FinalBill bill) {
		double netBillAmount = 0;
		for (Item item : bill.getItemCatalogs()) {
			netBillAmount += item.getItemAmount();
		}
		bill.setTotalAmount(netBillAmount);
	}

	private void prcoessPercentageDiscountOverBillItems(FinalBill bill) {
		Discount discount = getCustomerBaseDiscount(bill.getCustomer());
		double discountedBill = 0;
		for (Item p : bill.getItemCatalogs()) {
			if (p instanceof ItemNonGrocery) {
				discountedBill += discount.calculateDiscount(p.getItemAmount());
			} else {
				discountedBill += p.getItemAmount();
			}
		}
		bill.setAmountAfterDiscount(discountedBill);

	}

	public void prcoessDiscountOverTotal(FinalBill bill) {

		Discount discount = new AmountBasedDiscountImpl();
		bill.setAmountAfterDiscount(discount.calculateDiscount(bill.getAmountAfterDiscount()));

	}
}

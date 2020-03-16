package com.fabretails.bill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fabretails.customers.Customer;
import com.fabretails.customers.EmployeeCustomer;
import com.fabretails.customers.discount.EmployeeDiscount;
import com.fabretails.products.impl.Grocery;
import com.fabretails.products.impl.NonGrocery;

public class CalculateDiscountTest {
	CalculateDiscount calculateDiscount;
	Customer customer;
	BillAmount billAmount;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void testFetchEmployeeDiscount() {
		createBillObject();
		calculateDiscount = CalculateDiscount.getInstance();
		customer = new EmployeeCustomer();
		EmployeeDiscount employeeDiscount = (EmployeeDiscount) calculateDiscount.getCustomerBasedDiscount(customer);

		assertEquals(new Double(new EmployeeDiscount().getDiscountByPercentage()),
				new Double(employeeDiscount.getDiscountByPercentage()));
	}

	@Test
	public void testFinalBillAmountForNonGroceris() {
		createBillObject();
		calculateDiscount = CalculateDiscount.getInstance();
		billAmount = new BillAmount(new EmployeeCustomer());

		NonGrocery g1 = new NonGrocery();
		g1.setProductAmount(500);

		NonGrocery g2 = new NonGrocery();
		g2.setProductAmount(500);

		billAmount.addProductCatalog(g1);
		billAmount.addProductCatalog(g2);

		calculateDiscount.calculateNetAmountOnBill(billAmount);
		assertEquals(new Double(billAmount.getNetAmount()), new Double(1000.00));
		assertEquals(new Double(billAmount.getAmountAfterDiscount()), new Double(665.00));

	}

	private void createBillObject() {
		billAmount = new BillAmount(new EmployeeCustomer());
		NonGrocery nonGrocery = new NonGrocery();
		nonGrocery.setProductAmount(200);
		nonGrocery.setProductName("Pant");

		Grocery grocery = new Grocery();
		grocery.setProductAmount(200);
		grocery.setProductName("Rice");

		billAmount.addProductCatalog(nonGrocery);
		billAmount.addProductCatalog(grocery);
	}

}

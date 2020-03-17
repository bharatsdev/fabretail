package com.fabretails.bill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fabretails.customers.AffilateCustomer;
import com.fabretails.customers.Customer;
import com.fabretails.customers.EmployeeCustomer;
import com.fabretails.products.impl.Grocery;
import com.fabretails.products.impl.NonGrocery;
import com.fabretails.products.impl.Product;
import com.fabretails.utils.ProductType;

public class BillAmountTest {
	BillAmount bill;

	@Before
	public void setUp() throws Exception {
		Customer customer = new Customer();
		bill = new BillAmount(customer);
	}

	@Test
	public void testAddItemInCatalog() {
		bill.addProductCatalog(productObject(ProductType.GROCERY.name()));
		bill.addProductCatalog(productObject(ProductType.NON_GROCERY.name()));
		assertEquals(2, bill.getProductCataglogs().size());
	}

	@Test
	public void testProcessDiscountOnBillTest() {

		bill.addProductCatalog(productObject(ProductType.GROCERY.name()));
		bill.addProductCatalog(productObject(ProductType.NON_GROCERY.name()));

		bill.processDiscountOnBill();

		assertEquals(new Double(190), new Double(bill.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(bill.getNetAmount()));
	}

	@Test
	public void testProcessDiscountOnBillByEmploye() {

		// bill.addProductCatalog(productObject(ProductType.GROCERY.name()));
		bill.addProductCatalog(productObject(ProductType.NON_GROCERY.name()));
		bill.setCustomer(new EmployeeCustomer());

		bill.processDiscountOnBill();

		assertEquals(new Double(70), new Double(bill.getAmountAfterDiscount()));
		assertEquals(new Double(100), new Double(bill.getNetAmount()));
	}

	@Test
	public void testApplyDiscountOnBillTestForEmployee() {
		bill.setCustomer(new EmployeeCustomer());
		bill.addProductCatalog(productObject(ProductType.GROCERY.name()));
		bill.addProductCatalog(productObject(ProductType.NON_GROCERY.name()));
		bill.processDiscountOnBill();
		assertEquals(new Double(165), new Double(bill.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(bill.getNetAmount()));
	}

	@Test
	public void testApplyDiscountOnBillTestForAffiliateCustomer() {
		bill.setCustomer(new AffilateCustomer());
		bill.addProductCatalog(productObject(ProductType.GROCERY.name()));
		bill.addProductCatalog(productObject(ProductType.NON_GROCERY.name()));
		bill.processDiscountOnBill();
		assertEquals(new Double(185), new Double(bill.getAmountAfterDiscount()));
		assertEquals(new Double(200), new Double(bill.getNetAmount()));
	}

	private Product productObject(String val) {
		Product grocery = null;
		if (val.equals(ProductType.GROCERY.name())) {
			grocery = new Grocery(ProductType.GROCERY.name(), 100);
			return grocery;
		} else {
			grocery = new NonGrocery(ProductType.GROCERY.name(), 100);
			return grocery;
		}

	}

}

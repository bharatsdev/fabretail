package com.fabretails.customers.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeDiscountTest {

	EmployeeDiscount employeeDiscount;

	@Before
	public void setup() {
		employeeDiscount = new EmployeeDiscount();
	}

	@Test
	public void testEmployeeDiscount() {
		assertEquals(new Double(70.00), new Double(employeeDiscount.calculateDiscount(100)));
	}

}

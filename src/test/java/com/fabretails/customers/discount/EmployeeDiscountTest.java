package com.fabretails.customers.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeDiscountTest {

	EmployeeDiscount employeeDiscount;

	@BeforeEach
	public void setup() {
		employeeDiscount = new EmployeeDiscount();
	}

	@Test
	public void testEmployeeDiscount() {
		assertEquals(new Double(70.00), new Double(employeeDiscount.calculateDiscount(100)));
	}

}

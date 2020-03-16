
package com.fabretails;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fabretails.bill.BillAmountTest;
import com.fabretails.bill.CalculateDiscountTest;
import com.fabretails.customers.CustomerTest;
import com.fabretails.customers.discount.AffiliateUserDiscountTest;
import com.fabretails.customers.discount.EmployeeDiscountTest;
import com.fabretails.customers.discount.LoyalCustomerDiscountTest;
import com.fabretails.discounts.impl.DiscountByAmountTest;

@RunWith(Suite.class)
@SuiteClasses({ BillAmountTest.class, CalculateDiscountTest.class, DiscountByAmountTest.class,
		DiscountByAmountTest.class, AffiliateUserDiscountTest.class, EmployeeDiscountTest.class,
		LoyalCustomerDiscountTest.class, CustomerTest.class })
public class AllTests {

}

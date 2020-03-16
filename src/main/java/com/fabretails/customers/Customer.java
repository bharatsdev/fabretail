package com.fabretails.customers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This class will handle all he customer type
 * 
 * @author b.singh
 *
 */
public class Customer {
	// Customer Registration date
	LocalDate customerRegistrationDate;

	public Customer() {
		this.customerRegistrationDate = LocalDate.now();
	}

	/**
	 * Get Total number of years, which customer spend with retails store. It will
	 * used for checking the loyal customer
	 * 
	 * @return
	 */
	public int getTotalYears() {
		return LocalDate.now().getYear() - this.customerRegistrationDate.getYear();

	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.UK);
		cal.setTime(date);
		return cal;
	}

	public LocalDate getCustomerRegistrationDate() {
		return customerRegistrationDate;
	}

	public void setCustomerRegistrationDate(LocalDate customerRegistrationDate) {
		this.customerRegistrationDate = customerRegistrationDate;
	}

}

package com.fabretails.users;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Customer {
	LocalDate customerRegistrationDate;

	public Customer() {
		this.customerRegistrationDate = LocalDate.now();
	}

	public int getTotalNoOfYears() {
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

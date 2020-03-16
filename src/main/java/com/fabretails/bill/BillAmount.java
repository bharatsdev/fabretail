package com.fabretails.bill;

import java.util.ArrayList;
import java.util.List;

import com.fabretails.customers.Customer;
import com.fabretails.products.Product;

public class BillAmount {
	private List<Product> productCataglogs = new ArrayList<>();

	CalculateDiscount calculateDiscount;

	private Customer customer;

	private double netAmount;
	private double amountAfterDiscount;

	public BillAmount(Customer customer) {
		super();
		this.customer = customer;
		this.calculateDiscount = CalculateDiscount.getInstance();
	}

	public void addProductCatalog(Product product) {
		productCataglogs.add(product);
	}

	public void processDiscountOnBill() {
		calculateDiscount.calculateNetAmountOnBill(this);
	}

	public List<Product> getProductCataglogs() {
		return productCataglogs;
	}

	public void setProductCataglogs(List<Product> productCataglogs) {
		this.productCataglogs = productCataglogs;
	}

	public CalculateDiscount getCalculateDiscount() {
		return calculateDiscount;
	}

	public void setCalculateDiscount(CalculateDiscount calculateDiscount) {
		this.calculateDiscount = calculateDiscount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}

	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}

}

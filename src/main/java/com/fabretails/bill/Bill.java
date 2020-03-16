package com.fabretails.bill;

import java.util.ArrayList;
import java.util.List;

import com.fabretails.customers.Customer;
import com.fabretails.products.Product;

public class Bill {
	private List<Product> productCataglogs = new ArrayList<>();

	CalculateDiscount calculateDiscount;

	private Customer customer;

	private double totalAmount;
	private double amountAfterDiscount;

	public Bill(Customer customer) {
		super();
		this.customer = customer;
		this.calculateDiscount = CalculateDiscount.getInstance();
	}

	public void addProductCatalog(Product product) {
		productCataglogs.add(product);
	}

	public void processDiscountOnBill() {
		calculateDiscount.processFinalAmountOnBill(this);
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}

	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}

}

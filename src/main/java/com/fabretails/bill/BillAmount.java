package com.fabretails.bill;

import java.util.ArrayList;
import java.util.List;

import com.fabretails.customers.Customer;
import com.fabretails.products.impl.Product;

import lombok.ToString;

@ToString
public class BillAmount {
	private List<Product> productCataglogs = new ArrayList<>();

	private NetBillAmountProcessor netBillAmountProcessor;

	private Customer customer;

	private double netAmount;
	private double amountAfterDiscount;

	public BillAmount(Customer customer) {
		super();
		this.customer = customer;
		this.netBillAmountProcessor = NetBillAmountProcessor.getInstance();
	}

	public void addProductCatalog(Product product) {
		productCataglogs.add(product);
	}

	public void processDiscountOnBill() {
		netBillAmountProcessor.calculateNetAmountOnBill(this);
	}

	public List<Product> getProductCataglogs() {
		return productCataglogs;
	}

	public void setProductCataglogs(List<Product> productCataglogs) {
		this.productCataglogs = productCataglogs;
	}

	public NetBillAmountProcessor getNetBillAmountProcessor() {
		return netBillAmountProcessor;
	}

	public void setNetBillAmountProcessor(NetBillAmountProcessor netBillAmountProcessor) {
		this.netBillAmountProcessor = netBillAmountProcessor;
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

package com.fabretails.bill;

import java.util.ArrayList;
import java.util.List;

import com.fabretails.item.Item;
import com.fabretails.users.Customer;

public class FinalBill {
	private List<Item> itemCatalogs = new ArrayList<>();

	CalculateDiscount calculateDiscount;

	private Customer customer;

	private double totalAmount;
	private double amountAfterDiscount;

	public FinalBill(Customer customer) {
		super();
		this.customer = customer;
		this.calculateDiscount = CalculateDiscount.getInstance();
	}

	public void addItemCatalog(Item item) {
		itemCatalogs.add(item);
	}

	public void processDiscountOnBill() {
		calculateDiscount.processFinalAmountOnBill(this);
	}

	public List<Item> getItemCatalogs() {
		return itemCatalogs;
	}

	public void setItemCatalogs(List<Item> itemCatalogs) {
		this.itemCatalogs = itemCatalogs;
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

package com.ecommerce.model;

public class Payment {
	
	 private int paymentId;
	 private Order order;
	 private double amount;
	 
	public Payment(int paymentId, Order order, double amount) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	 
	 

}

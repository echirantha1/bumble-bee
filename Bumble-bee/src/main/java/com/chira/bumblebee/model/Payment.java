package com.chira.bumblebee.model;

public class Payment {
	
	private int paymentId;
	private int productId;
	private int customerId;
	private int soldAmount;

	public Payment(int paymentId, int productId, int customerId, int soldAmount) {
		this.paymentId = paymentId;
		this.productId = productId;
		this.customerId = customerId;
		this.soldAmount = soldAmount;
	}
	
	public Payment(int productId, int customerId, int soldAmount) {
		this.productId = productId;
		this.customerId = customerId;
		this.soldAmount = soldAmount;
	}

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(int soldAmount) {
		this.soldAmount = soldAmount;
	}

}

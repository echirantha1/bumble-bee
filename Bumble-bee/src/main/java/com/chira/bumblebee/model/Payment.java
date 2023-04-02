package com.chira.bumblebee.model;

import java.sql.Date;

public class Payment {
	
	private int paymentId;
	private int productId;
	private int customerId;
	private int soldAmount;
	private Date date;

	public Payment(int paymentId, int productId, int customerId, int soldAmount, Date date) {
		this.paymentId = paymentId;
		this.productId = productId;
		this.customerId = customerId;
		this.soldAmount = soldAmount;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

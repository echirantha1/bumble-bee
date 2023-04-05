package com.chira.bumblebee.model;

public class Loan {
	
	private int loanId;
	private int productId;
	private double amount;
	private String installments;
	private String interest;
	private int customerId;
	
	public Loan(int loanId, int productId, double amount, String installments, String interest, int customerId) {
		this.loanId = loanId;
		this.productId = productId;
		this.amount = amount;
		this.installments = installments;
		this.interest = interest;
		this.customerId = customerId;
	}

	public Loan(int productId, double amount, String installments, String interest, int customerId) {
		this.productId = productId;
		this.amount = amount;
		this.installments = installments;
		this.interest = interest;
		this.customerId = customerId;
	}
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getInstallments() {
		return installments;
	}

	public void setInstallments(String installments) {
		this.installments = installments;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}

package com.chira.bumblebee.model;

import java.util.Date;

public class Customer {

	private int customerId;
	private String nic;
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobile;
	private int loanId;
	private Date date;
	
	public Customer(int customerId, String nic, String name, String email, String password, String address,
			String mobile, int loanId, Date date) {
		this.customerId = customerId;
		this.nic = nic;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.loanId = loanId;
		this.date = date;
	}
	
	public Customer() {
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}

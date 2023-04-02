package com.chira.bumblebee.model;

import java.sql.Date;

public class Brand {
	
	private int brandId;
	private String brandName;
	private Date date;

	public Brand(int brandId, String brandName, Date date) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.date = date;
	}

	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

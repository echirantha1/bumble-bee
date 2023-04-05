package com.chira.bumblebee.model;

public class Brand {
	
	private int brandId;
	private String brandName;

	public Brand(int brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}
	
	public Brand(String brandName) {
		this.brandName = brandName;
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

}

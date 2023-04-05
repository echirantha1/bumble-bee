package com.chira.bumblebee.model;

public class Product {

	private int productId;
	private String productName;
	private int categoryId;
	private int brandId;
	private int quantity;
	private double productPrice;
	private String description;

	public Product(int productId, String productName, int categoryId, int brandId, int quantity, double productPrice,
			String description) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.description = description;
	}
	
	public Product(String productName, int categoryId, int brandId, int quantity, double productPrice,
			String description) {
		this.productName = productName;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.description = description;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCagetoryId() {
		return categoryId;
	}

	public void setCagetoryId(int cagetoryId) {
		this.categoryId = cagetoryId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}

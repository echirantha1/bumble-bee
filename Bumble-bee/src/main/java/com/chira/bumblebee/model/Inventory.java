package com.chira.bumblebee.model;

import java.sql.Date;

public class Inventory {
	
	private int inventoryId;
	private int productId;
	private int availableStock;
	private int soldAmount;
	private Date date;

	public Inventory(int inventoryId, int productId, int availableStock, int soldAmount, Date date) {
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.availableStock = availableStock;
		this.soldAmount = soldAmount;
		this.date = date;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
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

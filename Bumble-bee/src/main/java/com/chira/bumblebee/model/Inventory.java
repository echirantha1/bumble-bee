package com.chira.bumblebee.model;

public class Inventory {
	
	private int inventoryId;
	private int productId;
	private int availableStock;
	private int soldAmount;

	public Inventory(int inventoryId, int productId, int availableStock, int soldAmount) {
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.availableStock = availableStock;
		this.soldAmount = soldAmount;
	}

	public Inventory(int productId, int availableStock, int soldAmount) {
		this.productId = productId;
		this.availableStock = availableStock;
		this.soldAmount = soldAmount;
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

}

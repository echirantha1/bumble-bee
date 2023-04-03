package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.dao.InventoryManager;
import com.chira.bumblebee.model.Inventory;

public class InventoryService {
	
	private static InventoryService inventoryServiceObj;

	public InventoryService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized InventoryService getInventoryServiceInstance() {
		
		if(inventoryServiceObj == null) {
			
			inventoryServiceObj = new InventoryService();
			
		}
		return inventoryServiceObj;
		
	}
	
	private InventoryManager getInventoryManager() {
		return new InventoryManager();
	}
	
	public boolean registerStock(Inventory inventory) throws ClassNotFoundException, SQLException {
		return getInventoryManager().addStock(inventory);
	}
	
	public Inventory getSpecificStock(int inventoryId) throws ClassNotFoundException, SQLException {
		return getInventoryManager().getSpecificStock(inventoryId);
	}
	
	public List<Inventory> getAllStocks() throws ClassNotFoundException, SQLException {
		return getInventoryManager().getAllStocks();
	}
	
	public boolean editStock(Inventory inventory) throws ClassNotFoundException, SQLException {
		return getInventoryManager().updateStock(inventory);
	}
	
	public boolean deleteTheStock(int inventoryId) throws ClassNotFoundException, SQLException {
		return getInventoryManager().deleteStock(inventoryId);
	}

}

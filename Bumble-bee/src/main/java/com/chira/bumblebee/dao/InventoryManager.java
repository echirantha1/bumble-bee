package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Inventory;

public class InventoryManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addStock(Inventory stock) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO inventory (productId, availableStock, soldAmount) VALUES ( ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, stock.getProductId());
		ps.setInt(2, stock.getAvailableStock());
		ps.setInt(3, stock.getSoldAmount());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Inventory getSpecificStock (int inventoryId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM inventory WHERE inventoryId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, inventoryId);
		
		ResultSet rs = ps.executeQuery();
		Inventory stock = new Inventory();
		
		while(rs.next()) {
			stock.setInventoryId(rs.getInt("inventoryId"));
			stock.setProductId(rs.getInt("productId"));
			stock.setAvailableStock(rs.getInt("availableStock"));
			stock.setSoldAmount(rs.getInt("soldAmount"));
			stock.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return stock;
	}
	
	public List<Inventory> getAllStocks() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM inventory";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Inventory> stockList = new ArrayList<Inventory>();
		
		while(rs.next()) {
			Inventory stock = new Inventory();
			stock.setInventoryId(rs.getInt("inventoryId"));
			stock.setProductId(rs.getInt("productId"));
			stock.setAvailableStock(rs.getInt("availableStock"));
			stock.setSoldAmount(rs.getInt("soldAmount"));
			stock.setDate(rs.getDate("date"));
			
			stockList.add(stock);
		}
		
		st.close();
		connection.close();
		return stockList;
	}
	
	public boolean updateStock(Inventory stock) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE inventory SET productId = ?, availableStock = ?, soldAmount = ? WHERE inventoryId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, stock.getProductId());
		ps.setInt(2, stock.getAvailableStock());
		ps.setInt(3, stock.getSoldAmount());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteStock(int inventoryId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM inventory WHERE inventoryId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, inventoryId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

}

package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Product;

public class ProductManger {
	
	public DbConnector getDbConnector() {
		
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();	
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO product (productName, categoryId, brandId, quantity, productPrice, description) VALUES ( ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getCagetoryId());
		ps.setInt(3, product.getBrandId());
		ps.setInt(4, product.getQuantity());
		ps.setDouble(5, product.getProductPrice());
		ps.setString(6, product.getDescription());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Product  getSpecificProduct (int prodcutId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM product WHERE prodcutId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, prodcutId);
		
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		
		while(rs.next()) {
			product.setProdcutId(rs.getInt("prodcutId"));
			product.setProductName(rs.getString("productName"));
			product.setCagetoryId(rs.getInt("categoryId"));
			product.setBrandId(rs.getInt("brandId"));
			product.setQuantity(rs.getInt("quantity"));
			product.setProductPrice(rs.getDouble("productPrice"));
			product.setDescription(rs.getString("description"));
			product.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return product;
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM product";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Product> productList = new ArrayList<Product>();
		
		while(rs.next()) {
			Product product = new Product();
			product.setProdcutId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setCagetoryId(rs.getInt("categoryId"));
			product.setBrandId(rs.getInt("brandId"));
			product.setQuantity(rs.getInt("quantity"));
			product.setProductPrice(rs.getDouble("productPrice"));
			product.setDescription(rs.getString("description"));
			product.setDate(rs.getDate("date"));
			
			productList.add(product);
		}
		
		st.close();
		connection.close();
		return productList;
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE product SET productName = ?, categoryId = ?, brandId = ?, quantity = ?, productPrice = ?, description = ? WHERE productId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getProductName());
		ps.setInt(2, product.getCagetoryId());
		ps.setInt(3, product.getBrandId());
		ps.setInt(4, product.getQuantity());
		ps.setDouble(5, product.getProductPrice());
		ps.setString(6, product.getDescription());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteProduct(int prodcutId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM product WHERE productId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, prodcutId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
}

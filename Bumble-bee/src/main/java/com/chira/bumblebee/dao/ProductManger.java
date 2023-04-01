package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Product;

public class ProductManger {
	
	public DbConnector getDbConnector() {
		
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();	
	}
	
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = getDbConnector();
		Connection connection = connector.getDbConnection();
		return false;
		
	}
	
	public Product  getSpecificProduct (int id) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = getDbConnector();
		Connection connection = connector.getDbConnection();
		return new Product();
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		Connection connection = connector.getDbConnection();
		return new ArrayList<Product>();
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		Connection connection = connector.getDbConnection();
		return false;
	}
	
	public boolean deleteProduct(int id) throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		Connection connection = connector.getDbConnection();
		return false;
	}
}

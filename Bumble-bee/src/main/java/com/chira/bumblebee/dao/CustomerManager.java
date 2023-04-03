package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Customer;

public class CustomerManager {
	
	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO customer (nic, name, email, password, address, mobile) VALUES ( ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customer.getNic());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getEmail());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getAddress());
		ps.setString(6, customer.getMobile());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Customer getSpecificCustomer (int customerId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM customer WHERE customerId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customerId);
		
		ResultSet rs = ps.executeQuery();
		Customer customer = new Customer();
		
		while(rs.next()) {
			customer.setCustomerId(rs.getInt("customerId"));
			customer.setNic(rs.getString("nic"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
			customer.setAddress(rs.getString("address"));
			customer.setMobile(rs.getString("mobile"));
			customer.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return customer;
	}
	
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM customer";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customerId"));
			customer.setNic(rs.getString("nic"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
			customer.setAddress(rs.getString("address"));
			customer.setMobile(rs.getString("mobile"));
			customer.setDate(rs.getDate("date"));
			
			customerList.add(customer);
		}
		
		st.close();
		connection.close();
		return customerList;
	}
	
	public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE customer SET nic = ?, name = ?, email = ?, password = ?, address = ?, mobile = ? WHERE customerId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customer.getNic());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getEmail());
		ps.setString(4, customer.getPassword());
		ps.setString(5, customer.getAddress());
		ps.setString(6, customer.getMobile());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteCustomer(int customerId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM customer WHERE customerId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customerId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

}

package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chira.bumblebee.model.Customer;

public class CustomerManager {
		
		

		private static final String INSERT_USERS_SQL = "INSERT INTO customer" + "(address,email,mobile,name,nic,password) VALUES" + "(?,?,?,?,?,?) ";

		public CustomerManager() {
		}

		

		public void insertCustomer(Customer customer) throws SQLException, ClassNotFoundException {
			
			DbConnector connector = new MySqlConnectorImpl();
			
			System.out.println(INSERT_USERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = connector.getDbConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, customer.getAddress());
				preparedStatement.setString(2, customer.getEmail());
				preparedStatement.setString(3, customer.getMobile());
				preparedStatement.setString(4, customer.getName());
				preparedStatement.setString(5, customer.getNic());
				preparedStatement.setString(6, customer.getPassword());
				
			
				System.out.println(preparedStatement);
				int done = preparedStatement.executeUpdate();
				System.out.println(done);
				
			} catch (SQLException e) {
				printSQLException(e);
			}
		}

		private void printSQLException(SQLException e) {
			// TODO Auto-generated method stub
			
		}
		
		
	
}

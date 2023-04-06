package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chira.bumblebee.model.Admin;

public class AdminManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	
	public Admin getSpecificAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		Admin admin = null;
		
		String query = "SELECT * FROM admin WHERE email = ? AND password = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
	
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			admin = new Admin();
			admin.setEmail(rs.getString("email"));
		}
		
		ps.close();
		connection.close();
		
		return admin;
	}

}

package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public Admin getSpecificAdmin (int adminId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM admin WHERE adminId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, adminId);
		
		ResultSet rs = ps.executeQuery();
		Admin admin = new Admin();
		
		while(rs.next()) {
			admin.setAdminId(rs.getInt("adminId"));
			admin.setEmail(rs.getString("email"));
			admin.setPassword(rs.getString("password"));
		}
		
		ps.close();
		connection.close();
		
		return admin;
	}
	
	public List<Admin> getAllAdmins() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM admin";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Admin> adminList = new ArrayList<Admin>();
		
		while(rs.next()) {
			Admin admin = new Admin();
			admin.setAdminId(rs.getInt("adminId"));
			admin.setEmail(rs.getString("email"));
			admin.setPassword(rs.getString("password"));
			
			adminList.add(admin);
		}
		
		st.close();
		connection.close();
		return adminList;
	}

}

package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Brand;

public class BrandManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO brand (brandName) VALUES ( ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getBrandName());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Brand getSpecificBrand (int brandId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM brand WHERE brandId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brandId);
		
		ResultSet rs = ps.executeQuery();
		Brand brand = new Brand();
		
		while(rs.next()) {
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return brand;
	}
	
	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM brand";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Brand> brandList = new ArrayList<Brand>();
		
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setDate(rs.getDate("date"));
			
			brandList.add(brand);
		}
		
		st.close();
		connection.close();
		return brandList;
	}
	
	public boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE brand SET brandName = ? WHERE brandId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getBrandName());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteBrand(int brandId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM brand WHERE brandId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brandId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

}

package com.chira.bumblebee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testclass {

	public testclass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {    
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bumblebee","root","pabasaraEK@1");    
			String query="SELECT * FROM product";    
			Statement st=connection.createStatement();    
			ResultSet rs=st.executeQuery(query);   
			System.out.println(rs.getString("productName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}    

		
	}

}

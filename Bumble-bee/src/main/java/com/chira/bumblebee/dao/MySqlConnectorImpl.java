package com.chira.bumblebee.dao;

import java.sql.*;

public class MySqlConnectorImpl implements DbConnector  {

	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		 String url = "jdbc:mysql://localhost:3306/loandb";
		 String username = "root";
		 String password = "pabasaraek1";
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;		
	}

}

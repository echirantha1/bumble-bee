package com.chira.bumblebee.dao;

public class MySqlDbConnectorFactoryImpl implements DbConnectorFactory{

	@Override
	public DbConnector getDbConnector() {

		return new MySqlConnectorImpl();
	}
	
}

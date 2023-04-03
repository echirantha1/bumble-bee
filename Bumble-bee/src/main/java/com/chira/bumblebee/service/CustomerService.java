package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.dao.CustomerManager;
import com.chira.bumblebee.model.Customer;

public class CustomerService {
	
	private static CustomerService customerServiceObj;
	
	private CustomerService() {
		
	}
	
	public static synchronized CustomerService getCustomerServiceInstance() {
		if(customerServiceObj == null) {
			customerServiceObj = new CustomerService();
		}
		return customerServiceObj;
	}
	
	private CustomerManager getCustomerManager() {
		return new CustomerManager();
	}
	
	public boolean registerCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().addCustomer(customer);
	}
	
	public Customer getSpecificCustomer(int customerId) throws ClassNotFoundException, SQLException {
		return getCustomerManager().getSpecificCustomer(customerId);
	}
	
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		return getCustomerManager().getAllCustomers();
	}
	
	public boolean editCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return getCustomerManager().updateCustomer(customer);
	}
	
	public boolean deleteTheCustomer(int customerId) throws ClassNotFoundException, SQLException {
		return getCustomerManager().deleteCustomer(customerId);
	}

}

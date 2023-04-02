package com.chira.bumblebee.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public boolean registerCustomer(Customer customer) {
		return false;
	}
	
	public boolean getSpecificCustomer(int customerId) {
		return false;
	}
	
	public List<Customer> getAllCustomers() {
		return new ArrayList<Customer>();
	}
	
	public boolean editCustomer(Customer customer) {
		return false;
	}
	
	public boolean deleteTheCustomer(int customerId) {
		return false;
	}

}

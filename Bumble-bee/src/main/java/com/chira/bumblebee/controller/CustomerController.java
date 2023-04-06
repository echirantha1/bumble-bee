package com.chira.bumblebee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chira.bumblebee.model.Customer;
import com.chira.bumblebee.service.CustomerService;


public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService service;
	
	public CustomerController() {
		service = CustomerService.getCustomerServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificCustomer(request, response);
		}
		else {
			searchAllCustomers(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addCustomer(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateCustomer(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteCustomer(request, response);
		}
		else if(type != null && type.equals("register")) {
			regCustomer(request, response);
		}
		else if(type != null && type.equals("login")) {
			loginCurrentCustomer(request, response);
		}
	}
	
	
	
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		Customer customer = new Customer(nic, name, email, password, address, mobile);
		try {
			boolean result = service.registerCustomer(customer);
			if(result) {
				message = "Customer " + name + " successfully added!";
			}
			else {
				message = "Customer " + name + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-customer.jsp");
		rd.forward(request, response);
	}
	
	private void searchSpecificCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		Customer customer = new Customer();
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		try {
			customer = service.getSpecificCustomer(customerId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("customer", customer);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-customer.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		List<Customer> customerList;
		
		try {
			customerList = service.getAllCustomers();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			customerList = new ArrayList<Customer>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("customerList", customerList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-customer.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		Customer customer = new Customer(customerId, nic, name, email, password, address, mobile);
		
		try {
			boolean result = service.editCustomer(customer);
			if(result) {
				message = "Customer " + customerId + " updated";
			}
			else {
				message = "Customer " + customerId + " updation faild!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-customer.jsp");
		rd.forward(request, response);
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		try {
			boolean result = service.deleteTheCustomer(customerId);
			
			if(result) {
				message = "Customer successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("manage-customer");
	}
	
	private void regCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		Customer customer = new Customer(nic, name, email, password, address, mobile);
		try {
			boolean result = service.registerCustomer(customer);
			if(result) {
				message = name + " successfully Registered!";
			}
			else {
				message = name + " Registration Faild!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("auth-register.jsp");
		rd.forward(request, response);
	}
	
	private void loginCurrentCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Customer customer = service.loginTheCustomer(email, password);
			
			if(customer != null) {
				String path = "home.jsp";
			    RequestDispatcher rd = request.getRequestDispatcher(path);
			    rd.forward(request, response);
			}
			else {
				message = "Username or Password invalid!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("auth-customer.jsp");
		rd.forward(request, response);
	}

}

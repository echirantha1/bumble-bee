package com.chira.bumblebee.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chira.bumblebee.model.Admin;
import com.chira.bumblebee.service.AdminService;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService service;
	
	public AdminController() {
		service = AdminService.getAdminServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("login")) {
			searchSpecificAdmin(request, response);
		}
	}
	
	

	
	private void searchSpecificAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Admin admin = service.getSpecificAdmin(email, password);
			
			if(admin != null) {
				String path = "add-product.jsp";
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
		
		RequestDispatcher rd = request.getRequestDispatcher("auth-admin.jsp");
		rd.forward(request, response);
	}

}

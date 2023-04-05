package com.chira.bumblebee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}
	
	

	
	private void searchSpecificAdmin(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	private void searchAllAdmins(HttpServletRequest request, HttpServletResponse response) {
		
	}


}

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

import com.chira.bumblebee.model.Category;
import com.chira.bumblebee.service.CategoryService;


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private CategoryService service;
	
	public CategoryController() {
		service = CategoryService.getCategoryServiceInstance();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificCategory(request, response);
		}
		else {
			searchAllCategories(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addCategory(request, response);
		}
		else if(type.equals("update")) {
			updateCategory(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteCategory(request, response);
		}
		
	}
	
	
	
	
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		String categoryName = request.getParameter("categoryName");
		
		Category category = new Category(categoryName);
		try {
			boolean result = service.registerCategory(category);
			if(result) {
				message = "Category " + categoryName + " successfully added!";
			}
			else {
				message = "Category " + categoryName + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-category.jsp");
		rd.forward(request, response);
	}
	
	private void searchSpecificCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		Category category = new Category();
		int caregoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		try {
			category = service.getSpecificCategory(caregoryId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("category", category);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-category.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		List<Category> categoryList;
		
		try {
			categoryList = service.getAllCategories();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-categories.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		
		Category category = new Category(categoryName);
		
		try {
			boolean result = service.editCategory(category);
			if(result) {
				message = "Category " + categoryId + " updated";
			}
			else {
				message = "Category " + categoryId + " updation faild!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-category.jsp");
		rd.forward(request, response);
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		try {
			boolean result = service.deleteTheCategory(categoryId);
			
			if(result) {
				message = "Category successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("manage-categories");
	}

}

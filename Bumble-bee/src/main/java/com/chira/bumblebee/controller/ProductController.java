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

import com.chira.bumblebee.model.Product;
import com.chira.bumblebee.service.ProductService;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ProductService service;
	
	public ProductController() {
		service = ProductService.getProductServiceInstance();
	}

	
	//--Entry points--
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificProduct(request, response);
		} else {
			searchAllProducts(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addProduct(request, response);
		} else if(type != null && type.equals("update")) {
			updateProduct(request, response);
		} else if(type != null && type.equals("delete")){
			deleteProduct(request, response);
		}
		
	}
	
	
	//--Private methods--
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String productName = request.getParameter("pname");
		int categoryId = Integer.parseInt(request.getParameter("catId"));
		int brandId = Integer.parseInt(request.getParameter("bId"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		double productPrice = Double.parseDouble(request.getParameter("pprice"));
		String description = request.getParameter("desc");
		
		Product product = new Product(productName, categoryId, brandId, quantity, productPrice, description);
		try {
			boolean result = service.registerProduct(product);
			if(result) {
				message = "Product " + productName + " successfully added!";
			} else {
				message = "Product " + productName + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-product.jsp");
		rd.forward(request, response);
		
	}
	
	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		List<Product> productList;
		try {
			productList = service.getAlLProducts();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			productList = new ArrayList<Product>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("productList", productList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-products.jsp");
		rd.forward(request, response);
		
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}

}

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

import com.chira.bumblebee.model.Inventory;
import com.chira.bumblebee.service.InventoryService;


public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InventoryService service;
	
	public InventoryController() {
		service = InventoryService.getInventoryServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificStock(request, response);
		}
		else {
			searchAllStocks(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addStock(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateStock(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteStock(request, response);
		}
	}
	
	
	
	private void addStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int availableStock = Integer.parseInt(request.getParameter("availableStock"));
		int soldAmount = Integer.parseInt(request.getParameter("soldAmount"));
		
		Inventory stock = new Inventory(productId, availableStock, soldAmount);
		try {
			boolean result = service.registerStock(stock);
			if(result) {
				message = "Stock " + productId + " successfully added!";
			}
			else {
				message = "Stock " + productId + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-inventory.jsp");
		rd.forward(request, response);
	}
	
	private void searchSpecificStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		Inventory stock = new Inventory();
		int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));
		
		try {
			stock = service.getSpecificStock(inventoryId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("stock", stock);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-inventory.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllStocks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		List<Inventory> stockList;
		
		try {
			stockList = service.getAllStocks();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			stockList = new ArrayList<Inventory>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("stockList", stockList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-inventory.jsp");
		rd.forward(request, response);
	}
	
	private void updateStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int availableStock = Integer.parseInt(request.getParameter("availableStock"));
		int soldAmount = Integer.parseInt(request.getParameter("soldAmount"));
		
		Inventory stock = new Inventory(inventoryId, productId, availableStock, soldAmount);
		
		try {
			boolean result = service.editStock(stock);
			if(result) {
				message = "Stock " + inventoryId + " updated";
			}
			else {
				message = "Stock " + inventoryId + " updation faild!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-inventory.jsp");
		rd.forward(request, response);
	}
	
	private void deleteStock(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";
		
		int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));
		
		try {
			boolean result = service.deleteTheStock(inventoryId);
			
			if(result) {
				message = "Stock successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("manage-inventory");
	}

}

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

import com.chira.bumblebee.model.Loan;
import com.chira.bumblebee.service.LoanService;


public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoanService service;
	
	public LoanController() {
		service = LoanService.getLoanServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificLoan(request, response);
		}
		else {
			searchAllLoans(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addLoan(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateLoan(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deleteLoan(request, response);
		}
	}
	
	
	
	
	private void addLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String installments = request.getParameter("installments");
		String interest = request.getParameter("interest");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		Loan loan = new Loan(productId, amount, installments, interest, customerId);
		try {
			boolean result = service.registerLoan(loan);
			if(result) {
				message = "Loan " + productId + " successfully added!";
			}
			else {
				message = "Loan " + productId + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-loan.jsp");
		rd.forward(request, response);
	}
	
	private void searchSpecificLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		Loan loan = new Loan();
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		
		try {
			loan = service.getSpecificLoan(loanId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("loan", loan);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-loan.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllLoans(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		List<Loan> loanList;
		
		try {
			loanList = service.getAllLoans();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			loanList = new ArrayList<Loan>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("loanList", loanList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-loan.jsp");
		rd.forward(request, response);
	}
	
	private void updateLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String installments = request.getParameter("installments");
		String interest = request.getParameter("interest");
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		Loan loan = new Loan(loanId, productId, amount, installments, interest, customerId);
		
		try {
			boolean result = service.editLoan(loan);
			if(result) {
				message = "Loan " + loanId + " updated";
			}
			else {
				message = "Loan " + loanId + " updation faild!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-loan.jsp");
		rd.forward(request, response);
	}
	
	private void deleteLoan(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";
		
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		
		try {
			boolean result = service.deleteTheLoan(loanId);
			
			if(result) {
				message = "Loan successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("manage-loan");
	}

}

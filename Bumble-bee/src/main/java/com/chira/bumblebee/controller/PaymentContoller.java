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

import com.chira.bumblebee.model.Payment;
import com.chira.bumblebee.service.PaymentService;


public class PaymentContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PaymentService service;
	
	public PaymentContoller() {
		service = PaymentService.getPaymentServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificPayment(request, response);
		}
		else {
			searchAllPayments(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addPayment(request, response);
		}
		else if(type != null && type.equals("update")) {
			updatePayment(request, response);
		} 
		else if(type != null && type.equals("delete")) {
			deletePayment(request, response);
		}
	}
	
	
	
	private void addPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int soldAmount = Integer.parseInt(request.getParameter("soldAmount"));
		
		Payment payment = new Payment(productId, customerId, soldAmount);
		try {
			boolean result = service.registerPayment(payment);
			if(result) {
				message = "Payment " + productId + " successfully added!";
			}
			else {
				message = "Payment " + productId + " NOT added!!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-payment.jsp");
		rd.forward(request, response);
	}
	
	private void searchSpecificPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		Payment payment = new Payment();
		int paymentId = Integer.parseInt(request.getParameter("paymentId"));
		
		try {
			payment = service.getSpecificPayment(paymentId);
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("payment", payment);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-payment.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		List<Payment> paymentList;
		
		try {
			paymentList = service.getAllPayments();
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
			paymentList = new ArrayList<Payment>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("paymentList", paymentList);
		
		RequestDispatcher rd = request.getRequestDispatcher("manage-payment.jsp");
		rd.forward(request, response);
	}
	
	private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		
		int paymentId = Integer.parseInt(request.getParameter("paymentId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		int soldAmount = Integer.parseInt(request.getParameter("soldAmount"));
		
		Payment payment = new Payment(paymentId, productId, customerId, soldAmount);
		
		try {
			boolean result = service.editPayment(payment);
			if(result) {
				message = "Payment " + paymentId + " updated";
			}
			else {
				message = "Payment " + paymentId + " updation faild!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("update-payment.jsp");
		rd.forward(request, response);
	}
	
	private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String message = "";
		
		int paymentId = Integer.parseInt(request.getParameter("paymentId"));
		
		try {
			boolean result = service.deleteThePayment(paymentId);
			
			if(result) {
				message = "Payment successfully deleted";
			}
			else {
				message = "Something went wrong. Please try in a moment!!";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		response.sendRedirect("manage-payment");
	}

}

package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.dao.PaymentManager;
import com.chira.bumblebee.model.Payment;

public class PaymentService {
	
	private static PaymentService paymentServiceObj;

	public PaymentService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized PaymentService getPaymentServiceInstance() {
		
		if(paymentServiceObj == null) {
			
			paymentServiceObj = new PaymentService();
			
		}
		return paymentServiceObj;
		
	}
	
	private PaymentManager getPaymentManager() {
		return new PaymentManager();
	}
	
	public boolean registerPayment(Payment payment) throws ClassNotFoundException, SQLException {
		return getPaymentManager().addPayment(payment);
	}
	
	public Payment getSpecificPayment(int paymentId) throws ClassNotFoundException, SQLException {
		return getPaymentManager().getSpecificPayment(paymentId);
	}
	
	public List<Payment> getAllPayments() throws ClassNotFoundException, SQLException {
		return getPaymentManager().getAllPayments();
	}
	
	public boolean editPayment(Payment payment) throws ClassNotFoundException, SQLException {
		return getPaymentManager().updatePayment(payment);
	}
	
	public boolean deleteThePayment(int paymentId) throws ClassNotFoundException, SQLException {
		return getPaymentManager().deletePayment(paymentId);
	}

}

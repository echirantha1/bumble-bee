package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Payment;


public class PaymentManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addPayment(Payment payment) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO payment (productId, customerId, soldAmount) VALUES ( ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, payment.getProductId());
		ps.setInt(2, payment.getCustomerId());
		ps.setInt(3, payment.getSoldAmount());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Payment getSpecificPayment (int paymentId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM payment WHERE paymentId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, paymentId);
		
		ResultSet rs = ps.executeQuery();
		Payment payment = new Payment();
		
		while(rs.next()) {
			payment.setPaymentId(rs.getInt("paymentId"));
			payment.setProductId(rs.getInt("productId"));
			payment.setCustomerId(rs.getInt("customerId"));
			payment.setSoldAmount(rs.getInt("soldAmount"));
			payment.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return payment;
	}
	
	public List<Payment> getAllPayments() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM payment";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Payment> paymentList = new ArrayList<Payment>();
		
		while(rs.next()) {
			Payment payment = new Payment();
			payment.setPaymentId(rs.getInt("paymentId"));
			payment.setProductId(rs.getInt("productId"));
			payment.setCustomerId(rs.getInt("customerId"));
			payment.setSoldAmount(rs.getInt("soldAmount"));
			payment.setDate(rs.getDate("date"));
			
			paymentList.add(payment);
		}
		
		st.close();
		connection.close();
		return paymentList;
	}
	
	public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE payment SET productId = ?, customerId = ?, soldAmount = ? WHERE loanId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, payment.getProductId());
		ps.setInt(2, payment.getCustomerId());
		ps.setInt(3, payment.getSoldAmount());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deletePayment(int paymentId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM payment WHERE paymentId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, paymentId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

}

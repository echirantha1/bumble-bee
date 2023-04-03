package com.chira.bumblebee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Loan;


public class LoanManager {

	public DbConnector getDbConnector() {
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
		return factory.getDbConnector();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector = getDbConnector();
		return connector.getDbConnection();
	}
	
	public boolean addLoan(Loan loan) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String  query = "INSERT INTO loan (productId, amount, installments, interest, customerId) VALUES ( ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, loan.getProductId());
		ps.setDouble(2, loan.getAmount());
		ps.setString(3, loan.getInstallments());
		ps.setString(4, loan.getInterest());
		ps.setInt(5, loan.getCustomerId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;	
	}
	
	public Loan getSpecificLoan (int loanId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM loan WHERE loanId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, loanId);
		
		ResultSet rs = ps.executeQuery();
		Loan loan = new Loan();
		
		while(rs.next()) {
			loan.setLoanId(rs.getInt("loanId"));
			loan.setProductId(rs.getInt("productId"));
			loan.setAmount(rs.getDouble("amount"));
			loan.setInstallments(rs.getString("installments"));
			loan.setInterest(rs.getString("interest"));
			loan.setCustomerId(rs.getInt("customerId"));
			loan.setDate(rs.getDate("date"));
		}
		
		ps.close();
		connection.close();
		
		return loan;
	}
	
	public List<Loan> getAllLoans() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "SELECT * FROM loan";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Loan> loanList = new ArrayList<Loan>();
		
		while(rs.next()) {
			Loan loan = new Loan();
			loan.setLoanId(rs.getInt("loanId"));
			loan.setProductId(rs.getInt("productId"));
			loan.setAmount(rs.getDouble("amount"));
			loan.setInstallments(rs.getString("installments"));
			loan.setInterest(rs.getString("interest"));
			loan.setCustomerId(rs.getInt("customerId"));
			loan.setDate(rs.getDate("date"));
			
			loanList.add(loan);
		}
		
		st.close();
		connection.close();
		return loanList;
	}
	
	public boolean updateLoan(Loan loan) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "UPDATE loan SET productId = ?, amount = ?, installments = ?, interest = ?, customerId = ? WHERE loanId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, loan.getProductId());
		ps.setDouble(2, loan.getAmount());
		ps.setString(3, loan.getInstallments());
		ps.setString(4, loan.getInterest());
		ps.setInt(5, loan.getCustomerId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteLoan(int loanId) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		String query = "DELETE FROM loan WHERE loanId = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, loanId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

}

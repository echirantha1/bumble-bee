package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.dao.LoanManager;
import com.chira.bumblebee.model.Loan;


public class LoanService {
	
	private static LoanService loanServiceObj;

	public LoanService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized LoanService getLoanServiceInstance() {
		
		if(loanServiceObj == null) {
			
			loanServiceObj = new LoanService();
			
		}
		return loanServiceObj;
		
	}
	
	private LoanManager getLoanManager() {
		return new LoanManager();
	}
	
	public boolean registerLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return getLoanManager().addLoan(loan);
	}
	
	public Loan getSpecificLoan(int loanId) throws ClassNotFoundException, SQLException {
		return getLoanManager().getSpecificLoan(loanId);
	}
	
	public List<Loan> getAllLoans() throws ClassNotFoundException, SQLException {
		return getLoanManager().getAllLoans();
	}
	
	public boolean editLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return getLoanManager().updateLoan(loan);
	}
	
	public boolean deleteTheLoan(int loanId) throws ClassNotFoundException, SQLException {
		return getLoanManager().deleteLoan(loanId);
	}

}

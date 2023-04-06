package com.chira.bumblebee.service;

import java.sql.SQLException;

import com.chira.bumblebee.dao.AdminManager;
import com.chira.bumblebee.model.Admin;

public class AdminService {
	
	private static AdminService adminServiceObj;

	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized AdminService getAdminServiceInstance() {
		
		if(adminServiceObj == null) {
			adminServiceObj = new AdminService();
		}
		
		return adminServiceObj;	
	}
	
	private AdminManager getAdminManager() {
		return new AdminManager();
	}
	
	public Admin getSpecificAdmin(String email, String password) throws ClassNotFoundException, SQLException {
		return getAdminManager().getSpecificAdmin(email, password);
	}
}

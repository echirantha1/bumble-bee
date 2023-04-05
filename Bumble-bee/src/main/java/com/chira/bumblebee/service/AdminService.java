package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

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

	
	public Admin getSpecificAdmin(int adminId) throws ClassNotFoundException, SQLException {
		return getAdminManager().getSpecificAdmin(adminId);
	}
	
	public List<Admin> getAllAdmins() throws ClassNotFoundException, SQLException {
		return getAdminManager().getAllAdmins();
	}
	

}

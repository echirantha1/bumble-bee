package com.chira.bumblebee.service;

import java.util.ArrayList;
import java.util.List;

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

	
	public boolean getSpecificAdmin(int adminId) {
		return false;
	}
	
	public List<Admin> getAllAdmins() {
		return new ArrayList<Admin>();
	}
	

}

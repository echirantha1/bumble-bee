package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.chira.bumblebee.dao.BrandManager;
import com.chira.bumblebee.model.Brand;

public class BrandService {
	
	private static BrandService brandServiceObj;

	public BrandService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized BrandService getBrandServiceInstance() {
		
		if(brandServiceObj == null) {
			
			brandServiceObj = new BrandService();
			
		}
		return brandServiceObj;
		
	}
	
	private BrandManager getBrandManager() {
		return new BrandManager();
	}
	
	public boolean registerBrand(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandManager().addBrand(brand);
	}
	
	public Brand getSpecificBrand(int brandId) throws ClassNotFoundException, SQLException {
		return getBrandManager().getSpecificBrand(brandId);
	}
	
	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
		return getBrandManager().getAllBrands();
	}
	
	public boolean editBrand(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandManager().updateBrand(brand);
	}
	
	public boolean deleteTheBrand(int brandId) throws ClassNotFoundException, SQLException {
		return getBrandManager().deleteBrand(brandId);
	}

}

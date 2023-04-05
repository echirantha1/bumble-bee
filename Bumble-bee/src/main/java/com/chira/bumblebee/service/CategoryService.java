package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.chira.bumblebee.dao.CategoryManager;
import com.chira.bumblebee.model.Category;

public class CategoryService {
	
	private static CategoryService categoryServiceObj;

	public CategoryService() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized CategoryService getCategoryServiceInstance() {
		
		if(categoryServiceObj == null) {
			
			categoryServiceObj = new CategoryService();
			
		}
		return categoryServiceObj;
		
	}
	
	private CategoryManager getCategoryManage() {
		return new CategoryManager();
	}
	
	public boolean registerCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManage().addCategory(category);
	}
	
	public Category getSpecificCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManage().getSpecificCategory(categoryId);
	}
	
	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
		return getCategoryManage().getAllCategories();
	}
	
	public boolean editCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManage().updateCategory(category);
	}
	
	public boolean deleteTheCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManage().deleteCategory(categoryId);
	}

}

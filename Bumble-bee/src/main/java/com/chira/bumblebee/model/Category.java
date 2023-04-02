package com.chira.bumblebee.model;

import java.sql.Date;

public class Category {
	
	private int categoryId;
	private String categoryName;
	private Date date;

	public Category(int categoryId, String categoryName, Date date) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.date = date;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

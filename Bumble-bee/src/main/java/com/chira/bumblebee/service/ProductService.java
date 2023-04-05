package com.chira.bumblebee.service;

import java.sql.SQLException;
import java.util.List;

import com.chira.bumblebee.dao.ProductManger;
import com.chira.bumblebee.model.Product;

public class ProductService {
	
	
	private static ProductService productServiceObj;

	private ProductService() {
 
	}
	
	public static synchronized ProductService getProductServiceInstance() {
		
		if(productServiceObj == null) {
			
			productServiceObj = new ProductService();
			
		}
		return productServiceObj;
		
	}
	

	private ProductManger getProductManager() {
		return new ProductManger();
	}
	
	
	public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException {

		return getProductManager().addProduct(product);
	}

	public  Product getSpecificProduct(int productId) throws ClassNotFoundException, SQLException {

		return getProductManager().getSpecificProduct(productId);
	}


	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		return getProductManager().getAllProducts();
	}

	public  boolean editProduct(Product product) throws ClassNotFoundException, SQLException {

		return getProductManager().updateProduct(product);
	}
	
	public boolean deleteTheProduct(int productId) throws ClassNotFoundException, SQLException {
		return getProductManager().deleteProduct(productId);
	}

}

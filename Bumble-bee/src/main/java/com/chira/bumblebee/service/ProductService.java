package com.chira.bumblebee.service;

import java.util.ArrayList;
import java.util.List;

import com.chira.bumblebee.model.Product;

public class ProductService {
	
	
	private static ProductService productService;

	private ProductService() {
 
	}
	
	public static synchronized ProductService getProductServiceInstance() {
		
		if(productService == null) {
			
			productService = new ProductService();
			
		}
		return productService;
		
	}
	

	public boolean registerProduct(Product product) {

		return false;
	}

	public  Product getSpecificProduct(int productId) {

		return new Product();
	}


	public List<Product> getAlLProducts(){
		return new ArrayList<Product>();
	}

	public  boolean editProduct(Product product) {

		return false;
	}
	
	public boolean deleteTheProduct(int productId) {
		return false;
	}
	
	

}

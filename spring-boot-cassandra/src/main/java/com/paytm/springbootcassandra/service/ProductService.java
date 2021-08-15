package com.paytm.springbootcassandra.service;

import java.util.List;
import java.util.UUID;

import com.paytm.springbootcassandra.tables.Products;

public interface ProductService {

	void saveProducts(List<Products> productList);

	List<Products> getProducts() throws Exception;
	
	public List<Products> getProductByName(String name) throws Exception;

	UUID saveProducts(Products product) throws Exception;

	String parseJson() throws Exception ;

	String parseJson2() throws Exception ;

}

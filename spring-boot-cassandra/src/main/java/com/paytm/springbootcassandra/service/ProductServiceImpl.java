package com.paytm.springbootcassandra.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.paytm.springbootcassandra.repository.ProductRepository;
import com.paytm.springbootcassandra.repository.ProductServiceDAO;
import com.paytm.springbootcassandra.tables.Products;

@Service
public class ProductServiceImpl implements ProductService {
	// using spring framework crudOperations
	@Autowired
	ProductRepository productRepository;

	// using spring framework cassandraTemplate
	@Autowired
	ProductServiceDAO productServiceDao;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	ObjectMapper updateObjectMapper;
	
	@Autowired
	SimpleModule simpleModule;
	
	@Autowired
	@Qualifier("addSerializer")
	ProductSerializer addSerializer;

	@Autowired
	@Qualifier("updateSerializer")
	ProductSerializer updateSerializer;

	@Override
	public List<Products> getProducts() throws Exception {
		return productServiceDao.getAllProducts();
	}

	@Override
	public void saveProducts(List<Products> productList) {
		productRepository.saveAll(productList);
	}

	@Override
	public UUID saveProducts(Products product) throws Exception {
		return productServiceDao.createStudent(product);
	}

	@Override
	public List<Products> getProductByName(String pName) throws Exception {
		return productServiceDao.getProductsByName(pName);
	}

	@Override
	public String parseJson2() throws Exception {
		Products products = new Products();	
		products.setId(UUID.randomUUID());
		updateObjectMapper.registerModule((new SimpleModule()).addSerializer(Products.class, updateSerializer));
		return updateObjectMapper.writeValueAsString(products);
		
	}
	@Override
	public String parseJson() throws Exception {
		Products products = new Products();
		products.setId(UUID.randomUUID());
		objectMapper.registerModule((new SimpleModule()).addSerializer(Products.class, addSerializer));
		return objectMapper.writeValueAsString(products);
		
	}


}

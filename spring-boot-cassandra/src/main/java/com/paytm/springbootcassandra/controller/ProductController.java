package com.paytm.springbootcassandra.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paytm.springbootcassandra.service.ProductService;
import com.paytm.springbootcassandra.tables.Products;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Products> getProducts() throws Exception {
		return productService.getProducts();
	}

	@RequestMapping(value = "/get/{productName}", method = RequestMethod.GET)
	public List<Products> getProducts(@PathVariable("productName") String productName) throws Exception {
		return productService.getProductByName(productName);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void insertProduct(@RequestBody List<Products> productList) {
		productService.saveProducts(productList);
	}

	@RequestMapping(value = "/save/1", method = RequestMethod.POST)
	public UUID insertProduct(@RequestBody Products product) throws Exception {
		return productService.saveProducts(product);
	}
}

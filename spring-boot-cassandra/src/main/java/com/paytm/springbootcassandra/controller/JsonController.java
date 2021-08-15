package com.paytm.springbootcassandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paytm.springbootcassandra.service.ProductService;
import com.paytm.springbootcassandra.tables.Products;

@RestController
public class JsonController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String getProducts() throws Exception {
		return productService.parseJson();
	}
	
	@RequestMapping(value = "/json2", method = RequestMethod.GET)
	public String getProducts2() throws Exception {
		return productService.parseJson2();
	}
}

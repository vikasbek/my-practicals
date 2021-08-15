package com.paytm.springbootcassandra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import com.paytm.springbootcassandra.tables.Products;

@Repository
public class ProductServiceDAO {

	@Autowired
	CassandraTemplate cassandraTemplate;

	public List<Products> getProductsByName(final String pName) throws Exception {
		return cassandraTemplate.select("select * from products where productname ='" + pName + "'", Products.class);
	}

	public UUID createStudent(Products product) throws Exception {
		cassandraTemplate.getCqlOperations().execute("insert into products(id, productname, price, description) values(?,?,?,?)", product.getId(),
				product.getProductName(), product.getPrice(), product.getDescription());
		return product.getId();
	}

	public List<Products> getAllProducts() throws Exception {
		return cassandraTemplate.select("select * from products", Products.class);
	}
}

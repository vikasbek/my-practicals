package com.paytm.springbootcassandra.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.paytm.springbootcassandra.tables.Products;
import com.paytm.springbootcassandra.tables.ProductsKey;

public interface ProductRepository extends CrudRepository<Products, ProductsKey> {
	List<Products> findByProductName(final String productName);

	List<Products> findById(UUID id);

	List<Products> findByProductNameAndPriceGreaterThan(final String productName, final BigDecimal price);
}

package com.paytm.springbootcassandra.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


public class Products implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String productName;

	private BigDecimal price;

	private UUID id;

	private String description;

	public Products() {
		id = UUID.randomUUID();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

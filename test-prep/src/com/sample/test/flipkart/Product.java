package com.sample.test.flipkart;

public class Product {
	private String productName;
	private Double price;
	private String category;

	public Product(String name, Double price, String category) {
		this.productName = name;
		this.price = price;
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productName=").append(productName).append(", price=").append(price).append(", category=").append(category).append("]");
		return builder.toString();
	}
}

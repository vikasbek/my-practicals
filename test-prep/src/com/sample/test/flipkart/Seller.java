package com.sample.test.flipkart;

import java.util.UUID;

public class Seller {
	UUID sellerId;
	String sellerName;
	int rating;

	Seller(String name, int rating) {
		this.sellerId = UUID.randomUUID();
		this.sellerName = name;
		this.rating = rating;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public UUID getSellerId() {
		return sellerId;
	}

	public void setSellerId(UUID sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seller [sellerId=").append(sellerId).append(", sellerName=").append(sellerName).append(", rating=").append(rating).append("]");
		return builder.toString();
	}
	
}

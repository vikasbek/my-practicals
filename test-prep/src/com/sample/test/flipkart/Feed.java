package com.sample.test.flipkart;

/**
 * @author vikasbek
 *
 */
public class Feed {
	String seller;
	Product product;

	Feed(String sellerName, Product product) {
		this.seller = sellerName;
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feed [seller=").append(seller).append(", product=").append(product).append("]");
		return builder.toString();
	}
}

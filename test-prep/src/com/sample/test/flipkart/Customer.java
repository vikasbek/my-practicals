package com.sample.test.flipkart;

import java.util.UUID;

public class Customer {
	String name;
	UUID custId;

	Customer(String name) {
		this.custId = UUID.randomUUID();
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [name=").append(name).append(", custId=").append(custId).append("]");
		return builder.toString();
	}
}

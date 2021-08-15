package com.sample.test.java.customInterface;

public class DriverCustomInterface implements TestI {

	@MyInterface(value = "test")
	public void display() {
		System.out.println("display");
	}

	@MyInterface
	public void displayBlank() {
		System.out.println("display");
	}

	public static void main(String[] args) {
		System.out.println(person);
		System.out.println(QR_TYPELIST);
	}
}

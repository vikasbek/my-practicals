package com.project.aco;

import java.io.IOException;

interface aI {
	void display() throws IOException;

}

class Aimpl implements aI {

	public void display() throws RuntimeException {

	}

}

class Resource {
	volatile int number = 0;

}

class Even implements Runnable {
	Resource resource;

	public Even(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (resource.number < 11) {
			synchronized (Resource.class) {
				if (resource.number % 2 == 0) {
					System.out.println(resource.number);
					resource.number++;
				}
			}

		}

	}

}

class Odd implements Runnable {
	Resource resource;

	public Odd(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (resource.number < 10) {
			synchronized (Resource.class) {
				if (resource.number % 2 != 0) {
					System.out.println(resource.number);
					resource.number++;
				}
			}
		}

	}

}

public class EvenOddPrintMain {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Thread t1 = new Thread(new Even(resource));
		Thread t2 = new Thread(new Odd(resource));
		t1.start();
		t2.start();
	}

}

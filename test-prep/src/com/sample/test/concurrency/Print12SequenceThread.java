package com.sample.test.concurrency;

import java.util.concurrent.Semaphore;

class Even implements Runnable {

	EvenOdd evenOdd;
	int max;

	Even(EvenOdd evenOdd, int max) {
		this.evenOdd = evenOdd;
		this.max = max;
	}

	@Override
	public void run() {
		while (max > 0) {
			if (evenOdd.printEven())
				max--;
		}
	}

}


class Odd implements Runnable {
	EvenOdd evenOdd;
	int max;

	Odd(EvenOdd evenOdd, int max) {
		this.evenOdd = evenOdd;
		this.max = max;
	}

	@Override
	public void run() {
		while (max > 0) {
			if (evenOdd.printOdd())
				max--;
		}
	}

}


class EvenOdd {
	volatile int i = 0;

	boolean printEven() {

		if (i % 2 == 0) {
			System.out.println(i);
			i++;
			return true;
		}
		return false;
	}

	boolean printOdd() {

		if (i % 2 != 0) {
			System.out.println(i);
			i++;
			return true;
		}
		return false;
	}

}


class Foo {

	public Foo() {

	}

	Semaphore s1 = new Semaphore(0);
	Semaphore s2 = new Semaphore(0);

	void printEven(Runnable even) {

		int n = 7;
		while (n > 0) {
			even.run();
			n--;
		}
	}

	void printOdd(Runnable odd) {

		int n = 7;
		while (n > 0) {
			odd.run();
			n--;
		}
	}

}


public class Print12SequenceThread {

	public static void main(String[] args) {
		EvenOdd evenOdd = new EvenOdd();
		Thread evenT = new Thread(new Even(evenOdd, 10));
		Thread oddT = new Thread(new Odd(evenOdd, 10));
		int n = 7;
		// while (n > 0) {
		evenT.start();
		oddT.start();
		
		// n--;
		// }
		// Print12SequenceThread print = new Print12SequenceThread();
		// print.printEven(evenT);
		// print.printOdd(oddT);


	}

}

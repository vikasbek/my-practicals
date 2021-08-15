package com.sample.test.concurrency;

class Even1 implements Runnable {

	EvenOdd1 evenOdd;
	int max;

	Even1(EvenOdd1 evenOdd, int max) {
		this.evenOdd = evenOdd;
		this.max = max;
	}

	@Override
	public void run() {
		while (max > 0) {
			evenOdd.printEven();
			max--;
		}
	}

}


class Odd1 implements Runnable {
	EvenOdd1 evenOdd;
	int max;

	Odd1(EvenOdd1 evenOdd, int max) {
		this.evenOdd = evenOdd;
		this.max = max;
	}

	@Override
	public void run() {
		while (max > 0) {
			evenOdd.printOdd();
			max--;
		}
	}

}


// class Foo2 {
// public Foo2() {
//
// }
//
// public void first() {
//
// }
//
// public void second() {
//
// }
// }

class EvenOdd1 {

	boolean first = false;
	boolean second = false;
	volatile int i = 1;

	synchronized void printEven() {
		while (i % 2 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("first" + i++);
		first = true;
		notifyAll();
	}

	synchronized void printOdd() {
		while (i % 2 == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		second = true;
		System.out.println("second" + i++);
		notifyAll();
	}

}
//


public class PrintEvenOddSequenceThread2 {

	public static void main(String[] args) {
		EvenOdd1 evenOdd = new EvenOdd1();
		Thread evenT = new Thread(new Even1(evenOdd, 10));
		Thread oddT = new Thread(new Odd1(evenOdd, 10));
		//
		// EvenOdd1 evenOdd1 = new EvenOdd1();
		//
		// int n = 7;
		// while (n > 0) {
		oddT.start();
		evenT.start();
		// evenT.getName();
		// Thread.currentThread().getName();
		// n--;
		// }
		// Print12SequenceThread print = new Print12SequenceThread();
		// print.printEven(evenT);
		// print.printOdd(oddT);


	}

}

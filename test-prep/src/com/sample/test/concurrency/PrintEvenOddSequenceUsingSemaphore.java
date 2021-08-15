package com.sample.test.concurrency;

import java.util.concurrent.Semaphore;

class Even2 implements Runnable {

	EvenOdd2 evenOdd;
	int max;

	Even2(EvenOdd2 evenOdd, int max) {
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


class Odd2 implements Runnable {
	EvenOdd2 evenOdd;
	int max;

	Odd2(EvenOdd2 evenOdd, int max) {
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

class EvenOdd2 {

	Semaphore evenSem = new Semaphore(0);
	Semaphore oddSem = new Semaphore(1);
	volatile int i = 1;

	void printEven() {
//		while (i % 2 != 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			evenSem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("first" + i++);
		oddSem.release();
	}

	void printOdd() {
//		while (i % 2 == 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			oddSem.acquire();
			System.out.println("second" + i++);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		evenSem.release();
	}

}
//


public class PrintEvenOddSequenceUsingSemaphore {

	public static void main(String[] args) {
		EvenOdd2 evenOdd = new EvenOdd2();
		Thread evenT = new Thread(new Even2(evenOdd, 10));
		Thread oddT = new Thread(new Odd2(evenOdd, 10));
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

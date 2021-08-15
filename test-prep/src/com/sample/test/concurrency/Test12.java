package com.sample.test.concurrency;

class Value {
	public static volatile int count = 1;
}

class EvenP implements Runnable {
	private Value value;
	private int max;

	EvenP(Value v, int max) {
		this.value = v;
		this.max = max;
	}

	@Override
	public void run() {
		while (true) {
			if(max==value.count) {
				System.exit(0);
			}
			synchronized (Value.class) {
				if (value.count % 2 == 0) {
					System.out.print(value.count++);
				}
			}
		}

	}

}

class OddP implements Runnable {

	private Value value;
	private int max;

	OddP(Value v, int max) {
		this.value = v;
		this.max = max;
	}

	@Override
	public void run() {
		while (true) {
			if(max==value.count) {
				System.exit(0);
			}
			synchronized (Value.class) {
				if (value.count % 2 != 0) {
					System.out.print(value.count++);
				}
			}
		}

	}
}

public class Test12 {

	public static void main(String args[]) {
		Value v = new Value();
		Thread t1 = new Thread(new EvenP(v, 10));
		Thread t2 = new Thread(new OddP(v, 10));
		t1.start();
		t2.start();

	}

}

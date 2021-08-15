package com.sample.test.concurrency;

public class IllegalStateSyncronization {
	public static void main(String args[]) throws InterruptedException {
		IncorrectSynchronization.runExample();
	}

}

class IncorrectSynchronization {

	Boolean flag = new Boolean(true);
	Boolean flag2 = new Boolean(true);

	public void example() throws InterruptedException {

		Thread t1 = new Thread(waitSyncronized());
		Thread t3 = new Thread(waitSyncronized());
		Thread t4 = new Thread(waitSyncronized());

//		Thread t2 = new Thread(new Runnable() {
//
//			public void run() {
//				synchronized (flag) {
//					flag = false;
//					System.out.println("Boolean assignment done.");
//				}
//			}
//		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				synchronized (flag) {
					flag.notifyAll();
					System.out.println("notified");
				}
			}
		});

		t1.start();
		Thread.sleep(1000);
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
	}

	private Runnable waitSyncronized() {
		return new Runnable() {

			public void run() {
				synchronized (flag) {
					try {
						while (flag) {
							System.out.println("First thread about to sleep");
							Thread.sleep(5000);
							System.out.println("Woke up and about to invoke wait()");
							flag.wait();
							System.out.println("wait released");
						}
					} catch (InterruptedException ie) {
						System.out.println(ie);
					}
				}
			}
		};
	}

	public static void runExample() throws InterruptedException {
		IncorrectSynchronization incorrectSynchronization = new IncorrectSynchronization();
		incorrectSynchronization.example();
	}
}

package com.test;

public class DeadLock {
	
	public static void main(String args[]) throws InterruptedException {
		Object resourceA = new Object();
		Object resourceB = new Object();
		
		Thread t1 = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("Thread 1 locked A");
				synchronized (resourceB) {
					System.out.println("Thread 1 locked B");
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (resourceB) {
				System.out.println("Thread 2 locked B");
				synchronized (resourceA) {
					System.out.println("Thread 2 locked A");
				}
			}
		});
		
		t1.start();
		t2.start();
		System.out.println("I am waiting for threads 1 and 2 to reach me after completion of work");
		
	}

}

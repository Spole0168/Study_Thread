package com.thread.currentThreads.chapter2;

public class GoodSuspend {
	public static Object u = new Object();

	public static class ChangeObjectThread extends Thread {
		volatile boolean suspend = false;

		public void suspendMe() {
			suspend = true;
		}

		public void resumeMe() {
			suspend = false;
			synchronized (this) {
				notify();
			}
		}

		public ChangeObjectThread(String name) {
			this.setName(name);
		}

		public void run() {
			while (true) {
				synchronized (this) {
					while (suspend) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					synchronized (u) {
						System.out.println("in ChangeObjectThread!");
					}
					Thread.yield();
				}
			}
		}
	}

	public static class ReadObjectThread extends Thread {
		public ReadObjectThread(String name) {
			this.setName(name);
		}

		public void run() {
			while (true) {
				synchronized (u) {
					System.out.println("in ChangeObjectValue!");
				}
				Thread.yield();
			}
		}
	}


	public static void main(String[] args) throws InterruptedException {
		ChangeObjectThread t1 = new ChangeObjectThread("t1");
		ReadObjectThread t2 = new ReadObjectThread("t2");
		t1.start();
		t2.start();
		Thread.sleep(100);
		t1.suspendMe();
		Thread.sleep(1000);
		t1.resumeMe();
	}
}

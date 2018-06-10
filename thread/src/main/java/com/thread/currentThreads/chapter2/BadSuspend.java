package com.thread.currentThreads.chapter2;

public class BadSuspend {
	public static Object u = new Object();
	public static class ChangeObjectThread extends Thread{
		public ChangeObjectThread(String name){
			this.setName(name);
		}
		public void run(){
			System.out.println("B0 "+getName());
//			synchronized (u) {
				System.out.println("B1 "+getName());
				Thread.currentThread().suspend();
				System.out.println("End1 "+getName());
//			}
		}
	}
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(100);
		t2.start();
		t1.resume();
		Thread.sleep(100);
		t2.resume();
		t1.join();
		t2.join();
	}
}

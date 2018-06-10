package com.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;


public class TestcyclicBarrier {
	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hhhhhhh");
			}
		});
		for (int i = 0; i <3*N; i++)
			new WorkerAwait("worker"+i+"  ", 3000l, barrier).start();
		for (int i = 0; i < N; i++)
			new WorkerAwait("worker"+i+"  ", 3000l, barrier).start();
	}
}

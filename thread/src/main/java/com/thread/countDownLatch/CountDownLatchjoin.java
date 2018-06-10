package com.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 13 on 2017/5/5.
 */
public class CountDownLatchjoin extends Thread {

	public CountDownLatchjoin() {
		super();
	}

	@Override
	public void run() {

		try {
			Thread.sleep(new Random().nextInt(3) * 1000);
			System.out.println("check complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws InterruptedException {
		CountDownLatch end = new CountDownLatch(5);
		CountDownLatchjoin demo = new CountDownLatchjoin();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		Thread t3 = new Thread(demo);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		// ������
		System.out.println("Join  Fire!");
		WorkerDown worker0 = new WorkerDown("worker0", 3000l, end);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(worker0);
		}
		// �ȴ����
		end.await();
		System.out.println("CountDownLatch  Fire!");
		executorService.shutdown();
	}
}

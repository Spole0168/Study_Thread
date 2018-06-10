package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException {  
        // TODO �Զ����ɵķ������  
		long wdT = 5000l;
		long waT = 1000l;
        CountDownLatch countDownLatch = new CountDownLatch(2);  
        WorkerDown worker0 = new WorkerDown("worker0", wdT, countDownLatch);  
        WorkerDown worker1 = new WorkerDown("worker1", wdT, countDownLatch);  
        WorkerDown worker2 = new WorkerDown("worker2", wdT, countDownLatch);  
        WorkerAwait worker11 = new WorkerAwait("worker11", waT, countDownLatch);  
        WorkerAwait worker22 = new WorkerAwait("worker22", waT, countDownLatch);  
          
        worker0.start();  
        worker1.start();      
        worker2.start();      
        worker22.start();      
        worker11.start();      
          
//        countDownLatch.await();  
//        countDownLatch.await();  
//        System.out.println("׼����������");  
//        worker2.start();  
//        countDownLatch.await();  
          
    }  
}

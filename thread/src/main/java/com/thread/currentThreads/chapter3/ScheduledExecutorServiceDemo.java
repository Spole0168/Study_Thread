package com.thread.currentThreads.chapter3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by 13 on 2017/5/5.
 */
public class ScheduledExecutorServiceDemo {
	static int taskPeriod = 3;
	public static class LongTask implements Runnable{

		@Override
		public void run() {
			System.out.println("LongTask Begin \t\t"+System.currentTimeMillis());
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("LongTask End \t\t"+System.currentTimeMillis());
		}
		
	}
	public static class ShortTask implements Runnable{
		
		@Override
		public void run() {
			System.out.println("ShortTask Begin \t\t"+System.currentTimeMillis());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ShortTask End \t\t"+System.currentTimeMillis());
			
		}
		
	}
	public static class CallTask implements Callable<String>{

		@Override
		public String call() throws Exception {
			System.out.println("CallTask Begin \t\t"+System.currentTimeMillis());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("CallTask End   \t\t"+System.currentTimeMillis());
			return "DT="+System.currentTimeMillis();
		}
		
		
	}
	 
	
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        LongTask lt = new LongTask();  //5
        ShortTask st = new ShortTask();//2
        CallTask ct = new CallTask();  //4
        
//        scheduledExecutorService.schedule(st, 0, TimeUnit.SECONDS);
//		String string = scheduledExecutorService.schedule(ct, 0, TimeUnit.SECONDS).get();
//		System.out.println(string);
//        scheduledExecutorService.scheduleAtFixedRate(lt, 0, 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(st, 1, 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
    }
}

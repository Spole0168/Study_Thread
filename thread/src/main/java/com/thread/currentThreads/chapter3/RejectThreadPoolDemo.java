package com.thread.currentThreads.chapter3;

import java.util.concurrent.*;

/**
 * Created by 13 on 2017/5/5.
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {
    	private String threadName;
        public MyTask(String threadName) {
			super();
			this.threadName = threadName;
		}

		@Override
        public void run() {
            System.out.println(threadName + "  Begin====Thread ID:" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "    End ====Thread ID:" + Thread.currentThread().getName());
            
        }
    }


    public static void main(String args[]) throws InterruptedException {
       
    	RejectedExecutionHandler reject = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            	 if (!e.isShutdown()) {
                     e.getQueue().poll();
                     e.execute(r);
                     System.out.println(r.toString() + " is discard");
                 }
            }
        };
        RejectedExecutionHandler rej1 = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler rej2 = new ThreadPoolExecutor.CallerRunsPolicy();
        RejectedExecutionHandler rej3 = new ThreadPoolExecutor.DiscardPolicy();
        RejectedExecutionHandler rej4 = new ThreadPoolExecutor.DiscardOldestPolicy();
        ExecutorService executorService = new ThreadPoolExecutor
        		(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), 
        				Executors.defaultThreadFactory()
                , rej2);
        // 5 +10 
        for (int i = 0; i < 20; i++) {
        	 MyTask myTask = new MyTask("task_"+i);
            executorService.submit(myTask);
            Thread.sleep(10);
        }
        executorService.shutdown();
    }
}

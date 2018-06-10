package com.thread.currentThreads.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class AccountSync implements Runnable {
    static AccountSync instance = new AccountSync();
    static int i = 0;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            /**
             * synchronized��������ʵ���̼߳��ͬ��,��ͬ���Ĵ������,ʹ��ÿһ�ζ�ֻ����һ���߳̽���ͬ����Ӷ���֤�̼߳�İ�ȫ��.
             */
        	//ָ����������  
            synchronized (instance) {
            	synchronized (instance) {
                i++;
            	}
            }
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
//    	AccountSync asy1 = new AccountSync();
//    	asy1.i = 30;
//    	AccountSync asy2 = new AccountSync();
//    	System.out.println(asy2.i);
    	
        Thread thread1 = new Thread(new AccountSync());
        Thread thread2 = new Thread(new AccountSync());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}

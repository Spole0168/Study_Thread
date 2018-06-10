package com.thread.currentThreads.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class AccountSync2 implements Runnable {
    static int i = 0;
    //ֱ��������ʵ������  �����ڵ�ǰʵ��
    public synchronized void increase(){
    	i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
        	increase();
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
    	AccountSync2 instance = new AccountSync2();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}

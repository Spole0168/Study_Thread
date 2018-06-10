package com.thread.currentThreads.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 13 on 2017/5/5.
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
                System.out.println("lock==1 do work"+Thread.currentThread().getId() );
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
                System.out.println("lock==2 do work"+Thread.currentThread().getId() );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":�߳��˳�");
        }

    }

    /**
     * �ж���ӦlockInterruptibly
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        thread2.interrupt();

    }
}

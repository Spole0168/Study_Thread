package com.thread.currentThreads.chapter4;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicInterArrayInt {
    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static void main(String args[]) throws InterruptedException {
    	array.getAndAdd(0, 20);
    	System.out.println(array);
    	AtomicReference<Long> money = new AtomicReference<Long>();
    	
    }
}

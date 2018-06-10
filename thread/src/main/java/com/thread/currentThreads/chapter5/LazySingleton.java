package com.thread.currentThreads.chapter5;

/**
 * Created by 13 on 2017/5/6.
 */
public class LazySingleton {
	public static int  num = 10;
    private LazySingleton() {
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    public static void main(String[] args) {
    	System.out.println(LazySingleton.num);
		Singleton s = Singleton.getInstance();
	}
}

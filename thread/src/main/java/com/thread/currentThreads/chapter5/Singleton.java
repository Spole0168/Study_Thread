package com.thread.currentThreads.chapter5;

/**
 * Created by 13 on 2017/5/6.
 */
public class Singleton {
	public static int  num = 10;
    private Singleton() {
        System.out.println("Singleton is create");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
    public static void main(String[] args) {
		System.out.println(Singleton.num);
		Singleton s = Singleton.getInstance();
	}
}

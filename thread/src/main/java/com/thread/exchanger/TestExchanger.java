package com.thread.exchanger;

import java.util.concurrent.Exchanger;

public class TestExchanger {
	public static class Car extends Thread {
	    private Exchanger<String> exchanger;
	    private String value;

	    public Car(String name,String value,Exchanger<String> exchanger) {
	        super();
	        this.exchanger = exchanger;
	        this.value = value;
	        this.setName(name);
	    }

	    @Override
	    public void run() {
	        try {
	            System.out.println(Thread.currentThread().getName() + ": " + exchanger.exchange("Car-"+value));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public static class Bike extends Thread {
	    private Exchanger<String> exchanger;
	    private String value;
	    public Bike(String name,String value,Exchanger<String> exchanger) {
	        super();
	        this.exchanger = exchanger;
	        this.value = value;
	        this.setName(name);
	    }

	    @Override
	    public void run() {
	        try {
	            System.out.println(Thread.currentThread().getName() + ": " +  exchanger.exchange("Bike-"+value));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	 public static void main(String[] args) {
	        Exchanger<String> exchanger = new Exchanger<>();
	        Car car1 = new Car("Car1","car1 1111111",exchanger);
	        Car car2 = new Car("Car2","car1 222222",exchanger);
	        Bike bike1 = new Bike("Bike1","Bk 1111111",exchanger);
	        Bike bike2 = new Bike("Bike2","Bk 222222",exchanger);
	        Bike bike3 = new Bike("Bike3","Bk 333333",exchanger);
	        car1.start();
	        bike1.start();
	        car2.start();
	        bike2.start();
//	        bike3.start();
	        System.out.println("Main end!");
	    }
}

package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person1 implements Comparable<Person1> {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person1(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Person1 o) {
		
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person1 [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		Person1 person1 = new Person1("zzh", 18);
		Person1 person2 = new Person1("jj", 17);
		Person1 person3 = new Person1("qq", 19);

		List<Person1> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}

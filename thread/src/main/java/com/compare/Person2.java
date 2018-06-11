package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person2 {
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

	public Person2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person2(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person1 [age=" + age + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		Person2 person1 = new Person2("zzh", 18);
		Person2 person2 = new Person2("jj", 17);
		Person2 person3 = new Person2("qq", 19);

		List<Person2> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		Collections.sort(list, new Comparator<Person2>() {

			@Override
			public int compare(Person2 o1, Person2 o2) {
				//根据年龄排序
				if(o1 == null || o2 == null)
                    return 0;
                return o1.getAge()-o2.getAge();
			}
			
		});
		System.out.println("AGE:"+list);
		Collections.sort(list, new Comparator<Person2>() {
			
			@Override
			public int compare(Person2 o1, Person2 o2) {
				//根据姓名排序
				if(o1 == null || o2 == null)
					return 0;
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		System.out.println("Name:"+list);
		
		
	}
}

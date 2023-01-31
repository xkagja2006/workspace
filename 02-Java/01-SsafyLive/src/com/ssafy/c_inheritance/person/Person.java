package com.ssafy.c_inheritance.person;

public class Person {
	String name; 
	
	public Person() {
		
	}
	public Person(String name) {
		this.name = name;
	}
	
	public void eat() {
		
	}
	public void jump() {
		System.out.println("점프");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}

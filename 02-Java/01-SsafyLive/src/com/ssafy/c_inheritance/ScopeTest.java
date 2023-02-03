package com.ssafy.c_inheritance;

class Parent {
	String x = "parent";
	void abc() {
		System.out.println("parent");
	}
}

class Child extends Parent {
	String x = "child";

	void method() {
		String x = "method";
		System.out.println("x : " + x);
		System.out.println("this.x : " + this.x);
		System.out.println("super.x : " + super.x);
	}
	
	void abc() {
		System.out.println("child");
	}
}

public class ScopeTest {

	public static void main(String[] args) {
//		Child child = new Child();
//		child.method();
		
//		Parent parent = new Child();
//		parent.abc();
		
		Parent parent2 = new Parent();
		Child child2 = (Child)parent2;
		
		child2.abc();
	}
}

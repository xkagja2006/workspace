package com.ssafy.c_inheritance;

class Parent2 {
    static void method() {
        System.out.println("parent method");
    }
}

class Child2 extends Parent2 {
/*	@Override
	static void method() {
		System.out.println("child");
	}*/
}

public class StaticOverride {
    public static void main(String[] args) {
        Child2 obj = new Child2();
        obj.method();
    }
}

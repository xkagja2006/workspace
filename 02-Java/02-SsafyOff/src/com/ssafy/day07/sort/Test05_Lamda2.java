package com.ssafy.day07.sort;

//@FunctionalInterface
//interface Parent01 {
//	void call(String msg);
//}

class Child implements Parent01 {
	@Override
	public void call(String msg) {
		System.out.println(msg + ">>");
	}
}

class Child2 implements Parent01 {
	@Override
	public void call(String msg) {
		System.out.println(msg + "}}");
	}
}

public class Test05_Lamda2 {
	 static void test(Parent01 p) {
		p.call("hello");
	}

	public static void main(String[] args) {
		Parent01 p = new Child();
		test(p);

		p = new Child2();
		test(p);

	}
}

package com.ssafy.day02;

public class Dog {
	// 메소드가 끝나고 나서도 name이라는 변수를 사용하고 싶다! -> 클래스의 멤버변수로 선언하고 this.name에 넣어준다.
	// this -> 만들어진 객체(d1, d2)
	String name;
	int age;

	Dog() {
		// Dog("무명", -1); -> 생성자의 호출은 객체를 생성할때만 가능하다.
		this("무명", -1);

//		this.name = "무명";
//		this.age = -1;
	}

	Dog(String name) {
		//System.out.println("다른 생성자 호출하기"); //-> 생성자를 호출하는 경우는 가장 첫줄에서 해야한다.
		// Dog(name, -1);
		this(name, -1);

//		this.name = name;
//		this.age = -1;
	}
	public void print() {
//		this("a",1);	//-> 생성자가 아닌 곳에서 this()메소드를 호출할 수 없다.
	}

	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
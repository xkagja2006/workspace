package com.ssafy.b_abstraction.person;

public class PersonTest1 {
	public static void main(String[] args) {
		System.out.println(Person1.org);
		
		//객체 사용
		Person1 p = new Person1();
		p.org = "SSAFY2";		//모든 객체가 영향받는다!
		p.name = "홍길동";
		p.isHungry = true;
		p.eat();
		
		p.printInfo();
		
		Person1 p2 = new Person1();
		p2.name = "장길산";
		p2.work();
		System.out.println(p2.org);
		p2.printInfo();
	}
}

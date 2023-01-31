package com.ssafy.day03;

class P {
}
class C extends P{
	
}

public class Exam05_형변환 {
	public static void main(String[] args) {
		P p = new P();
		C c = new C();
		
		// 부모는 자식타입을 받을 수 있다.
		P p1 = new C();
		
		// 객체변수 instanceOf 타입 -> true/false
		// p instanceof C -> false
		// c instanceof P -> true
		System.out.println(p instanceof C);
		System.out.println(c instanceof P);
	}
}

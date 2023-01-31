package com.ssafy.day03;

import java.util.Random;

//class MyString extends String {	//String클래스는 final 로 되어있어 상속 불가
//
//}

class MyRandom extends Random{
	public int nextInt(int num) {
		return super.nextInt(num) + 1;
	}
	
}
public class Exam04_final연습2 {
	public static void main(String[] args) {
		Random r = new MyRandom();
		MyRandom r3 = (MyRandom)r;
		
		Random mr = new MyRandom();		//상속관계에 있으면 이렇게 쓸 수도 있음
		int num2 = mr.nextInt(10);
		long num3 = mr.nextLong();
	}
}

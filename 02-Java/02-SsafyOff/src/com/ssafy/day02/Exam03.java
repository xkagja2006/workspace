/*
 * static 블럭
 * - 클래스 정보가 로딩될 때 실행
 * - 형태 : static {}
 */
package com.ssafy.day02;

class StaticSub {
	static int v = 100;
	StaticSub(){
		System.out.println("StaticSub 생성자 호출");
	}
	static {
		System.out.println("클래스 정보가 로딩될 때 실행");
	}

}

public class Exam03 {
	public static void main(String[] args) {
		System.out.println("main start-----");
		System.out.println(StaticSub.v);
		StaticSub ss = new StaticSub();
		StaticSub ss2 = new StaticSub();
		System.out.println("ss객체 생성  후 메인 메서드");
	}
}

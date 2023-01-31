package com.ssafy.day02;
/*
 * 생성자
 * 
 * - 호출되는 시점 : 객체가 생성될 때
 * - 일반 메서드(인스턴스 메서드)와의 차이
 * 		: 일반 메서드는 객체가 생성된 이후에 호출됨. 생성자 메서드는 생성시 한번만 호출이 가능.
 * 		
 * 타입 a = new 타입();
 * 
 * - 생성자의 특징
 * 1. 이름이 클래스와 동일하다.
 * 2. 반환타입이 없다. (void가 아니라 아예 없음. void를 붙이면 반환타입이 있기때문에 생성자로 취급하지 않음)
 * 3. 디폴트 생성자
 * 		형태 : 클래스접근제한자 클래스명() - 매개변수가 없는 형태
 * 		조건 : 클래스에 정의된 생성자가 없을 경우
 * 4. 오버로딩 지원한다.
 * 5. this 사용법
 * 		this.변수, this.메서드(), this()
 * 
 * 	  this 사용시 제약
 * 		- this.변수 또는 메서드의 호출은 static영역에서는 사용이 불가능하다.
 * 		- this() 생성자 호출은 생성자 안에서만 호출이 가능하다. 생성자 안에서 첫번째 구문으로 호출되어야 한다. 
 * 		
 */
public class Exam02 {
	int val = 100;
	static int val2 = 200;
	
	public static void main(String[] args) {
//		Dog d1 = new Dog("쪼");
//		Dog d2 = new Dog("쪼쪼", 3);
		
		Exam02 exam = new Exam02();
		System.out.println(exam.val);	//인스턴스 변수는 객체를 생성해야만 접근할 수 있다.
		System.out.println(Exam02.val2);//클래스 변수는 클래스로 접근한다.

	}
}

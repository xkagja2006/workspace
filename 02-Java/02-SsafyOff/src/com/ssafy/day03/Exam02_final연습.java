package com.ssafy.day03;

interface A{		//interface안의 모든 것에는 public속성이 붙는다.
	public static final String SERVER_IP = "192.168.0.1";	//모두가 같은 값을 사용해야 할 때 static final
	void print();
}
class Parent{
	public final void call() {};
}
class Child extends Parent implements A{
	final int val;
	Child(int val){	//생성자를 통해 final변수를 초기화 할 수 있다.
		this.val = val;
	}
	
	public void print() {
		System.out.println(A.SERVER_IP);
	};
	
/*	@Override
	public void call() {
		System.out.println("재정의된 메소드");
	}*/
}

// 접근제한자 : public, default package
// 활용관련 : final, abstract
public final class Exam02_final연습 {
	public static void main(String[] args) {
		Child c = new Child(11);
		c.call();
	}
	
	
	//final 키워드
	/*
	 * 변수 : 값의 할당을 한번만 할 수 있다(선언시, 선언시 값이 없을경우 생성자를 통해 할당) -> 상수 처리
	 * 메서드 : 오버라이딩 금지, 더이상 내용 변경 불가
	 * 클래스 : 상속 금지
	 */
	
	// 내부클래스는 멤버변수처럼 사용한다.
	// -> 접근제한자 4가지 모두 가능.
	class Inner {
	}

	/*
	 * 메소드에 불일 수 있는 것들
	 * 접근제한자 : 4가지 모두 가능(public, protected, default package, private)
	 * 활용제한자 : final, abstract, static, synchronized 가능
	 */

}

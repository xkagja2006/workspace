package com.ssafy.day03;

class Single {
	// 제공된 생성자를 건드리지 마시오
	// 추가 생성자를 작성하지 마시오
	private Single() {}

/*	싱글톤 디자인 패턴
 * 	private static Single instance = new Single();
	public static Single getInstance() {
		return instance;
	}
*/
	private static Single instance;
	public synchronized static Single getInstance() {	//	synchronized : 동시에 접근 불가능하게 한다
		if (instance == null) {
			instance = new Single();
		}
		return instance;
	}
}

public class Quiz {
	public static void main(String[] args) {
		Single s = Single.getInstance();
//		Single s1 = (Single) new Object(); -> Object클래스에 Single정보가 없어서 에러가 남!
	}
}

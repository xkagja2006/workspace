package com.ssafy.d_encapsulation.p1;

// TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
    // END:
class SamePackageChildClass extends Parent{
	public void test() {
		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;
//		this.privVar = 10;	//상속과 상관없이 접근제한자의 영향에 따라 사용여부 결정된다.
		
	}
}

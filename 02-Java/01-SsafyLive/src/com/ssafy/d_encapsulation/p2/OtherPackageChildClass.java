package com.ssafy.d_encapsulation.p2;

import com.ssafy.d_encapsulation.p1.Parent;

// TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
class OtherPackageChildClass extends Parent {
	public void test() {
		this.publicVar = 10;
		this.protectVar = 10;
	}

	// END:
}

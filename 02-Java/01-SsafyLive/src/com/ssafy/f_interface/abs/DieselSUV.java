package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
public class DieselSUV extends Vehicle{
	@Override
	public void addFuel() {
		System.out.println("주유소에서 주유!");
	}
}

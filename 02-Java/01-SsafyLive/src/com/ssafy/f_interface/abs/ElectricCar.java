package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
public class ElectricCar extends Vehicle{
	@Override
	public void addFuel() {
		System.out.println("충전");
	}
}
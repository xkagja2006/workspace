package com.ssafy.f_interface.abs;

public class VehicleTest {

  public static void main(String[] args) {
    // TODO: DieselSUV와 ElectricCar를 각각 한대씩 관리하는배열을 만들고 사용해보자.
	  Vehicle[] v = {new DieselSUV(), new ElectricCar(), new HorseCart()};
	  for(Vehicle x : v) {
		  x.reportPosition();
		  x.addFuel();
	  }
  }

}

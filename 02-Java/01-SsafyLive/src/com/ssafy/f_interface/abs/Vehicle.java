package com.ssafy.f_interface.abs;

public abstract class Vehicle {
	private int curX, curY;
	
	public void reportPosition() {
		System.out.printf("νμ¬ μμΉ : %d, %d\n", this.curX, this.curY);
	}
	
	public abstract void addFuel();
}

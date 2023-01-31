package com.ssafy.f_interface.abs;

public class Ironman implements Heroable{

	@Override
	public void changeShape(boolean isHereMode) {
		// TODO Auto-generated method stub
		System.out.println("모양 변경");
	}

	@Override
	public int fire() {
		System.out.println("발사");
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void upgrade() {
		System.out.println("버전up");
		// TODO Auto-generated method stub
		
	}

}

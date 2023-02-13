package com.ssafy.day0210;

public class 조합 {
	public static void main(String[] args) {
		for(int i = 0; i < Math.pow(2, 3); i++) {		//0승, 1승, 2승  : 000 ~ 111  1<<3 == pow(2,3)
			System.out.println(i);
		}
	}
}

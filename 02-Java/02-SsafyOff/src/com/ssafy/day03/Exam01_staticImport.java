package com.ssafy.day03;

import static java.lang.Math.*;

public class Exam01_staticImport {
	public static void main(String[] args) {
		System.out.println(Math.max(1, 2));		//Math클래스로 바로 접근했기 때문에 max는 static 선언임을 알 수 있다!
		System.out.println(max(1,2));		//static임포트를 하면 Math클래스의 static 함수를 바로 사용할 수 있다.
		
	}
}

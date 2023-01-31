package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.Person;
import com.ssafy.c_inheritance.person.SpiderMan;

class Venom extends SpiderMan{
	public Venom() {
		super("",true);
	}
}

public class PolyTest {
	public static void main(String[] args) {
		SpiderMan onlyOne = new SpiderMan("a", false);
		
		SpiderMan sman = onlyOne;
		
		//조상 타입으로 자식 객체 참조!
		Person person = onlyOne;
		
		Object obj = onlyOne;
		
//		Venom v = onlyOne;	//안됨!
	}
}

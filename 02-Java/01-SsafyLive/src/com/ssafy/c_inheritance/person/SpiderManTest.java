package com.ssafy.c_inheritance.person;

public class SpiderManTest {
	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan("피터파커", false);
		sman.isSpider = false;
		sman.name = "피터파커";
		sman.eat();
		sman.jump();
		sman.fireWeb();
		
		
		Person p = new SpiderMan("피터", true);
		p.jump();
		System.out.println(sman.toString());
	}
}

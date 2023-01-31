package com.ssafy.c_inheritance.person;

public class SpiderMan extends Person{
	boolean isSpider;
	Spider spider;
	public SpiderMan(String name, boolean isSpider) {
		//super();
//		this.name = name;
		super(name);	//조상 생성자 호출
		this.isSpider = isSpider;
		spider = new Spider();
	}
	
	void fireWeb() {
		if(isSpider)
			spider.fireWeb();
		else
			System.out.println("흑흑");
	}
	
	public void jump(){
		if(isSpider)
			spider.jump();
		else
			super.jump();
	}

	@Override
	public String toString() {
		return "SpiderMan [isSpider=" + isSpider + ", spider=" + spider + ", toString()=" + super.toString() + "]";
	}
	
	

}

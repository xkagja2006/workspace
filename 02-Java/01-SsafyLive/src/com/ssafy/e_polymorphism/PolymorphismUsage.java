package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.Person;
import com.ssafy.c_inheritance.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // TODO:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.
    	Object[] objs = new Object[4];
    	objs[0] = "Hello";
    	objs[1] = new Person();
    	objs[2] = new SpiderMan("",false);
    	objs[3] = 3;	//autoboxing (int -> Integer)
//    	objs[3] = Integer.valueOf(3);
    	
    	for(int i = 0; i < objs.length; i++) {
    		System.out.println(objs[i].getClass().getName());
    	}
    	
    	int a = 10;
    	Integer aobj = a;	//int -> Integer : autobosing
//    	int sum = a+aobj.intValue();
    	int sum = a+aobj;	//Integer -> int : unboxing
    	
    	Object obj =  objs[1];
    	//obj. -> Object클래스의 기능만 쓸 수 있음
    	if(obj instanceof Person) {
    		Person p = (Person)obj;
    		System.out.println(p.toString());
    		p.jump();
    	}
    	else {
    		System.out.println(obj.getClass().getName());
    	}
    	
    	SpiderMan sman2 = new SpiderMan("피터파커", true);
    	System.out.println(sman2);		//동적바인딩으로 SpiderMan의 toString함수가 호출된다. -> println하고 toString은 무슨 관계지?!
    	
    }

    public void useObjectParam() {
        System.out.println(1);
        System.out.println("Hello");
        System.out.println(new Person());
        System.out.println(new SpiderMan("지영",true));
    }

    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        usage.useObjectArray();
//        usage.useObjectParam();
    }
}

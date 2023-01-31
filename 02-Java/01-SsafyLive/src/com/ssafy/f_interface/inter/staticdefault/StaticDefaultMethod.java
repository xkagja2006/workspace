package com.ssafy.f_interface.inter.staticdefault;

interface Aircon {
    void makeCool();

    // TODO: 2. 건조기능을 추가해보자.
    default void dry() {}
    // END:

    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void info() {
    	System.out.println("냉매이용");
    }
    // END:

}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NoWindAricon implements Aircon{

	@Override
	public void makeCool() {
		System.out.println("무풍");
	}
	@Override
	public void dry() {
		System.out.println("종료 시 자동건조");
	}
	
}
// END:

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { new OldisButGoodies1(), new OldisButGoodies2() };
        for (Aircon aircon : aircons) {
            if (aircon == null) {
                continue;
            }
            aircon.makeCool();
        }
    }
}

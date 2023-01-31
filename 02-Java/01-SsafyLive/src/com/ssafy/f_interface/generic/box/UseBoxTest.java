package com.ssafy.f_interface.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
    	NumberBox<Number> box = new NumberBox<>();
    	
    	NumberBox<Integer> box2 = new NumberBox<>();	//Integer는 Number를 상속받는다.
    	box.addSomes(0,1,2,4,1); 
    	
//    	NumberBox<String> box3 = new NumberBox<>();
    }

}

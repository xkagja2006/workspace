package com.ssafy.day05.box;
/*
 * 장점 : 여러 데이터 타입을 하나의 박스로 저장할 수 있다.
 * 
 * 단점 : 특정 용도(데이터타입)로 사용하기 위한 제한이 어렵다.
 * 		-> 원치 않는 타입의 데이터가 들어가는 것을 체크할 수 없다.(실행 전까지 모름)
 *		데이터를 꺼내쓸때 내가 입력한 데이터 타입으로 형변환 해서 사용해야 한다.
 *		-> getData의 반환형이 Object이기 때문에.
 */

class Box02 {
	private Object data;

	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}

}

public class Box02Test {
	public static void main(String[] args) {
		Box01 box = new Box01();
	}
}

/*
 * Generics - 1.5버전부터
 * 
 * 장점 : - 여러 데이터 타입을 하나의 박스로 저장할 수 있다.
 * 		- 특정 용도(데이터타입)로 사용하기 위한 제한이 가능.
 * 		- 원치 않는 타입의 데이터가 들어가는 것을 체크할 수 있다.(컴파일시에)
 *		- 데이터를 꺼내쓸때 내가 입력한 데이터 타입으로 형변환 안하고 사용한다.
 */
package com.ssafy.day05.box;
/*
 * 타입 파라미터이름으로 권장되는것
 * T : type
 * E : element
 * K : key
 * V : value
 * N : number
 * 
 * 제너릭을 적용하지 못하는 경우
 * - static선언하는 변수에는 사용 불가능(static은 공용사용이기때문)
 * - 배열 선언은 가능하지만 생성은 불가능. (new T 처럼 사용 불가능)
 */
class Box03<T> {		// 사용하는 쪽 : Box<String>, Box<Integer> 
	private T data;

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

}

public class Box03Test {
	public static void main(String[] args) {
		Box03<String> box = new Box03<String>();
		box.setData("asd");
//		box.setData(123); 	//잘못된 데이터타입인지 컴파일 시 체크
		
		Box03<Integer> box2 = new Box03<Integer>();
		box2.setData(123);
	}
}

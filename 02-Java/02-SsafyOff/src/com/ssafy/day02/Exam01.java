package com.ssafy.day02;

/*
 * 오버로딩 vs 오버라이딩(재정의 -> 상속관계에서 발생)
 * 
 * 객체지향의 특징 : 다형성
 * - 메소드의 이름은 동일하지만 하는 일이 다른 것.
 * 
 * 오버로딩 : 메소드 명은 같지만 매개변수의 타입이나 갯수를 다르게 설정하는 것. 반환타입은 달라도 된다. 
 */

/*
 * Exam01 e = new Exam01();
 * println(e)
 * println(Object o) -> Object : 모든 클래스의 부모관계
 */

public class Exam01 {
	static void printArray(int[] arr) {
		printArray(arr, 0, arr.length);
	}

	static void printArray(int[] arr, int begin) {
		printArray(arr, begin, arr.length);
	}

	static void printArray(int[] arr, int begin, int end) {
		for (int i = begin; i < end; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		
		int season = 10;
		switch(season) {
		case 12:
		case 1:
		case 2:
		
		}
		
		printArray(new int[] { 1, 10, 100 });
		printArray(new int[] { 1, 10, 100 }, 1);
		printArray(new int[] { 1, 10, 100 }, 1, 2);
	}
}

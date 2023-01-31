package com.ssafy.startcamp;

import java.util.Arrays;

class Ssafy{
	String name;
}

public class Test04_배열의초기화 {
	
	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	static void print(int v) {
		System.out.println(v*v);
	}
	
	public static void main(String[] args) {
		
//		int[] a = {1,2,3,4};
//		print(a);
//		print({1,2,3,4});	//선언과 함께 쓰이지 않아서 에러남
		print(new int[]{1,2,3,4});	//가능(단독사용가능)
		
//		int k = 100;
//		print(k);
		print(100);
		
		Ssafy s1;	//s1은 주소를 담는 변수!(클래스 변수니깐)
		//System.out.println(s1);	//초기화에러남
		s1 = new Ssafy();
		System.out.println("s1 : " + s1);	//에러안남(new로 새로운 공간을 생성해 자동초기화됨)
		{
			int arr[] = new int[3];	//생성과 동시에 자동초기화 -> 새로운 공간을 생성할때 자동으로 초기화함
			//참조형은 자동초기화 null값.
			//int형은 자동초기화 0
			System.out.println(arr[1]);	//int형 자동초기화로 0이 출력됨
			arr[1] = 100;
		}
		Integer[] arr2 = new Integer[2];
		System.out.println(arr2[0]);	//Integer형은 기본형이 아니므로 null로 자동초기화됨
		
		Ssafy arr3[] = new Ssafy[2];
		System.out.println(arr3[1]);	//null값 출력.
		
		int arr4[][] = new int[3][];
		System.out.println(arr4[0]);	//null값 출력. 배열을 담는 배열(2차원배열) -> 참조형 초기화로 null / [3][2]로 초기화 시 주소값 출력됨
		
		//3가지 배열 값 초기화 방법
		{
			int[] arr = new int[3];
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 3;
		}
		{
			int[] arr = {1,2,3};	//초기 선언시점에서만 사용 가능
		}
		{
			int[] arr = new int[]{1,2,3};	//변수 선언 후에도 사용 가능
			arr = new int[]{10,20,30};
		}
		
	}
}

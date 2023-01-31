package com.ssafy.startcamp;

import java.util.Arrays;

public class Test06_배열요소확인 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		System.out.println("1.4까지 주로 사용");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("1.5버전에 추가된 향상된 for문");
		for(int x : arr) {		//x는 수정 불가. read only.
			System.out.println(x);
		}
		
		System.out.println("1.5버전에 추가된 Arrays.toString");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("1.8버전에 추가된 Arrays.stream");	//람다식. 함수형 프로그래밍, stream api
		Arrays.stream(arr).forEach(v -> System.out.println(v));
		System.out.println("stream2");
		Arrays.stream(arr).forEach(System.out::println);
		
		int[][] arr2 = {
				{1},
				{2,3}
		};
		System.out.println(Arrays.toString(arr2));	//arr2배열의 주소값 (2차원배열의 주소값)
		System.out.println(Arrays.deepToString(arr2));
	}
}

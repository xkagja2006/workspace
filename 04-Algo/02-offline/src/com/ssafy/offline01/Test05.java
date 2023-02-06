package com.ssafy.offline01;

public class Test05 {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		//search 함수를 재귀를 이용하여 구현
		// 3 -> 1(인덱스 반환)
		// 4 -> -1반환
		int idx = 1;
		System.out.println(search(idx, arr, arr.length));
	}

	private static int search(int idx, int[] arr, int len) {
		if(len == 0) 
			return -1;
		if(idx == arr[len-1])
			return len-1;
		return search(idx, arr, len-1);
	}
}

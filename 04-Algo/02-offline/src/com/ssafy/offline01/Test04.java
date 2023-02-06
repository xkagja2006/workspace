package com.ssafy.offline01;

public class Test04 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9 };
		System.out.println(solve(arr.length, arr));
	}

	private static int solve(int len, int[] arr) {
		if (len == 1)
			return arr[len-1];

		return arr[len-1] + solve(len - 1, arr);
	}
}



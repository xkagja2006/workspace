package com.ssafy.offline01;

public class Test06 {
	public static void main(String[] args) {
		System.out.println(result);		//factorial2함수 실행 결과
		System.out.println(factorial3(4));
	}

	private static int factorial3(int n) {
		if (n == 1)
			return 1;
		return n*factorial3(n-1);
	}
	
	static int result = 1;
	private static void factorial2(int n) {
		if (n == 0)
			return;
		result *= n;
		factorial2(n - 1);
	}

	private static int factorial1(int n) {
		int result = 1;
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		return result;
	}

}

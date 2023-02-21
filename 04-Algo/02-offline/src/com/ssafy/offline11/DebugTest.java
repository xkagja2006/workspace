package com.ssafy.offline11;

public class DebugTest {
	static int sum;
	static int[][] map = { { 1, 2, 3, 4 }, { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 } };

	public static void main(String[] args) {
		debug();
		call2();
	}

	private static void call2() {
		int a = 10;
		a += 10;
		a += 20;
		System.out.println(a);
	}

	private static void debug() {
		call(10);
		System.out.println(sum);
	}

	private static void call(int n) {
		if (n == 0)
			return;
		sum += n;
		call(n-1);
	}
}

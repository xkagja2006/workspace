package com.ssafy.offline01;

public class Quiz02 {
	public static void main(String[] args) {
		System.out.println(solve(100, "")); 	//1100100
	}

	private static String solve(int i, String string) {
		if(i/2 < 1)
			return ""+ i%2;
		return  solve((i/2), string) + (""+ (i%2));
	}
}

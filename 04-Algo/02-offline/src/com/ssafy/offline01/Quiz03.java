package com.ssafy.offline01;

public class Quiz03 {
	public static void main(String[] args) {
		/*
		 * 00
		 * 01
		 * 10
		 * 11
		 */
		solve(2, "");
		/*
		 * 000
		 * 001
		 * 010
		 * 100
		 * 101
		 * 110
		 * 111
		 */
		solve(3, "");
	}

	private static void solve(int i, String string) {
		if(i==0) {
			System.out.println(string);
		}
		
	}
}

package com.ssafy.offline04;

import java.util.Arrays;
import java.util.Scanner;

public class bj_12891_DNA비밀번호 {
	static int[][] arr; // {‘A’, ‘C’, ‘G’, ‘T’}
	static int[] cnt = new int[4];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int strlen = sc.nextInt();
		int len = sc.nextInt();
		String str = sc.next();
		for(int i = 0; i < 4; i++) {
			cnt[i] = sc.nextInt();
		}
		find(0);
	}
	private static void find(int c) {
		
	}
}

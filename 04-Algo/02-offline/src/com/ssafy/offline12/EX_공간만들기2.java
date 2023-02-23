package com.ssafy.offline12;

import java.util.Scanner;

public class EX_공간만들기2 {
	static int[][] spaces;

	// 주어진 영역의 공간의 셀 체크하여 모두 0, 1로 이루어져있는지 확인 후
	// 4개로 쪼개기.

	static void cut(int r, int c, int size) {
		int sum = 0;
		for (int i = r, rEnd = r + size; i < rEnd; i++) {
			for (int j = c, cEnd = c + size; j < cEnd; j++) {
				sum += spaces[i][j];
			}
		}

		if (sum == size * size) { // 모두 1
			System.out.print("1");
		} else if (sum == 0) { // 모두 0
			System.out.print("0");
		} else { // 혼합됨
			int half = size / 2;
			System.out.print("(");
			cut(r, c, half);
			cut(r, c + half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);
			System.out.print(")");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		spaces = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				spaces[i][j] = str.charAt(j)-'0';
			}
		}
		
		cut(0,0,n);

		sc.close();
	}
}

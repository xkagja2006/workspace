package com.ssafy.offline03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_2805_농작물수확하기 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input2805.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}

			int r = N / 2;
			int c = N / 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(r - i) + Math.abs(c - j) <= N / 2) {
						ans += map[i][j];
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}

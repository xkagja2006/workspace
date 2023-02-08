package com.ssafy.offline03;

import java.util.Arrays;
import java.util.Scanner;

public class sw_1954_달팽이숫자 {
	static int N;
	static int[][] arr;
	static int NUMBER;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			NUMBER = 1;
			N = sc.nextInt();
			arr = new int[N][N];
			snail(arr, 0, N);

			System.out.println("#" + (i + 1));
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println("");
			}
		}

	}

	private static void snail(int[][] arr, int start, int len) {
		if (len <= 0) {
			return;
		}
		for (int i = 0; i < len; i++) {
			arr[start][start + i] = NUMBER++;
		}
		for (int i = 0; i < len - 1; i++) {
			arr[start + 1 + i][start + len - 1] = NUMBER++;
		}
		for (int i = 0; i < len - 1; i++) {
			arr[start + len - 1][start + len - 2 - i] = NUMBER++;
		}
		for (int i = 0; i < len - 2; i++) {
			arr[start + len - 2 - i][start] = NUMBER++;
		}
		snail(arr, (start + 1), (len - 2));
	}
}

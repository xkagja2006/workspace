package com.ssafy.offline07;

import java.util.Scanner;

public class bj_16926_배열돌리기1 {
	static int N, M, C;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < C; i++) {
			rotate();
		}
		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	private static void rotate() {
		for (int t = 0; t < Math.min(N / 2, M / 2); t++) {
			int maxN = N - t - 1;
			int maxM = M - t - 1;
			int tmp = arr[t][t];
			// 위
			for (int i = t; i < maxM; i++) {
				arr[t][i] = arr[t][i + 1];
			}
			// 오
			for (int i = t; i < maxN; i++) {
				arr[i][maxM] = arr[i + 1][maxM];
			}
			// 아래
			for (int i = maxM; i > t; i--) {
				arr[maxN][i] = arr[maxN][i - 1];
			}
			// 왼
			for (int i = maxN; i > t; i--) {
				arr[i][t] = arr[i - 1][t];
			}
			arr[t + 1][t] = tmp;
		}
	}
}

package com.ssafy.offline03;

import java.util.Scanner;

public class bj_2798_블랙잭2 {
	static int N, M;
	static int[] data;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		data = new int[N];
		for (int i = 0; i < N; i++)
			data[i] = sc.nextInt();

		comb(0, 0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int sum) {
		if (sum > M)
			return;
		if (cnt == 3) {
			ans = Math.max(sum, ans);
			return;
		}

		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1, sum + data[i]);
		}
	}
}

package com.ssafy.offline03;

import java.util.Scanner;

public class bj_15652_N과M4 {
	static int N, M;
	static int[] numbers, inputs;

//1~N까지 중복가능하게 M개를 고른 수열 -> 조합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = i + 1;
		}

		combi(0, 0);
	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			for (int x : numbers)
				System.out.print(x + " ");
			System.out.println("");
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt + 1, i);
		}
	}
}


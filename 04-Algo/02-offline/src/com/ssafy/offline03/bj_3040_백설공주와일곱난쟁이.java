package com.ssafy.offline03;

import java.util.Scanner;

public class bj_3040_백설공주와일곱난쟁이 {
	static int N, M;
	static int[] numbers, inputs;

//1~N까지  M개를 고른 수열 -> 조합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 9;
		M = 7;
		numbers = new int[M];
		inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}

		combi(0, 0);
	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
			for (int x : numbers)
				sum += x;
			if(sum == 100) {
				for (int x : numbers)
					System.out.println(x);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			combi(cnt + 1, i+1);
		}
	}
}
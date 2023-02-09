package com.ssafy.live04;

import java.util.Scanner;

public class SubSetSumTest {
	static int N, S, totalCnt;
	static int[] input; // 입력받은 수들
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();	//목표 합
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; ++i) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0);
		System.out.println("총 경우의 수 : " + totalCnt++);
	}

	private static void generateSubSet(int cnt) { // 직전까지 고려된 원소 수

		if (cnt == N) {
			int sum = 0;
			//부분집합들의 요소들의 합 구하기
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) sum += input[i];
			}
			if(sum == S) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print((isSelected[i] ? input[i] : "X") + "\t");
				}
				System.out.println();
			}
			return;
		}

		// 현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt + 1);

		// 현재 원소를 부분집합의 구성에 미포함
		isSelected[cnt] = false;
		generateSubSet(cnt + 1);
	}
}

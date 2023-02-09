package com.ssafy.offline04;

import java.util.Scanner;

public class bj_2961_도영이가만든맛있는음식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] taste = new int[T][2];
		for (int i = 0; i < T; i++) {
			taste[i][0] = sc.nextInt(); // 신맛
			taste[i][1] = sc.nextInt(); // 쓴맛
		}

		int result = Integer.MAX_VALUE;
		
		for (int i = 1; i < (1 << T); i++) {
			int sSum = 1;
			int bSum = 0;
			for (int j = 0; j < T; j++) {
				if ((i & (1 << j)) == 0) continue;
				sSum *= taste[j][0];
				bSum += taste[j][1];
			}
			result = Math.min(result, Math.abs(sSum - bSum));
		}
		System.out.println(result);
	}
}

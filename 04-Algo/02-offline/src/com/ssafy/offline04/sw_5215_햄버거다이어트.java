package com.ssafy.offline04;

import java.util.Arrays;
import java.util.Scanner;

public class sw_5215_햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int L = sc.nextInt();		//제한 칼로리
			int[][] data = new int[N][2];
			for (int n = 0; n < N; n++) {
				data[n][0] = sc.nextInt();
				data[n][1] = sc.nextInt();
			}
			int ans = 0;
			for (int i = 1; i < (1 << N); i++) { // i는 각각 집합의 경우의 수
				int tSum = 0, cSum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) == 0) continue;
					tSum += data[j][0];
					cSum += data[j][1];
				}
				if(cSum <= L) ans = Math.max(ans, tSum);
			}
			System.out.println(ans);
		}
	}
}

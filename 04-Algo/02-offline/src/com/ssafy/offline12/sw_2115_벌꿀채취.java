package com.ssafy.offline12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_2115_벌꿀채취 {
	static int N, M, C, ans; // 통크기, 선택벌통수, 꿀의최대양, 테게정답
	static int[][] map, profit;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/data2115.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			profit = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			setProfit(); // 각 좌표에서의 최대 이익
			setPosition(); // 조합의 자리 결정
			System.out.println("#" + t + " " + ans);
			ans = 0;
		}
	}

	static void setPosition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// 일꾼 1의 위치, map[i][j]
				// 일꾼 2의 위치 : 같은 행일때
				for (int c = j + M; c <= N - M; c++)
					ans = Math.max(ans, profit[i][j] + profit[i][c]);

				// 다른행일때
				for (int r = i + 1; r < N; r++)
					for (int c = 0; c <= N - M; c++)
						ans = Math.max(ans, profit[i][j] + profit[r][c]);
			}
		}
	}

	static void setProfit() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= N - M; j++)
				setMaxProfit(i, j, 0, 0, 0);
	}

	static void setMaxProfit(int i, int j, int cnt, int cSum, int pSum) {
		if (cSum > C)
			return;
		if (cnt == M) {
			profit[i][j - M] = Math.max(profit[i][j - M], pSum);
			return;
		}
		setMaxProfit(i, j + 1, cnt + 1, cSum, pSum); // 선택하지 않음
		setMaxProfit(i, j + 1, cnt + 1, cSum + map[i][j], pSum + map[i][j] * map[i][j]); // 선택했음
	}
}

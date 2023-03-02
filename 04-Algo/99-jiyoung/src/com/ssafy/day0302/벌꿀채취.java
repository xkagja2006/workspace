package com.ssafy.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취 {
	static int N, M, C, ans;
	static int[][] map;
	static int[][] profit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			profit = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			// map의 각 원소를 시작으로 했을때 얻을 수 있는 최대 이익을 각 profit 배열에 넣자.
			setProfit();

			// 조합으로 profit배열의 어떤 원소 2개를 선택해야할지 구한다.
			setPosition();
			System.out.println(ans);
			ans = 0;
		}

	}

	private static void setPosition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// 같은 행에 있을 경우
				for (int k = j + M; k <= N - M; k++) {
					ans = Math.max(ans, profit[i][j] + profit[i][k]);
				}

				// 다른 행에 있을 경우
				for (int c = i + 1; c < N; c++) {
					for (int r = 0; r <= N - M; r++) {
						ans = Math.max(ans, profit[i][j] + profit[c][r]);
					}
				}

			}
		}
	}

	private static void setProfit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				setMaxProfit(i, j, 0, 0, 0);
			}
		}
	}

	// M개의 벌통의 꿀의 합이 C를 넘지 않을 때, 각 꿀의 양의 제곱의 합이 최대가 되는 경우를 구한다
	// -> 조합으로 모든 경우를 찾아본다.
	private static void setMaxProfit(int c, int r, int cnt, int cSum, int pSum) {
		if (cSum > C)
			return;
		if (cnt == M) {
			profit[c][r - M] = Math.max(profit[c][r - M], pSum);
			return;
		}
		setMaxProfit(c, r + 1, cnt + 1, cSum, pSum);
		setMaxProfit(c, r + 1, cnt + 1, cSum + map[c][r], pSum + map[c][r] * map[c][r]);
	}
}

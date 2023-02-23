package com.ssafy.offline13;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_6987_월드컵_풀이 {
	static int ans;
	static int[][] matches = new int[15][2];
	static int[][] result = new int[6][3];
	static int[][] data = new int[6][3];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input6987.txt"));
		Scanner sc = new Scanner(System.in);

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				matches[idx++] = new int[] { i, j };

			}
		}

		for (int i = 0; i < 4; i++) {
			int score = 0;
			for (int j = 0; j < 6; j++) {
				data[j] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() };
				score += data[j][0] + data[j][1] + data[j][2];
			}
			if (score == 30) {
				dfs(0);
			}
			System.out.println(ans);
			ans = 0;
		}
	}

	private static void dfs(int cnt) {
		if(cnt == 15) {
			if(Arrays.deepToString(result).equals(Arrays.deepToString(data))) {
				ans = 1;
			}
			return;
		}
		
		int t1 = matches[cnt][0], t2 = matches[cnt][1];
		// t1 승, t2 패
		result[t1][0]++; 
		result[t2][2]++; 
		dfs(cnt + 1);
		// 이겼던 게임 원상복귀 시키기
		result[t1][0]--; 
		result[t2][2]--; 
		
		// t1 무, t2 무
		result[t1][1]++; 
		result[t2][1]++; 
		dfs(cnt + 1);
		result[t1][1]--; 
		result[t2][1]--; 
		
		// t1 패, t2 승
		result[t1][2]++; 
		result[t2][0]++; 
		dfs(cnt + 1);
		result[t1][2]--; 
		result[t2][0]--; 
	}
}

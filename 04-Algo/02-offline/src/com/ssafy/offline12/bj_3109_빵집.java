package com.ssafy.offline12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_3109_빵집 {
	static String[][] map;
	static boolean[][] visited;
	static int R, C, ans;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input3109.txt"));
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++)
			map[i] = sc.next().split("");
		System.out.println(Arrays.deepToString(map));

		for(int i = 0; i < C; i++) {
			int t = 0;
			dfs(i, 0, t);
			ans += t;
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int t) {
		if(t != 0) return;
		// 정답인 경우
		if (c == C - 1) {
			t++;
			return;
		}

		// 위쪽 대각선
		else if (r - 1 >= 0 && c + 1 < C && map[r - 1][c + 1].equals(".")) {
			dfs(r - 1, c + 1, t);
		}

		// 오른쪽
		else if (c + 1 < C && map[r][c + 1].equals(".")) {
			dfs(r, c + 1, t);
		}

		// 아래 대각선
		else if (r + 1 < R && c + 1 < C && map[r + 1][c + 1].equals(".")) {
			dfs(r + 1, c + 1, t);
		} else
			return;
	}
}

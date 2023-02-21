package com.ssafy.offline12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_3109_빵집 {
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 0, 1 };
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

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int x, int y) {
		while (true) {
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx == R || ny == C || nx == -1 || ny == -1)
					return;
				if (visited[nx][ny])
					return;
				if (map[nx][ny].equals("x"))
					return;
				visited[nx][ny] = true;
				if (ny == C - 1) {
					ans++;
					return;
				}
				dfs(nx, ny);
			}
		}
	}
}

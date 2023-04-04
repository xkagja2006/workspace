package 역량평가준비.d0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_3085_사탕게임 {
	static String map[][];
	static boolean visited[][];
	static int N, max, ans;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N - 1; y++) {
				swap(x, y, x, y + 1);
				count(x, y);
				swap(x, y, x, y + 1);
			}
		}

		for (int x = 0; x < N - 1; x++) {
			for (int y = 0; y < N; y++) {
				swap(x, y, x + 1, y);
				count(x, y);
				swap(x, y, x + 1, y);

			}
		}
		System.out.println(max == Integer.MIN_VALUE ? N : max);
	}

	private static void count(int x, int y) {
		// 연속 사탕 개수세기
		// 세로의 합 구하기(행의 합)
		int tot = 1;
		for (int c = 1; c < N; c++) {
			String now = map[c][y];
			String next = map[c - 1][y];
			if (now.equals(next)) {
				tot += 1;
				max = Math.max(max, tot);
			} else {
				tot = 1;
			}
		}

		if (y + 1 < N) {
			tot = 1;
			for (int c = 1; c < N; c++) {
				String now = map[c][y + 1];
				String next = map[c - 1][y + 1];
				if (now.equals(next)) {
					tot += 1;
					max = Math.max(max, tot);
				} else {
					tot = 1;
				}
			}
		}

		// 가로의 합 구하기(행의 합)
		tot = 1;
		for (int r = 1; r < N; r++) {
			if (map[x][r].equals(map[x][r - 1])) {
				tot += 1;
				max = Math.max(max, tot);
			} else {
				tot = 1;
			}
		}

		if (x + 1 < N) {
			tot = 1;
			for (int r = 1; r < N; r++) {
				if (map[x + 1][r].equals(map[x + 1][r - 1])) {
					tot += 1;
					max = Math.max(max, tot);
				} else {
					tot = 1;
				}
			}
		}

	}

	private static void swap(int x, int y, int x2, int y2) {
		String temp = map[x][y];
		map[x][y] = map[x2][y2];
		map[x2][y2] = temp;
	}

}

package com.ssafy.offline14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이지영_BOJ_4963_섬의개수 {
	static int[][] map;
	static int W = -1;
	static int H = -1, ans;
	static BufferedReader br;
	static StringTokenizer st;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine().toString();
			st = new StringTokenizer(str, " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0)
				break;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) { // 현재 탐색 위치가 땅이면 큐에 좌표 넣음. bfs실행
					if (map[i][j] == 1) {
						int[] hw = { i, j };
						q.offer(hw);
						bfs();
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	// 8방탐색 왼쪽 위, 위, 오른쪽위 / 왼쪽, 오른쪽 / 왼쪽 아래, 아래, 오른쪽 아래
	static int[] dh = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dw = { -1, 0, 1, -1, 1, -1, 0, 1 };

	private static void bfs() {
		int h = q.peek()[0];
		int w = q.poll()[1];
		for (int i = 0; i < dh.length; i++) {
			int nh = h + dh[i];
			int nw = w + dw[i];
			int[] hw = { nh, nw };
			// 배열을 벗어나지 않고 탐색하지 않은 땅일경우 방문표시 -1하고 bfs()
			if (nh >= 0 && nh < H && nw >= 0 && nw < W && map[nh][nw] == 1) {
				map[nh][nw] = -1;
				q.offer(hw);
				bfs();
			}
		}
	}
}

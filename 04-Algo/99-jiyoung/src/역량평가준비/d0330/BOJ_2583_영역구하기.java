package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static int N, M, K;
	static boolean[][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int ans = 0;
	static List<Integer> size = new ArrayList<Integer>();
	static int s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = 0; i < y2 - y1; i++) {
				for (int j = 0; j < x2 - x1; j++) {
					map[y1 + i][x1 + j] = true;
				}
			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == false) {
					s = 0;
					map[i][j] = true;
					ans++;
					q.offer(new int[] { i, j });
					bfs();
					size.add(s);
				}
			}
		}
		
		System.out.println(ans);
		size.sort(null);
		for(int a : size) {
			System.out.printf(a + " ");
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			s += 1;
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !map[nx][ny]) {
					map[nx][ny] = true;
					q.offer(new int[] { nx, ny});
				}
			}
		}

	}
}

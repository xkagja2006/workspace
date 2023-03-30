package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int N, M, C, ans;
	static boolean[][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			ans = 0;
			for (int c = 0; c < C; c++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[n][m] = true;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == true) {
						map[i][j] = false;
						ans++;
						q.offer(new int[] { i, j });
						bfs();
					}
				}
			}
			System.out.println(ans);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny]) {
					map[nx][ny] = false;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}

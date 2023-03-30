package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[][] map;
	static int size, ans;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			q = new ArrayDeque<int[]>();
			ans = 0;
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[n][m] = 1;
			st = new StringTokenizer(br.readLine());
			int n2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			map[n2][m2] = 2;

			if (n == n2 && m == m2) {
				ans = 0;
			} else {
				q.offer(new int[] { n, m, 0 });
				bfs();
			}
			System.out.println(ans);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int time = q.peek()[2];
			int x = q.peek()[0];
			int y = q.poll()[1];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
					if (map[nx][ny] == 2) {
						ans = time + 1;
						return;
					} else if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, time + 1 });
					}
				}
			}

		}
	}
}


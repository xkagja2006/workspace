package 역량평가준비.d0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int M, N, ans;
	static int[][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
			for (int j = 0; j < N; j++) {
				String[] temp = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					map[j][k] = Integer.parseInt(temp[k]);
				}
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1) {
						q.offer(new int[] { j, k, 0 });
						map[j][k] = 2;
						
					}
				}
		}
		bfs();

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 0) {
						ans = -1;
					}
				}
		}
		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1};

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int time = q.poll()[2];
			ans = time;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0  && nx < N && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.offer(new int[] { nx, ny, time + 1 });
				}
			}
		}

	}
}

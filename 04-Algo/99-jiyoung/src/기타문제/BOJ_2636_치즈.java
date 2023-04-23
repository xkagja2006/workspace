package 기타문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans, cnt;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[0][0] = 2;
		while (true) {
			// 1. 외부공기 설정하기
			cnt = 0;
			q.offer(new int[] { 0, 0 });
			// 외부공기 설정 위한 bfs
			bfs1();
			if(cnt == 0) {
				System.out.println(ans);
				break;
			}

			// 2. 가장자리 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[N][M] == 1) {
						q.offer(new int[] { i, j });
						ans += 1;
						bfs2();
					}
				}
			}

		}
	}

	private static void bfs2() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					ans += 1;
					q.offer(new int[] {nx,ny});
				}
			}
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs1() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					cnt += 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}

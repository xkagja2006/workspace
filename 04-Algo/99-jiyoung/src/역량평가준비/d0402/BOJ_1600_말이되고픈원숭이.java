package 역량평가준비.d0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int[][] map;
	static boolean[][][] visited;
	static int W, H, ans, K;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		ans = -1;
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.offer(new int[] { 0, 0, 0, 0 });
		bfs();
		System.out.println(ans);
	}

	static int[] dhx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dhy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			int dist = q.poll()[3];

			if (x == H - 1 && y == W - 1) {
				ans = dist;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0) {
					if (visited[nx][ny][cnt] == false) {
						visited[nx][ny][cnt] = true;
						q.offer(new int[] { nx, ny, cnt, dist + 1 });
					}
				}
			}

			// 기회가 남았다면 기회를 사용하는 방법을 추가로 처리한다.
			if (cnt < K) {
				for (int i = 0; i < 8; i++) {
					int nx = x + dhx[i];
					int ny = y + dhy[i];
					if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0) {
						if (visited[nx][ny][cnt + 1] == false) {
							visited[nx][ny][cnt + 1] = true;
							q.offer(new int[] { nx, ny, cnt + 1, dist + 1 });
						}
					}
				}
			}

		}
	}
}

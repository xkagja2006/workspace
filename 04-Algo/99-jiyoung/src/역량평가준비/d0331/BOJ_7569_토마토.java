package 역량평가준비.d0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int M, N, H, ans;
	static int[][][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				String[] temp = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(temp[k]);
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 1) {
						q.offer(new int[] { i, j, k, 0 });
						map[i][j][k] = 2;
						
					}
				}
			}
		}
		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						ans = -1;
					}
				}
			}
		}
		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int z = q.peek()[0];
			int x = q.peek()[1];
			int y = q.peek()[2];
			int time = q.poll()[3];
			ans = time;
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H && map[nz][nx][ny] == 0) {
					map[nz][nx][ny] = 2;
					q.offer(new int[] { nz, nx, ny, time + 1 });
				}
			}
		}

	}
}

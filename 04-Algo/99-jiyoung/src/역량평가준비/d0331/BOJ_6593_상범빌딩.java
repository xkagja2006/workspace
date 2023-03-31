package 역량평가준비.d0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {
	static int L, N, M;
	static String ans;
	static String[][][] map;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (L == 0 && N == 0 && M == 0)
				break;

			map = new String[L][N][M];
			q = new ArrayDeque<int[]>();
			ans = "Trapped!";

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = br.readLine().split("");
				}
				br.readLine();
			}

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (map[i][j][k].equals("S")) {
							q.offer(new int[] { i, j, k, 0 });
						}
					}
				}
			}
			bfs();
			System.out.println(ans);
		}
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

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nz >= 0 && nx >= 0 && ny >= 0 && nz < L && nx < N && ny < M) {
					if (map[nz][nx][ny].equals(".")) {
						map[nz][nx][ny] = "S";
						q.offer(new int[] { nz, nx, ny, time + 1 });
					} else if (map[nz][nx][ny].equals("E")) {
						ans = "Escaped in " + (time + 1) + " minute(s).";
						return;
					}
				}
			}
		}
	}
}

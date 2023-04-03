package 역량평가준비.d0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;
	static int ans = -1;
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		visited = new boolean[N][M][2];
		q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		q.offer(new int[] { 0, 0, 0, 1 });
		bfs();
		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dist = q.peek()[3];
			int d = q.poll()[2];
			if (x == N - 1 && y == M - 1) {
				ans = dist;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					// 한번도 벽을 깨지 않은 경우 -> 갈 수 있고 방문한 적 없으면 큐에 넣기, 벽이고 깨진적 없다면 벽을 꺠기
					if (d == 0) {
						if (map[nx][ny] == 0 && visited[nx][ny][0] == false) {
							q.offer(new int[] { nx, ny, 0, dist + 1 });
							visited[nx][ny][0] = true;
						}
						if (map[nx][ny] == 1 && visited[nx][ny][1] == false) {
							q.offer(new int[] { nx, ny, 1, dist + 1 });
							visited[nx][ny][1] = true;
						}
					}

					// 벽을 이미 한번 깬 경우 -> 벽이 있는 경우 못간다. 벽이 없고 한번 깨고나서 방문한 적 없으면 큐에 넣기
					else {
						if (map[nx][ny] == 0 && visited[nx][ny][1] == false) {
							q.offer(new int[] { nx, ny, 1, dist + 1 });
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
	}
}

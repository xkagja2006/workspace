package 역량평가준비.d0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16933_벽부수고이동하기3 {
	static int N, M, K;
	static int ans = -1;
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		visited = new boolean[N][M][K + 1];
		q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j] - '0';
			}
		}
		// 0 : 낮, 1 : 밤
		q.offer(new int[] { 0, 0, 0, 1, 0 });
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
			int day = q.peek()[4] % 2;
			int cnt = q.poll()[2];
			if (x == N - 1 && y == M - 1) {
				ans = dist;
				return;
			}

//			System.out.println(y + " " + day + "일 " + cnt + "번 "  + dist);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					// 벽이 있는 경우 : 더 부실 수 있는경우 -> 벽 부수는일을 한다.
					// 벽이 아닌 경우 : 동일
					if (cnt < K) {
						if (map[nx][ny] == 1 && visited[nx][ny][cnt + 1] == false) {
							if (day == 0) {
								q.offer(new int[] { nx, ny, cnt + 1, dist + 1, day + 1 });
								visited[nx][ny][cnt + 1] = true;
							} 
							// 밤에는 부술 수 없음
							// 현재 자리를 유지한다.
							else {
								q.offer(new int[] { x, y, cnt, dist + 1, day + 1 });
							}
						}
					}
					if (map[nx][ny] == 0 && visited[nx][ny][cnt] == false) {
						q.offer(new int[] { nx, ny, cnt, dist + 1, day + 1 });
						visited[nx][ny][cnt] = true;
					}
				}
			}
		}
	}
}

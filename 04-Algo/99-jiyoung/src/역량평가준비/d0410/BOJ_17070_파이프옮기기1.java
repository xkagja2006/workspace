package 역량평가준비.d0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	static int[][] map;
	static int N, ans;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0 : 가로, 1 : 세로, 2 : 대각선
		q.offer(new int[] { 1, 1, 0 });
		bfs();
		
		System.out.println(ans);
	}

	// 오른쪽, 아래쪽, 왼쪽아래 삼방탐색!
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dir = q.poll()[2];
			if (x == N - 1 && y == N - 1) {
				ans++;
			}

			if (dir == 0) {
				for (int i = 0; i < 3; i++) {
					if (i == 1)
						continue;
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < N && ny < N && map[nx][ny] == 0) {
//						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, i });
					}
				}
			} else if (dir == 1) {
				for (int i = 0; i < 3; i++) {
					if (i == 0)
						continue;
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < N && ny < N && map[nx][ny] == 0) {
//						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, i });
					}
				}
			} else {
				for (int i = 0; i < 3; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < N && ny < N && map[nx][ny] == 0) {
//						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, i });
					}
				}
			}

		}
	}
}

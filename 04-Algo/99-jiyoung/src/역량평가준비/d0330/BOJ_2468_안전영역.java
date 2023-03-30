package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2468_안전영역 {
	static int T, cnt, H, ans;
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int[T][T];
		ans = 1;
		for (int t = 0; t < T; t++) {
			String[] ch = br.readLine().split(" ");
			for (int i = 0; i < T; i++) {
				map[t][i] = Integer.parseInt(ch[i]);
				MIN = Math.min(MIN, map[t][i]);
				MAX = Math.max(MAX, map[t][i]);
			}
		}
		for (int h = MIN; h < MAX; h++) {
			H = h;
			cnt = 0;
			visited = new boolean[T][T];
			q = new ArrayDeque<int[]>();
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < T; j++) {
					if (map[i][j] > H && visited[i][j] == false) {
						visited[i][j] = true;
						cnt++;
						q.offer(new int[] { i, j });
						bfs();
					}
				}
			}

			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
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
				if (nx >= 0 && ny >= 0 && nx < T && ny < T && map[nx][ny] > H && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}

	}
}

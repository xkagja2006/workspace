package 역량평가준비.d0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {
	static int N, M, ans, blank, C, btemp, atemp;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static List<int[]> virus = new ArrayList<int[]>();
	static int[][] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					blank++;
				}
			}
		}
		selected = new int[M][2];
		C = virus.size();
		// 조합 찾기
		combi(0, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			// 초기화하고 bfs
			q = new ArrayDeque<int[]>();
			btemp = blank;
			visited = new boolean[N][N];
			atemp = 0;

			for (int[] a : selected) {
				q.offer(new int[] { a[0], a[1], 0 });
			}
			bfs();
			ans = Math.min(ans, atemp);
			return;
		}
		for (int i = start; i < C; i++) {
			selected[cnt] = virus.get(i);
			combi(cnt + 1, i + 1);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int dist = q.peek()[2];
			int x = q.peek()[0];
			int y = q.poll()[1];

			if (map[x][y] == 0)
				btemp--;

			if (btemp == 0) {
				atemp = dist;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] != 1) {
					if (map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny, dist + 1 });
					} else {
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny, dist + 1 });
					}

				}
			}
		}
		// q가 다 비었는데 리턴하지 못한 경우
		atemp = Integer.MAX_VALUE;
	}
}

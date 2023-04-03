package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_수영대회결승전 {
	static int T, N, ans, day;
	static int[] start, end;
	static int[][] map;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			q = new ArrayDeque<int[]>();
			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			// start 배열은 좌표에 day일수, 거리를 추가했다.
			// 거리가 가장 짧을때 걸린 시간이 정답
			// day는 1부터 시작 -> 답에서 -1해야함
			start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1, 0 };
			st = new StringTokenizer(br.readLine());
			end = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			ans = -1;
			q.offer(start);
			bfs();
			System.out.println("#" + t + " " + (ans == -1 ? -1 : ans-1));
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int day = q.peek()[2];
			int dist = q.peek()[3];
			int x = q.peek()[0];
			int y = q.poll()[1];
			int spin = day % 3;

			if (x == end[0] && y == end[1]) {
				ans = day;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1) {
					// 소용돌이가 있는 자리인 경우
					if (map[nx][ny] == 2) {
						// 소용돌이가 존재하는 경우-> 자리에 가만히 있는다. 방문처리도 안한다. 아직 소용돌이 자리를 안갔으니께
						if (spin != 0) {
							q.offer(new int[] { x, y, day + 1, dist });
						}
						// 소용돌이가 없는 경우 -> 그냥 가면됨
						else {
							map[nx][ny] = 1;
							q.offer(new int[] { nx, ny, day + 1, dist + 1 });
						}
					} else {
						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, day + 1, dist + 1 });
					}

				}
			}
		}

	}
}

package 역량평가준비.d0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불 {
	static int R, C;
	static String ans;
	static String[][] map;
	static Queue<int[]> qf;
	static Queue<int[]> qj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			ans = "";
			flag = 0;
			curt1 = 0;
			curt2 = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			qf = new ArrayDeque<int[]>();
			qj = new ArrayDeque<int[]>();
			map = new String[R][C];
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().split("");
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j].equals("*")) {
						qf.offer(new int[] { i, j, 0 });
					} else if (map[i][j].equals("@")) {
						qj.offer(new int[] { i, j, 0 });
					}
				}
			}

			if (qj.peek()[0] == 0 || qj.peek()[0] == R - 1 || qj.peek()[1] == 0 || qj.peek()[1] == C - 1)
				ans = "" + 1;
			else {
				curt1 = 0;
				curt2 = 0;
				bfs();
			}
			System.out.println(ans);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int curt1;
	static int curt2;
	static int flag;

	private static void bfs() {
		while (!qj.isEmpty()) {

			int jx = qj.peek()[0];
			int jy = qj.peek()[1];
			int jtime = qj.peek()[2];

			if (curt1 != jtime) {
				curt1 = jtime;
				bfs2();
				if (flag == 1)
					return;
			} else {
				qj.poll();
			}

			if (map[jx][jy].equals("*")) {
				continue;
			}

			if (jx == 0 || jx == R - 1 || jy == 0 || jy == C - 1) {
				ans = "" + (jtime + 1);
				flag = 1;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int jnx = jx + dx[i];
				int jny = jy + dy[i];
				if (jnx >= 0 && jny >= 0 && jnx < R && jny < C && map[jnx][jny].equals(".")) {
					{
						map[jnx][jny] = "@";
						qj.offer(new int[] { jnx, jny, jtime + 1 });
					}
				}
			}

		}
		ans = "IMPOSSIBLE";
	}

	private static void bfs2() {
		while (!qf.isEmpty()) {
			int x = qf.peek()[0];
			int y = qf.peek()[1];
			int time = qf.peek()[2];

			if (curt2 != time) {
				curt2 = time;
				bfs();
				if (flag == 1)
					return;
			} else {
				qf.poll();
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if (map[nx][ny].equals(".") || map[nx][ny].equals("@")) {
						map[nx][ny] = "*";
						qf.offer(new int[] { nx, ny, time + 1 });
					}
				}
			}
		}
	}
}

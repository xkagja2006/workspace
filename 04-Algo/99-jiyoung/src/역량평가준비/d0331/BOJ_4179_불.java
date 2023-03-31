package 역량평가준비.d0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
	static int R, C;
	static String ans;
	static String[][] map;
	static Queue<int[]> qf = new ArrayDeque<int[]>();
	static Queue<int[]> qj = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		ans="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().split("");
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("F")) {
					qf.offer(new int[] { i, j, 0 });
				} else if (map[i][j].equals("J")) {
					qj.offer(new int[] { i, j, 0 });
				}
			}
		}

		if (qj.peek()[0] == 0 || qj.peek()[0] == R - 1 || qj.peek()[1] == 0 || qj.peek()[1] == C - 1)
			ans = "" + 1;
		else
			bfs();
		System.out.println(ans);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int curt1 = 0;
	static int curt2 = 0;
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
			
			if(map[jx][jy].equals("F")) {
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
						map[jnx][jny] = "J";
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
					if (map[nx][ny].equals(".") || map[nx][ny].equals("J")) {
						map[nx][ny] = "F";
						qf.offer(new int[] { nx, ny, time + 1 });
					}
				}
			}
		}
	}
}

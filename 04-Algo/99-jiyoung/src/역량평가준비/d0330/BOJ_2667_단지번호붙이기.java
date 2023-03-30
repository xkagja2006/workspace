package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int N, cnt, size;
	static boolean[][] map;
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] ch = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = (Integer.parseInt(ch[j]) == 1 ? true : false);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]) {
					map[i][j] = false;
					cnt++;
					size = 0;
					q.offer(new int[] { i, j });
					bfs();
					list.add(size);
				}
			}
		}
		System.out.println(cnt);
		list.sort(null);
		for(int x : list) {
			System.out.println(x);
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			size += 1;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny]) {
					map[nx][ny] = false;
					q.offer(new int[] { nx, ny });
				}
			}
		}

	}
}

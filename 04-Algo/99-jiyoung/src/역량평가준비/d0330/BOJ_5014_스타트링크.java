package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int ans = -1;
	static boolean[] map;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new boolean[1000000 + 1];
		map[S] = true;
		q.offer(new int[] { S, 0 });
		bfs();
		System.out.println((ans == -1 ? "use the stairs" : ans));
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int cnt = q.peek()[1];
			int f = q.poll()[0];
			if (f == G) {
				ans = cnt;
				return;
			}
			int up = f + U;
			int down = f - D;
			if (up <= F && !map[up]) {
				map[up] = true;
				q.offer(new int[] {up, cnt + 1});
			}
			if (down > 0 && !map[down]) {
				map[down] = true;
				q.offer(new int[] {down, cnt + 1});
			}
		}

	}
}

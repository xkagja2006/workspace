package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	static int N, S, E, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}

		ans = -1;
		dfs(S, 0);
		System.out.println(ans);
	}

	private static void dfs(int v, int cnt) {
		if(v == E) {
			ans = cnt;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
			}
		}

	}
}

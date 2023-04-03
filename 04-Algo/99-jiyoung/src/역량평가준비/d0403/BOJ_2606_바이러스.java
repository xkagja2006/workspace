package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int T, N, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		ans = 0;
		map = new int[T + 1][T + 1];
		visited = new boolean[T + 1];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		visited[1] = true;
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int x) {
		for (int j = 1; j <= T; j++) {
			if (map[x][j] == 1 && !visited[j]) {
				visited[j] = true;
				ans++;
				dfs(j);
			}
		}

	}
}

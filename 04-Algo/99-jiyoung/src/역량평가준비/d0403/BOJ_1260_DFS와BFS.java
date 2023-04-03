package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int map[][];
	static int N, M, V;
	static Queue<Integer> q = new ArrayDeque<>();
	static Stack<Integer> s = new Stack<>();
	static boolean[] visitedQ;
	static boolean[] visitedS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visitedQ = new boolean[N];
		visitedS = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		s.push(V - 1);
		visitedS[V - 1] = true;
		dfs2();

//		System.out.println();

		visitedS = new boolean[N];
		visitedS[V - 1] = true;
//		dfs(V - 1);

		System.out.println();
		q.offer(V - 1);
		visitedQ[V - 1] = true;
		bfs();

	}

	private static void dfs2() {
		int v = s.pop();
		System.out.printf(v + 1 + " ");
		for (int i = 0; i < N; i++) {
			if (map[v][i] == 1 || map[i][v] == 1) {
				if (visitedS[i] == false) {
					visitedS[i] = true;
					s.push(i);
					dfs2();
				}
			}
		}
	}

	private static void dfs(int v) {
		System.out.printf(v + 1 + " ");
		for (int i = 0; i < N; i++) {
			if (map[v][i] == 1 || map[i][v] == 1) {
				if (visitedS[i] == false) {
					visitedS[i] = true;
					dfs(i);
				}
			}
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int v = q.poll();
			System.out.printf(v + 1 + " ");
			for (int i = 0; i < N; i++) {
				if (map[v][i] == 1 || map[i][v] == 1) {
					if (visitedQ[i] == false) {
						visitedQ[i] = true;
						q.offer(i);
					}
				}
			}
		}
	}
}

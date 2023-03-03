package com.ssafy.offline19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이지영_SWEA_1238_Contact {
	static int L, S, size = 101;
	static boolean[] visited;
	static int[][] graph;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new int[size][size];
			queue = new LinkedList<>();
			visited = new boolean[size];

			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < L / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from][to] = 1;
			}

			System.out.print("#" + t + " ");
			bfs(S);
		}
	}

	public static void bfs(int x) {
		ArrayList<Integer> list = new ArrayList<>();

		queue.offer(x);
		visited[x] = true;
		int max = 0;

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			max = 0;

			for (int t = 0; t < qSize; t++) {
				int cur = queue.poll();
				for (int i = 1; i < size; i++) {
					if (graph[cur][i] == 1 && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
						max = Math.max(max, i);
					}
				}
			}
			list.add(max);
		}

		System.out.println(list.get(list.size() - 2));
	}
}
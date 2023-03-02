package com.ssafy.live18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input 파일은 간선의 가중치 외에는 모두 0으로 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V]; // 출발정점에서 자신까지 오는 최소비용
		boolean[] visited = new boolean[V];

		Arrays.fill(distance, INF); // 최소값이 갱신 로직을 반영해야하므로 큰값으로 초기화
		distance[start] = 0; // 출발지에서 출발지로의 거리는 0

		int min, current;
		for (int c = 0; c < V; c++) {
			// step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = INF;

			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			if (current == -1)
				break; // 방문할 수 있는 곳이 없음
			visited[current] = true;

			// 선택된 정점이 문제에서 요구하는 도착정점이면 끝내기
			if (current == end)
				break;

			// step2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 미방문 인접정점과의 비용 최소값 갱신
			for (int j = 0; j < V; j++) {
				// 아래 조건에서 !visited[j]는 생략 가능하다. distance[j] > min + adjMatrix[current][j] 조건에서 걸러지기 때문에
				if (!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
				}
			}
		}

		System.out.println(distance[end] != INF ? distance[end] : -1);
	}
}

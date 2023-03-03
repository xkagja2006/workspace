package com.ssafy.offline19;
import java.util.*;

public class DijkstraTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int V = sc.nextInt(); // 정점의 개수
        int start = sc.nextInt(); // 시작 정점
        int end = sc.nextInt(); // 도착 정점

        int[][] adjMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        // 다익스트라 알고리즘
        final int INF = Integer.MAX_VALUE; // 최소 비용을 구하기 위해 무한대 값을 초기값으로 설정
        int[] distance = new int[V]; // 출발 정점에서 각 정점까지의 최소 비용을 저장할 배열
        boolean[] visited = new boolean[V]; // 방문한 정점을 표시할 배열
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance[a] - distance[b]); // 우선순위 큐

        Arrays.fill(distance, INF); // 최소값이 갱신되도록 초기화
        distance[start] = 0; // 시작 정점에서 시작 정점까지의 거리는 0
        pq.offer(start); // 시작 정점을 큐에 넣음

        while (!pq.isEmpty()) {
            int current = pq.poll(); // 현재 정점
            if (visited[current]) continue; // 이미 방문한 정점이면 continue

            visited[current] = true; // 현재 정점을 방문한 것으로 표시

            for (int next = 0; next < V; next++) { // 다음에 방문할 정점을 탐색
                int weight = adjMatrix[current][next];
                if (weight == 0) continue; // 가중치가 0이면 간선이 없는 것이므로 continue

                if (distance[next] > distance[current] + weight) { // 더 작은 비용으로 갱신 가능한 경우
                    distance[next] = distance[current] + weight; // 비용을 갱신
                    pq.offer(next); // 갱신한 정점을 큐에 넣음
                }
            }
        }

        System.out.println(distance[end] != INF ? distance[end] : -1); // 도착 정점까지의 최소 비용 출력. 도달할 수 없는 경우 -1 출력
    }
}

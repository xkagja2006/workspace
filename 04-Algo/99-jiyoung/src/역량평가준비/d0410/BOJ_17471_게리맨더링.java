package 역량평가준비.d0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, ans, M, sum1, sum2;
	static int[][] map;
	static boolean[] visited;
	static int[] count, city, select, unselect;
	static Queue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = new int[N + 1]; // 구역은 1번부터 시작한다.
		map = new int[N + 1][N + 1];
		city = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			city[i] = i;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int linked = Integer.parseInt(st.nextToken());
			for (int j = 0; j < linked; j++) {
				int city = Integer.parseInt(st.nextToken());
				map[i][city] = 1;
				map[city][i] = 1;
			}
		}

		ans = Integer.MAX_VALUE;
		
		// 원소개수 1개 이상인 진부분집합을 제외한 부분집합 구하기
		for (int i = 1; i <= N / 2; i++) {
			M = i; // M개의 도시를 뽑는다.
			select = new int[M];
			combi(0, 0);
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			// 선택한 도시가 select에 들어있다.

			// 1. bfs로 선택한 도시들이 연결되어있는지 확인한다.
			q = new ArrayDeque<>();
			visited = new boolean[N + 1];
			// 일단 첫번째 값을 넣어준다.
			sum1 = count[select[0]];
			q.offer(select[0]);
			visited[select[0]] = true;
			bfs();
			// 방문안한 영역이 있으면 이것은 연결될 수 없는 경우이다.
			for (int i = 0; i < M; i++) {
				if (!visited[select[i]]) {
					return;
				}
			}
//			System.out.println("가능한 구역1 : " + Arrays.toString(select) + " 합 : " + sum1);

			// 2. 그 외의 도시들이 연결되어있는지 확인한다.
			q = new ArrayDeque<>();
			visited = new boolean[N + 1];
			unselect = new int[N - M];
			int idx = 0;
			outer: for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (i == select[j])
						continue outer;
				}
				unselect[idx++] = i;
			}
			sum2 = count[unselect[0]];
			q.offer(unselect[0]);
			visited[unselect[0]] = true;
			bfs2();

			// 방문안한 영역이 있으면 이것은 연결될 수 없는 경우이다.
			for (int i = 0; i < N-M; i++) {
				if (!visited[unselect[i]]) {
					return;
				}
			}
//			System.out.println("가능한 구역2 : " + Arrays.toString(unselect) + " 합 : " + sum2);
			ans = Math.min(ans, Math.abs(sum1-sum2));
			return;
		}
		for (int i = start; i < N; i++) {
			select[cnt] = city[i + 1];
			combi(cnt + 1, i + 1);
		}
	}

	private static void bfs2() {
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[n][i] == 1 && !visited[i]) {
					// 연결된 곳이 select에 있으면 큐에 넣는다.
					for (int j = 0; j < (N-M); j++) {
						if (unselect[j] == i) {
							sum2 += count[i];
							visited[i] = true;
							q.offer(i);
						}
					}
				}
			}
		}
		
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[n][i] == 1 && !visited[i]) {
					// 연결된 곳이 select에 있으면 큐에 넣는다.
					for (int j = 0; j < M; j++) {
						if (select[j] == i) {
							sum1 += count[i];
							visited[i] = true;
							q.offer(i);
						}
					}
				}
			}
		}

	}

}

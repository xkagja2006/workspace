package com.ssafy.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이지영_SWEA_5656_벽돌깨기 {
	static int N, W, H, sum, ans, count;
	static int[][] map;
	static boolean[][] visited, remove;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			remove = new boolean[H][W];
			visited = new boolean[H][W];
			order = new int[N];
			count = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						count++;
				}
			}

			// 중복순열 구하기 -> W에서 N개를 중복 가능하게 나열하기
			perm(0);

			System.out.println("#" + (t+1) + " " + (count - ans));
		}
	}

	private static void perm(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(order));
			// 순서 만들어짐
			int[][] newMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					newMap[i][j] = map[i][j];
				}
			}

			int total = 0;
			for (int i = 0; i < N; i++) {

				sum = 0;
				// 구슬 떨어트림
				drop(order[i], newMap);

				// 1개일때는 맵 재정비 필요없음
				if (sum > 1)
					getDown(newMap);

				total += sum;
			}
			ans = Math.max(ans, total);
			return;
		}
		for (int i = 0; i < W; i++) {
			order[cnt] = i;
			perm(cnt + 1);
		}
	}

	// 구슬을 떨어트리는 열의 번호를 매개변수로 받는다.
	private static void drop(int R, int[][] newMap) {
		// 위에서부터 구슬이 내려오면서 벽돌을 만나는지 안만나는지 확인한다.
		for (int i = 0; i < H; i++) {
			// 벽돌을 만나면 폭파시킴.
			if (newMap[i][R] > 0) {
//				System.out.println(i + "번째 삭제");
				boom(i, R, newMap);
				return;
			}
		}
	}

	private static void getDown(int[][] newMap) {
		// map을 아래부터 돌면서 탐색 위치에 벽돌이 없는데 자기 위쪽에 벽돌이 있으면 아래로 내린다.
		for (int i = H - 1; i > 0; i--) {
			for (int j = 0; j < W; j++) {
				if (newMap[i][j] == 0) {
					findBrick(i, j, newMap);
				}
			}
		}
	}

	private static void findBrick(int x, int y, int[][] newMap) {
		// 자기 위에 벽돌이 있는지 확인한다. 위로 올라가면서 벽돌을 만나면 아래로 내리고 반환한다.
		for (int i = x - 1; i >= 0; i--) {
			if (newMap[i][y] > 0) {
				newMap[x][y] = newMap[i][y];
				newMap[i][y] = 0;
				return;
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 폭파시켜야 하는 상황
	private static void boom(int x, int y, int[][] newMap) {
		int reach = newMap[x][y];
		newMap[x][y] = 0;
		sum++;
		// 벽돌의 숫자-1만큼 사방탐색의 범위를 정한다.
		for (int i = 1; i < reach; i++) {
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k] * i;
				int ny = y + dy[k] * i;

				// 사방탐색위치에 벽돌이 있으면
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny] && newMap[nx][ny] > 0) {
					boom(nx, ny, newMap);
				}
			}
		}
	}
}

package com.ssafy.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌깨기2 {
	static int N, W, H, sum, resultSum, ans, nextMax, next;
	static int[][] map;
	static boolean[][] visited, remove;

	public static void main(String[] args) throws NumberFormatException, IOException {
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

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// N번 구슬을 떨어트린다.
			for (int d = 0; d < N; d++) {
				resultSum = 0; // resultSum : d번째 턴에서 가장 많이 삭제시킬 수 있는 벽돌 수
				
				// 구슬을 모든 열에 다 떨어트려 본다.
				for (int i = 0; i < W; i++) {
					nextMax = 0;
					next = 0;
					sum = 0; // sum : 구슬을 i열에 떨어트릴 때 삭제시키는 벽돌 수
					visited = new boolean[H][W];
					drop(i);	// 해당 열에 떨어트려서 삭제한 벽돌의 수가 sum에 저장된다.
					if (resultSum <= sum && nextMax < next) {
						remove = visited.clone();	// 삭제할 벽돌의 위치를 remove에 저장한다.
						resultSum = Math.max(resultSum, sum);
					}
				}
				ans += resultSum;

				// remove 배열을 보고 벽돌을 제거한다.
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if (!remove[i][j])
							continue;
						map[i][j] = 0;
					}
				}

				// map을 아래부터 돌면서 탐색 위치에 벽돌이 없는데 자기 위쪽에 벽돌이 있으면 아래로 내린다.
				for (int i = H - 1; i > 0; i--) {
					for (int j = 0; j < W; j++) {
						if (map[i][j] == 0) {
							findBrick(i, j);
						}
					}
				}
			}
			System.out.println("#" + (t + 1) + " " + ans);
		}
	}

	private static void findBrick(int x, int y) {
		// 자기 위에 벽돌이 있는지 확인한다. 위로 올라가면서 벽돌을 만나면 아래로 내리고 반환한다.
		for (int i = x - 1; i >= 0; i--) {
			if(map[i][y] > 0) {
				map[x][y] = map[i][y];
				map[i][y] = 0;
				return;
			}
		}
	}

	// 구슬을 떨어트리는 열의 번호를 매개변수로 받는다.
	private static void drop(int R) {
		// 위에서부터 구슬이 내려오면서 벽돌을 만나는지 안만나는지 확인한다.
		for (int i = 0; i < H; i++) {
			// 벽돌을 만나면 폭파시킨다.
			if (map[i][R] > 0) {
				boom(i, R);
				return;
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 폭파시켜야 하는 상황
	private static void boom(int x, int y) {
		visited[x][y] = true;
		sum++;
		
		// 다음을 위해 이번걸 터트려야 하는 상황
		if(y > 0 && map[x][y-1] > nextMax) {
			
		}
		// 벽돌의 숫자-1만큼 사방탐색의 범위를 정한다.
		for (int i = 1; i < map[x][y]; i++) {
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k] * i;
				int ny = y + dy[k] * i;

				// 사방탐색위치에 벽돌이 있으면
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny] && map[nx][ny] > 0) {
					boom(nx, ny);
				}
			}
		}
	}
}

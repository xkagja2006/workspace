package com.ssafy.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이지영_BOJ_16236_아기상어 {
	static int N, size, time, ate;
	static int[] shark = new int[2];
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	static List<int[]> eat = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
				}
			}
		}

		size = 2;
		time = 0;

		int t = 1;
		while (true) {
			// 한번 물고기를 찾을 때 마다 방문기록, 큐 초기화
			visited = new boolean[N][N];
			queue = new ArrayDeque<int[]>();

			// 먹을 수 있는 물고기를 찾아서 list에 넣기. 처음 거리는 항상 0이다.
			queue.offer(new int[] { shark[0], shark[1], 0 });
			visited[shark[0]][shark[1]] = true;
			bfs();

			// bfs함수를 호출 한 후에도 list에 아무것도 없으면 끝냄
			if (eat.isEmpty())
				break;

			// list에 있는 먹이중 적절한 먹이를 찾아서 먹고 time 갱신, shark위치 갱신
			// 모든 먹이는 같은 거리를 가지게 했음.
			// 먹이가 2개 이상 있는 경우는 위쪽에 있고, 왼쪽에 있는것을 찾게 정렬한다.
			if (eat.size() >= 2) {
				Collections.sort(eat, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[0] == o2[0]) { // 행이 같은 경우
							return o1[1] - o2[1]; // 더 왼쪽에 있는 것(열 값이 작은 것) 먼저.
						} else
							return o1[0] - o2[0]; // 행이 다르면 더 위에있는것(행 값이 작은 것) 먼저.
					}
				});
			}

			int x = eat.get(0)[0];
			int y = eat.get(0)[1];
			time += eat.get(0)[2];
			// 상어의 위치를 바꾼다. 어떤 수로 해도 무방할것같다. 어차피 시작위치기 때문에.
			map[x][y] = 9;
			// 기존 상어의 위치를 0으로 바꾸고 상어의 좌표를 갱신한다.
			map[shark[0]][shark[1]] = 0;
			shark[0] = x;
			shark[1] = y;
			ate++;
			// 상어의 크기만큼 먹은 경우 상어의 크기를 키워주고 먹은 물고기 개수를 초기화한다.
			if (ate == size) {
				size++;
				ate = 0;
			}
			// 리스트를 비운다.
			eat.clear();
		}
		System.out.println(time);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		if (queue.isEmpty()) {
			return;
		}
		int[] thisPos = queue.poll();

		// 먹을 수 있는 물고기면 eat에 추가한다.
		if (map[thisPos[0]][thisPos[1]] > 0 && map[thisPos[0]][thisPos[1]] < size) {
			// 리스트가 비어있으면 무조건 넣고, 리스트가 채워져있으면 거리를 비교해서 같으면 넣고 더 크면 넣지 않는다.
			if (eat.isEmpty()) {
				eat.add(new int[] { thisPos[0], thisPos[1], thisPos[2] });
			} else {
				int thisDis = thisPos[2];
				int privDis = eat.get(0)[2];

				if (thisDis == privDis) {
					eat.add(new int[] { thisPos[0], thisPos[1], thisPos[2] });
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			int nx = thisPos[0] + dx[i];
			int ny = thisPos[1] + dy[i];

			// 방문하지 않았고, 자신보다 같거나 작은 크기의 물고기가 있는 칸이어야 한다.
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= size) {
				visited[nx][ny] = true;
				queue.offer(new int[] { nx, ny, (thisPos[2] + 1) });

			}
		}
		bfs();

	}
}

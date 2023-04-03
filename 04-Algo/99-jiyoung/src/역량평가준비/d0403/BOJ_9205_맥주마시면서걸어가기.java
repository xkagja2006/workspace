package 역량평가준비.d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
	static List<int[]> list;
	static int[][] map;
	static String ans;
	static int N, M, endX, endY;
	static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = "sad";
			list = new ArrayList<>();
			q = new ArrayDeque<int[]>();
			int Store = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int minX = 32768;
			int maxX = -32768;
			int minY = 32768;
			int maxY = -32768;
			for (int i = 0; i < Store + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				int[] arr = new int[] { x, y };
				list.add(arr);
			}
//			System.out.println((maxX - minX) + " " + (maxY - minY));
//			System.out.println("min : " + minX + " " + minY);
			for (int i = 0; i < list.size(); i++) {
				list.get(i)[0] -= minX;
				list.get(i)[1] -= minY;
			}

//			for(int[] a : list) {
//				System.out.println(Arrays.toString(a));
//			}
			N = maxX - minX + 1;
			M = maxY - minY + 1;
			map = new int[N][M];

			for (int i = 0; i < list.size(); i++) {
				// 집
				if (i == 0)
					map[list.get(i)[0]][list.get(i)[1]] = 1;
				// 락페
				else if (i == list.size() - 1) {
					map[list.get(i)[0]][list.get(i)[1]] = 5;
					endX = list.get(i)[0];
					endY = list.get(i)[1];
				}
				// 편의점
				else
					map[list.get(i)[0]][list.get(i)[1]] = 3;
			}

//			System.out.println(Arrays.deepToString(map));

			// 1000미터를 갈 수 있음
			q.offer(new int[] { list.get(0)[0], list.get(0)[0], 1000 });
			bfs();
			System.out.println(ans);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int left = q.poll()[2];
			System.out.println(left);
			if (left == -1) {
				return;
			}
			if (x == endX && y == endY) {
				ans = "happy";
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1) {
					if (map[nx][ny] == 3) {
						System.out.println("-------------편의점");
						left += 950;
					}
					map[nx][ny] = 1;
					q.offer(new int[] { nx, ny, left - 1 });
				}
			}
		}

	}
}

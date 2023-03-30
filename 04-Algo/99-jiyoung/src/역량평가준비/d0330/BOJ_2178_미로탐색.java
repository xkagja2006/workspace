package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4 6
101111
101010
101011
111011
*/
public class BOJ_2178_미로탐색 {
	static int N;
	static int M;
	static int[][] map;
	static int length = 0;
	static int num = 1;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < arr.length; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		map[0][0] = 0;
		q.offer(new int[] { 0, 0, 1 });
		bfs();
		System.out.println(length);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		int len = q.peek()[2];
		int x = q.peek()[0];
		int y = q.poll()[1];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx == N-1 && ny == M-1) {
				length = len + 1;
				return;
			} else if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
				map[nx][ny] = 0;
				// len += 1; 하면 안된다! 다음 for문을 돌고 나서도 len의 값은 변하면 안되니깐!
				q.offer(new int[] { nx, ny, len+1});
			}
		}
		bfs();
	}
}

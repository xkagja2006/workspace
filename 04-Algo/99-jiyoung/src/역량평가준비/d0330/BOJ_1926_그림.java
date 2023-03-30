package 역량평가준비.d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/

public class BOJ_1926_그림 {
	static int col;
	static int row;
	static int[][] map;
	static int maxsize = 0;
	static int size = 0;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		for (int c = 0; c < col; c++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < row; r++) {
				map[c][r] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[i][j] == 1) {
					size = 1;
					ans++;
					q.offer(new int[] {i,j});
					map[i][j] = 0;
					bfs();
					maxsize = Math.max(maxsize, size);
				}
			}
		}
		
		System.out.println(ans + "\n" + maxsize);
	}

	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		int x = q.peek()[0];
		int y = q.poll()[1];
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < col && ny < row) {
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					q.offer(new int[] {nx,ny});
					size += 1;
					bfs();
				}
			}
		}
	}
}

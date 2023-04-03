package 역량평가준비.d0402;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {
	static Queue<int[]> q = new ArrayDeque<>();
	static int ans = 0;
	static int N, K;
	static boolean[] map = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if (N > K) {
			ans = N - K;
		} else {
			q.offer(new int[] { N, 0 });
			map[N] = true;
			bfs();
		}
		System.out.println(ans);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int n = q.peek()[0];
			int time = q.poll()[1];
			
			if (n == K) {
				ans = time;
				break;
			}
			
			if (n - 1 >= 0 && map[n - 1] == false) {
				map[n - 1] = true;
				q.offer(new int[] { n - 1, time + 1 });
			}
			if(n*2 == n+1) {
				map[n * 2] = true;
				q.offer(new int[] { n * 2, time });
			}
			if (n * 2 <= 100000 && map[n * 2] == false) {
				map[n * 2] = true;
				q.offer(new int[] { n * 2, time });
			}
			if (n + 1 <= 100000 && map[n + 1] == false) {
				map[n + 1] = true;
				q.offer(new int[] { n + 1, time + 1 });
			}
		}

	}
}

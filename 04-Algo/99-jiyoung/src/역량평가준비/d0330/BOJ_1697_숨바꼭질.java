package 역량평가준비.d0330;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static Queue<int[]> q = new ArrayDeque<>();
	static int ans = 0;
	static int s, d;
	static boolean[] map = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		d = sc.nextInt();
		if (s > d) {
			ans = s - d;
		} else {
			q.offer(new int[] { s, 0 });
			map[s] = true;
			bfs();
		}
		System.out.println(ans);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int n = q.peek()[0];
			int time = q.poll()[1];
			if (n == d) {
				ans = time;
				break;
			} else {
				if (n - 1 >= 0 && map[n - 1] == false) {
					map[n - 1] = true;
					q.offer(new int[] { n - 1, time + 1 });
				}
				if (n + 1 <= 100000 && map[n + 1] == false) {
					map[n + 1] = true;
					q.offer(new int[] { n + 1, time + 1 });
				}
				if (n * 2 <= 100000 && map[n * 2] == false) {
					map[n * 2] = true;
					q.offer(new int[] { n * 2, time + 1 });
				}
			}
		}
	}
}

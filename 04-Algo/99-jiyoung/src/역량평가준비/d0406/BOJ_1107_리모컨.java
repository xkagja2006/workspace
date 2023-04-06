package 역량평가준비.d0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static Queue<int[]> q = new ArrayDeque<>();
	static int b, goal, ans1, ans2;
	static int broke[];
	static boolean visited[];

	/*
	 * 1. 10개 다 망가진경우 판별하기 -> 숫자버튼 못누름 -> 바로 100부터 찾기 -> 초기 정답을 최대값으로 세팅 2. 0개 망가진
	 * 경우 판별하기 -> 초기 정답은 채널의 자릿수 3. 숫자버튼 눌러서 가는 경우 찾기 -> 정답 보관 4. 100번부터 찾아가는 경우 찾기
	 * 4-1. 정답이 이전 정답보다 커지면 나가버리기
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		goal = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());

		// 고장난게 하나라도 있는 경우 -> 버튼 몇번 누를지 bfs
		// 모두 고장난 경우는 따로 처리하기!
		if (b != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			broke = new int[b];
			visited = new boolean[1000000];
			for (int i = 0; i < b; i++) {
				broke[i] = Integer.parseInt(st.nextToken());
			}
			if (b == 10) {
				ans1 = Integer.MAX_VALUE;
			} else {
				q.offer(new int[] { goal, 0 });
				bfs();
			}
		}
		// 고장난게 없는 경우 -> bfs필요없음
		else {
			// 초기 정답 세팅
			ans1 = Integer.toString(goal).length();
		}
		// 100번부터 시작해서 찾기 -> 정답이 초기정답보다 큰 경우 빠져나오기
		q.clear();
		q.offer(new int[] { 100, 0 });
		visited = new boolean[1000000];
		bfs2();

		System.out.println(Math.min(ans1, ans2));
	}

	private static void bfs2() {
		while (!q.isEmpty()) {
			int num = q.peek()[0];
			int dist = q.poll()[1];
			visited[num] = true;

			if (dist > ans1) {
				ans2 = ans1;
				return;
			}
			if (num == goal) {
				ans2 = dist;
				return;
			}

			if (num - 1 >= 0 && !visited[num - 1])
				q.offer(new int[] { num - 1, dist + 1 });
			if (num + 1 < 1000000 && !visited[num + 1])
				q.offer(new int[] { num + 1, dist + 1 });
		}
	}

	// 버튼 눌러서 가는 경우
	private static void bfs() {
		while (!q.isEmpty()) {
			int num = q.peek()[0];
			int dist = q.poll()[1];
			visited[num] = true;

			boolean flag = false; // 망가진 버튼 포함 여부
			// 망가진 버튼의 숫자가 포함되었는지 확인
			outer: for (int i = 0; i < Integer.toString(num).length(); i++) {
				for (int j = 0; j < b; j++) {
					// 망가진 버튼 포함되었으면 바로 다음걸로 넘김
					int n = Integer.toString(num).charAt(i) - '0';
					if (n == broke[j]) {
						if (num - 1 >= 0 && !visited[num - 1]) {
							q.offer(new int[] { num - 1, dist + 1 });
						}
						if (num + 1 < 1000000 && !visited[num + 1]) {
							q.offer(new int[] { num + 1, dist + 1 });
						}
						flag = true;
						break outer;
					}
				}
			}
			if (flag == false) {
				ans1 = dist + Integer.toString(num).length();
				return;
			}
		}
	}
}

package 역량평가준비.d0404;

import java.util.Arrays;

public class 순조부 {
	static int N, M;
	static boolean[] visited;
	static int[] input;
	static int[] number;

	public static void main(String[] args) {
		N = 4;
		M = 2;
		input = new int[N];
		number = new int[M];
		visited = new boolean[N];
		for (int i = 1; i <= N; i++) {
			input[i - 1] = i;
		}
		System.out.println("-----순열-----");
		perm(0);
		System.out.println("-----중복순열-----");
		perm2(0);
		System.out.println("-----조합-----");
		combi(0, 0);
		System.out.println("-----부분집합-----");
		subset();
		System.out.println("-----부분집합2-----");
		subset2();

	}

	private static void subset() {
		for (int i = 1; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) == 0)
					continue;
				System.out.print(input[j] + " ");
			}
			System.out.println();
		}

	}

	private static void subset2() {
		for (int i = 0; i < (1 << N); i++) {
			int n = 4;
			String c = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(i)));
			System.out.println(c);
		}

	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = start; i < N; i++) {
			number[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}

	}

	private static void perm(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				number[cnt] = input[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static void perm2(int cnt) {
		if (cnt == M) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			number[cnt] = input[i];
			perm(cnt + 1);
		}
	}
}

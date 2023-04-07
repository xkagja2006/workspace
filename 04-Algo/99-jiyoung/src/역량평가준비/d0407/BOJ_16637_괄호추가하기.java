package 역량평가준비.d0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_16637_괄호추가하기 {
	static int N, ans;
	static String S, STR;
	static boolean[] visited;
	static boolean flag;
	static List<String> list = new ArrayList<>();
	static Queue<Integer> nums;
	static Queue<Character> signs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		STR = br.readLine();
		if (N == 1)
			ans = Integer.parseInt(STR);
		else if(N==3)
			ans = calc(STR.charAt(0)-'0',STR.charAt(2)-'0',STR.charAt(1));
		else {
		ans = Integer.MIN_VALUE;
		visited = new boolean[N / 2];
		subset();

			// 괄호를 적용한 경우의 수 마다 결과값을 구한다.
			for (int i = 0; i < list.size(); i++) {
				nums = new ArrayDeque<>();
				signs = new ArrayDeque<>();
				// 괄호를 적용해서 각각 큐에 담는다.
				check(list.get(i));

				int result = calc(nums.poll(), nums.poll(), signs.poll());
				while (!signs.isEmpty()) {
					result = calc(result, nums.poll(), signs.poll());
				}
				ans = Math.max(ans, result);
			}
		}
		System.out.println(ans);
	}

	private static void check(String cmd) {
		Queue<Character> q = new ArrayDeque<>();
		for (char c : cmd.toCharArray()) {
			q.offer((char) (c - '0'));
		}
		int i = 0;
		while (!q.isEmpty()) {
			int c = q.poll();
			while (i < STR.length()) {
				if (c * 2 == i) {
					nums.add(calc(STR.charAt(i) - '0', STR.charAt(i + 2) - '0', STR.charAt(i + 1)));
					if (i < STR.length() - 3) {
						signs.add(STR.charAt(i + 3));
					}

					i += 4;
					break;
				} else {
					nums.add(STR.charAt(i) - '0');
					if (i != STR.length() - 1) {
						signs.add(STR.charAt(i + 1));
						i += 2;
						continue;
					} else {
						break;
					}
				}
			}
		}
		for (int j = i; j < STR.length();) {
			nums.add(STR.charAt(j) - '0');
			if (j != STR.length() - 1) {
				signs.add(STR.charAt(j + 1));
				j += 2;
			} else {
				break;
			}
		}
	}

	private static int calc(int num, int num2, char sign) {
		if (sign == '+') {
			return num + num2;
		} else if (sign == '-') {
			return num - num2;
		} else {
			return num * num2;
		}
	}

	private static void subset() {
		for (int i = 1; i < (1 << (N / 2)); i++) {
			S = "";
			flag = false;
			for (int j = 0; j < (N / 2); j++) {
				if ((i & (1 << j)) == 0)
					continue;
				S += j;
				for (int s = 1; s < S.length(); s++) {
					if (Math.abs(S.charAt(s - 1) - S.charAt(s)) == 1) {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				list.add(S);
			}
		}
	}
}

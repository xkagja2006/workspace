package 역량평가준비.d0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
	static int[] input, number;
	static int N, B, ans, R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			input = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				number = new int[i];
				R = i;
				combi(0, 0, 0);
			}
			System.out.println("#" + t + " " + (ans - B));
		}
	}

	private static void combi(int cnt, int start, int sum) {
		// 최소정답을 넘기면 정답이 될 수 없음
		if (sum >= ans)
			return;
		if (cnt == R) {
			if (sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			number[cnt] = input[i];
			combi(cnt + 1, i + 1, sum + number[cnt]);
		}
	}
}

package 역량평가준비.d0404;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	static int[] input;
	static int[] answer;
	static int[] number;
	static int R = 7;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		number = new int[7];
		answer = new int[7];

		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		combi(0, 0);
		Arrays.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			int tot = 0;
			for (int i = 0; i < R; i++) {
				tot += number[i];
			}
			if (tot == 100) {
				answer = number.clone();
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			number[cnt] = input[i];
			combi(cnt + 1, i + 1);
		}
	}
}

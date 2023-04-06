package 역량평가준비.d0405;

import java.util.Scanner;

public class BOJ_1476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (E == (i - 1) % 15 + 1 && S == (i - 1) % 28 + 1 && M == (i - 1) % 19 + 1) {
				System.out.println(i);
				break;
			}
		}
	}
}

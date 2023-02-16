package com.ssafy.live09;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitTest {
	static int N,R;
	static int[] numbers, inputs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		inputs = new int[N];
		for(int i = 1; i <= N; i++) inputs[i-1] = i;
		perm(0, 0);
	}
	private static void perm(int cnt, int flag) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i)) != 0) continue;
			numbers[cnt] = inputs[i];
			perm(cnt + 1, flag | (1 << i));
		}
	}
}

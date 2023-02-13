package com.ssafy.day0210;

import java.util.Arrays;
import java.util.Scanner;

public class 순열 {
	static int N,R;
	static int[] numbers, inputs;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		inputs = new int[N];
		visited = new boolean[N];
		for(int i = 1; i <= N; i++) inputs[i-1] = i;
		perm(0);
	}
	private static void perm(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}

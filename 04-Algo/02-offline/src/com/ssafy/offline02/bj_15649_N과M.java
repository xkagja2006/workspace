package com.ssafy.offline02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15649_N과M {
	static int N, R;
	static int[] numbers, inputs;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[R];
		inputs = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			inputs[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == R) {
			for(int x : numbers) {
				sb.append(x);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}

}


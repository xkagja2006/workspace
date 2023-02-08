package com.ssafy.offline03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15652_N과M5 {
	static int N, M;
	static int[] numbers, inputs;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//N개의 자연수 중 M개를 순서 있게 고른 수열 -> 순열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		inputs = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
		perm(0);
		bw.write(sb.toString());
		bw.close();
	}

	private static void perm(int cnt) throws IOException {
		if (cnt == M) {
			for (int x : numbers) {
				sb.append(x);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}

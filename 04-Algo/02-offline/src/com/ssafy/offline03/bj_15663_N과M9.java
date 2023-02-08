package com.ssafy.offline03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bj_15663_N과M9 {
	static int N, M;
	static int[] numbers, inputs;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static TreeSet<String> set = new TreeSet<>();
	static String[] arr;

//N개의 자연수 중 M개를 중복 가능하게 나열한 수열 -> 중복순열
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
		arr = new String[set.size()];
		int idx = 0;
		while (!set.isEmpty()) {
			arr[idx++] = set.first();
			set.remove(set.first());
		}

		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] ch1 = o1.split(" ");
				String[] ch2 = o2.split(" ");
				if (Integer.parseInt(ch1[0]) == Integer.parseInt(ch2[0]))
					return Integer.parseInt(ch1[0]) - Integer.parseInt(ch2[0]);
				return Integer.parseInt(ch1[1]) - Integer.parseInt(ch2[1]);
			}

		});

		System.out.println(Arrays.toString(arr));
		bw.close();
	}

	private static void perm(int cnt) throws IOException {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int x : numbers) {
				sb.append(x);
				sb.append(" ");
			}
			set.add(sb.toString());
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

package com.ssafy.offline09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_17406_배열돌리기4_2 {
	static int N, M, K, r, c, s, idx, total;
	static int[][] arr;
	static int[][] cmd;
	static boolean[] visited;
	static int[] numbers, inputs;
	static int min = Integer.MAX_VALUE;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cmd = new int[K][3];
		visited = new boolean[K];
		inputs = new int[K];
		numbers = new int[K];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			cmd[i][0] = r;
			cmd[i][1] = c;
			cmd[i][2] = s;
			inputs[i] = i + 1;
		}
		perm(0);
		for (int i = 0; i < total; i++) {
			int[] order = list.get(i);
			int[][] arr1 = new int[N][M];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					arr1[n][m] = arr[n][m];
				}
			}

			for (int j = 0; j < order.length; j++) {
				rotate(cmd[order[j] - 1], arr1);
			}
			for (int[] a : arr1) {
				int sum = 0;
				for (int b : a) {
					sum += b;
				}
				min = Math.min(min, sum);
			}
		}

		System.out.println(min);
	}

	private static void perm(int cnt) {
		if (cnt == K) {
			total++;
			int[] add = numbers.clone();
			list.add(add);

		} else {
		}
		for (int i = 0; i < K; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	// 왼쪽 위 : (r-s-1, c-s-1)
	// 오른쪽 아래 : (r+s-1, c+s-1)
	// 1,2 저장했다가 1,3에 넣어야함.
	private static int[][] rotate(int[] cmd, int[][] array) {

		r = cmd[0];
		c = cmd[1];
		s = cmd[2];
		for (int t = 0; t < s; t++) {
			int Len = 2 * s - t;
			int cL = r - s - 1;
			int rL = c - s - 1;
			int tmp = array[cL + t][rL + t];
			// 왼
			for (int i = t; i < Len; i++) {
				array[cL + i][rL + t] = array[cL + i + 1][rL + t];
			}
			// 아래
			for (int i = t; i < Len; i++) {
				array[cL + Len][rL + i] = array[cL + Len][rL + i + 1];
			}
			// 오
			for (int i = Len; i > t; i--) {
				array[cL + i][rL + Len] = array[cL + i - 1][rL + Len];
			}
			// 위
			for (int i = Len; i > t; i--) {
				array[cL + t][rL + i] = array[cL + t][rL + i - 1];
			}
			array[cL + t][rL + t + 1] = tmp;
		}
		return array;
	}
}

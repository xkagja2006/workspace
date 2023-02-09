package com.ssafy.offline04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			int[][] small = new int[M][M];
			for (int i = 0; i < (N - M + 1); i++) {
				for (int j = 0; j < (N - M + 1); j++) {
					int sum = 0;
					// [i][j]를 0,0으로 생각하는 MxM배열 원소의 합을 구하자. 
					for(int x = 0; x < M; x++) {
						for(int y = 0; y < M; y++) {
							sum += arr[i+x][j+y];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}

package com.ssafy.offline04;

import java.util.Scanner;

public class bj_2961_도영이가만든맛있는음식2 {
	static int T;
	static boolean[] visited;
	static int[][] taste;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		taste = new int[T][2];
		visited = new boolean[T];
		
		for (int i = 0; i < T; i++) {
			taste[i][0] = sc.nextInt(); // 신맛
			taste[i][1] = sc.nextInt(); // 쓴맛
		}
		subset(0);
		System.out.println(result);
	}
	private static void subset(int cnt) {
		if(cnt == T) {
			int sSum = 1, bSum = 0;
			for(int i = 0; i < T; i++) {
				if(!visited[i]) continue;
				sSum *= taste[i][0];
				bSum += taste[i][1];
			}
			if(bSum == 0) return;
			result = Math.min(result, Math.abs(sSum - bSum));
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
}

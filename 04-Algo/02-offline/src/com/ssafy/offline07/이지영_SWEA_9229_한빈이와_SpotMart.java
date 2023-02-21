package com.ssafy.offline07;

import java.util.Scanner;

public class 이지영_SWEA_9229_한빈이와_SpotMart {
	static int[] snacks;
	static int[] picks = new int[2];
	static int result, sN, maxW;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			result = 0;
			sN = sc.nextInt();
			maxW = sc.nextInt();
			snacks = new int[sN];
			for(int i = 0; i < sN; i++) {
				snacks[i] = sc.nextInt();
			}
			combi(0,0);
			System.out.println("#" + t + " " + (result == 0 ? -1 : result));
		}
	}
	private static void combi(int cnt, int start) {
		if(cnt == 2) {
			int max = 0;
			for(int i : picks) max += i;
			if(max > result && max <= maxW) { 
				result = max;
			}
			return;
		}
		for(int i = start; i < sN; i++) {
			picks[cnt] = snacks[i];
			combi(cnt + 1, i + 1);
		}
	}
}

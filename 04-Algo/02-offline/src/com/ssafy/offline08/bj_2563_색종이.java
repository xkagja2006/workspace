package com.ssafy.offline08;

import java.util.Scanner;

public class bj_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[][] arr = new boolean[100][100];
		int ans = 0;
		for (int t = 0; t < T; t++) {
			int row = sc.nextInt(); // 행
			int col = sc.nextInt(); // 열
			for(int i = row; i < (row+10); i++) {
				for(int j = col; j < (col+10); j++) {
					if(arr[i][j] == true) {
						continue;
					}else {
						arr[i][j] = true;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}

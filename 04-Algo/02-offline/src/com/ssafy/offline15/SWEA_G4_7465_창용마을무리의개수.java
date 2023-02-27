package com.ssafy.offline15;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_G4_7465_창용마을무리의개수 {
	static boolean[][] map, visited;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new boolean[N + 1][N + 1];
			map = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = true;
				map[b][a] = true;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(map[i][j] == false ? ". " : "O" + " ");
				}
				System.out.println();
			}
			System.out.println("-----------");
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j++) {
					if (visited[i][j])
						continue;
					ans++;
					findFriend(i, j);
				}

			}
		}
	}

	private static void findFriend(int i, int j) {
		
	}
}

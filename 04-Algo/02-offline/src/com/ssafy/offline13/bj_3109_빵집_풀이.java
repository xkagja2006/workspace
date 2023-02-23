package com.ssafy.offline13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_3109_빵집_풀이 {
	static char[][] map;
	static int R, C, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/input3109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		// 아래줄에서 넣어주기때문에 처음에 만들때 크기를 비워서 만들면 메모리낭비를 줄일 수 있다
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		for (int i = 0; i < R; i++)
			dfs(i, 0);
		System.out.println(ans);

	}

	static int[] dr = { -1, 0, 1 }; // dc는 항상 +1이니깐 잡아줄 필요 없다.

	private static boolean dfs(int r, int c) {
		map[r][c] = 'x';
		if (c == C - 1) {
			ans++;
			return true;
		}

		int nr, nc = c + 1;
		for (int d = 0; d < 3; d++) {
			nr = r + dr[d]; // 위, 오, 아
			if (nr < 0 || nr >= R || map[nr][nc] == 'x')
				continue;	// 아래 if(dfs) 뛰어넘고 바로 다음 반복문 실행!

			if(dfs(nr, nc)) {
				return true;
			}
		}
		return false;
	}
}

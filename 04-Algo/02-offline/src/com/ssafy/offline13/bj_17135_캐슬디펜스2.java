package com.ssafy.offline13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_17135_캐슬디펜스2 {
	static int C, R, D, answer;
	static int[] numbers, input;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[C][R];

		numbers = new int[3];
		input = new int[R];
		for (int i = 0; i < R; i++)
			input[i] = i;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수의 위치 구하기 RC3
		comb(0, 0);
		System.out.println("------ : " + answer);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(numbers));
			// 적들과 궁수와의 거리 구하기
//			findDistance();
			// 사거리 안에 들어오는 숫자를 0으로 만들고 사거리를 1 늘린다.
			int distance = D;
			answer = Math.max(answer, fight(distance, findDistance()));
			return;
		}
		for (int i = start; i < R; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}

	private static int fight(int d, int[][] nMap) {
		int ans = 0;
		for (int i = C - 1; i >= 0; i--) {
			int cnt = 0;
			for (int j = 0; j < R; j++) {
				if (nMap[i][j] != 0 && nMap[i][j] <= d) {
					nMap[i][j] = 0;
					ans++;
					cnt++;
				}
				if (cnt == 3)
					break;
			}
			d++;
		}
		System.out.println("ans : " + ans);
		return ans;
	}

	private static int[][] findDistance() {
		// numbers배열의 원소는 각각 열의 인덱스. 행의 인덱스는 C+1이다!
		int[][] arrow = { { C, numbers[0] }, { C, numbers[1] }, { C, numbers[2] } };

		int[][] nMap = new int[C][R];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				nMap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (nMap[i][j] == 1) {
					nMap[i][j] = 50;
					for (int x = 0; x < 3; x++) {
						int distance = Math.abs(C - i) + Math.abs(arrow[x][1] - j);
						nMap[i][j] = Math.min(nMap[i][j], distance);
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(nMap));
		return nMap;
	}
}

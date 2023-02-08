package com.ssafy.offline02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] sw = new int[T];
		for (int i = 0; i < T; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}

		int people = Integer.parseInt(br.readLine());
		int gender, number = 0;
		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gender = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken()) - 1;

			if (gender == 1) {
				for (int s = 0; s < T; s++) {
					if ((s + 1) % (number + 1) == 0) {
						sw[s] = (sw[s] == 1 ? 0 : 1);
					}
				}
			} else {
				int check = Math.min(Math.abs(T - number), number);
				sw[number] = (sw[number] == 1 ? 0 : 1);
				for (int s = 1; s <= check; s++) {
					if ((number + s) < T && (number - s) > -1 && sw[number - s] == sw[number + s]) {
						sw[number - s] = (sw[number - s] == 1 ? 0 : 1);
						sw[number + s] = (sw[number + s] == 1 ? 0 : 1);
					} else break;
				}
			}
		}

		for (int i = 1; i <= T; i++) {
			sb.append(sw[i-1] + " ");
			if (i % 20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

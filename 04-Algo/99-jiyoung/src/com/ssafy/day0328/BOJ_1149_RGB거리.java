package com.ssafy.day0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] house = new int[T][3];	// 빨 초 파

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[t][0] = Integer.parseInt(st.nextToken());
			house[t][1] = Integer.parseInt(st.nextToken());
			house[t][2] = Integer.parseInt(st.nextToken());
		}
		int idx = 1;
		int red = house[0][0];
		int green = house[0][1];
		int blue = house[0][2];
		while(idx < T) {
			int nred = red;
			int ngreen = green;
			int nblue = blue;
			red = Math.min(ngreen, nblue) + house[idx][0]; 
			green = Math.min(nred, nblue) + house[idx][1]; 
			blue = Math.min(ngreen, nred) + house[idx][2]; 
			idx++;
		}
		System.out.println(Math.min(Math.min(red, green), blue));
	}
}

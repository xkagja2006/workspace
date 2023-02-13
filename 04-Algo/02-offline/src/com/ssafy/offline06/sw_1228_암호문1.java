package com.ssafy.offline06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int L = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < L; i++)
				list.add(Integer.parseInt(st.nextToken()));

			int C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < C; i++) {
				String I = st.nextToken();
				int startIdx = Integer.parseInt(st.nextToken());
				int nums = Integer.parseInt(st.nextToken());
				for (int j = 0; j < nums; j++) {
					list.add(startIdx + j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}

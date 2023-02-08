package com.ssafy.offline02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_1208_Flatten {
	public static void main(String[] args) throws FileNotFoundException {
		int T = 10;
		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] box = new int[101];
			int maxH = 1;
			int minH = 100;
			for (int i = 0; i < 100; i++) {
				int h = sc.nextInt();
				box[h]++;
				if (minH > h)
					minH = h;
				if (maxH < h)
					maxH = h;
			}
			while (true) {
				if (N <= 0 || maxH - minH <= 1)
					break;
				box[minH]--;
				box[minH + 1]++;
				box[maxH]--;
				box[maxH - 1]++;

				if (box[minH] == 0)
					minH++;
				if (box[maxH] == 0)
					maxH--;

				--N;
			}

			System.out.println("#" + (t + 1) + " " + (maxH - minH));
		}
	}
}

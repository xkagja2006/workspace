package com.ssafy.offline03;

import java.util.Arrays;
import java.util.Scanner;

public class bj_3040_백설공주와일곱난쟁이2 {

	public static void main(String[] args) {
		int[] data = new int[9];
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			data[i] = sc.nextInt();
			sum += data[i];
		}
		Arrays.sort(data);

		// 조합
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if(sum - (data[i] + data[j]) == 100) {
					for(int k= 0; k < 9; k++) {
						if(k == i || k == j) continue;
						System.out.println(data[k]);
					}
					return;
				}
			}
		}
	}
}
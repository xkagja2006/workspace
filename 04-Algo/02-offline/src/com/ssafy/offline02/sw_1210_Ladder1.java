package com.ssafy.offline02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_1210_Ladder1 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1210.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int testC = sc.nextInt();
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.print("#" + testC + " ");
			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					if (findX(arr, i, 0))
						System.out.println(i);
				}
			}
		}

	}

	private static boolean findX(int[][] arr, int x, int y) {
		if (y == 99) {
			if (arr[y][x] == 2) {
				return true;
			}
			return false;
		}

		if (x != 99 && arr[y][x + 1] == 1) {
			while(true) {
				x += 1;
				if(x == 99 || arr[y][x+1] != 1) break;
			}
		}
		else if (x != 0 && arr[y][x - 1] == 1) {
			while(true) {
				x -= 1;
				if(x == 0 || arr[y][x-1] != 1) break;
			}
		}
		
		return findX(arr, x, y + 1);
	}
}

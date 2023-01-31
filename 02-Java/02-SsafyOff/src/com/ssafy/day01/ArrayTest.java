package com.ssafy.day01;

import java.util.Arrays;

public class ArrayTest {
	static int N, M;

	public static void main(String[] args) {
		N = 3;
		M = 3;
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		exam01(arr);
//		exam02(arr);
//		exam03(arr);
		exam04(arr);
	}

	/*
	 * 1 2 3 
	 * 6 5 4
	 * 7 8 9
	 */
	private static void exam04(int[][] arr) {
		for (int i = 0; i < N; i++) {
			if (i % 2 == 1) {
				for (int j = 0; j < M; j--) {
					System.out.print(arr[i][j + (M - 1 - 2*j)*(i%2)] + " ");
				}
			}
			System.out.println("");
		}
//		for (int i = 0; i < arr.length; i++) {
//			if (i % 2 == 1) {
//				for (int j = arr[i].length-1; j >= 0; j--) {
//					System.out.print(arr[i][j] + " ");
//				}
//			} else {
//				for (int j = 0; j < arr[i].length; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//			}
//			System.out.println("");
//		}
		
	}

	/*
	 * 열 우선순회 1 4 7 2 5 8 3 6 9
	 */
	private static void exam03(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[j][i] + " ");
			}
			System.out.println("");
		}
	}

	/*
	 * 행 역우선 순회
	 * 
	 * 3 2 1 6 5 4 9 8 7
	 */
	private static void exam02(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length - 1; j >= 0; j--) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/*
	 * 행 우선순회하기 1 2 3 4 5 6 7 8 9
	 */
	private static void exam01(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

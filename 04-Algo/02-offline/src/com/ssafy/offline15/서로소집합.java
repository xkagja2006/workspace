package com.ssafy.offline15;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

/*
  서로소라 두개의 값이 공통된 약수가 1 밖에 없을 경우 서로소이다. 
 
 */

public class 서로소집합 {
	static int N;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N];

		// make - 집합 생성
		makeSet();
		System.out.println(Arrays.toString(p));

		// union - 집합 합치기
		System.out.println(union(1, 2));
		System.out.println(Arrays.toString(p));
		System.out.println(union(3, 4));
		System.out.println(Arrays.toString(p));
	}

	private static boolean union(int a, int b) {
		// a의 집합 대표 찾기
		int aRoot = find(a);
		// b 집합의 대표 찾기
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		// 집합을 하나로 합친다.
		p[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (p[a] == a)
			return a;
		// 0, 1, 2, 3, 4
		// 0, 1, 1, 2, 4

		return find(p[a]);

	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}
}

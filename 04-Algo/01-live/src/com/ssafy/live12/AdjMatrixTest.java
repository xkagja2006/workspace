package com.ssafy.live12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	static int[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int[V][V];	// 모두 0으로 초기화된 상태
		
		int from, to;
		for(int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향 그래프
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		print();
	}
	
	static void print() {
		for(int[] am : adjMatrix) {
			System.out.println(Arrays.toString(am));
		}
	}
}

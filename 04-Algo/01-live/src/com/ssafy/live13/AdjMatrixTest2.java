package com.ssafy.live13;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest2 {
	static int[][] adjMatrix;
	static int V;
	public static void main(String[] args) {
		// live11의 input2 : 0223 교재 15페이지 그래프
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
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
		bfs(0);
	}
	
	static void print() {
		for(int[] am : adjMatrix) {
			System.out.println(Arrays.toString(am));
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char)(current + 65));
			
			for(int i = 0; i < V; i++) {
				if(adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}

package com.ssafy.offline16;

import java.util.Arrays;
import java.util.Scanner;

public class MST2_Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7\r\n" + 
				"0 32 31 0 0 60 51\r\n" + 
				"32 0 21 0 0 0 0\r\n" + 
				"31 21 0 0 46 0 25\r\n" + 
				"0 0 0 0 34 18 0\r\n" + 
				"0 0 46 34 0 40 51\r\n" + 
				"60 0 0 18 40 0 0\r\n" + 
				"51 0 25 0 51 0 0");
		int N = sc.nextInt();
		
		int[][] data = new int[N][N];
		// 니편 내편 인지 판단
		boolean[] visited = new boolean[N];
		// 각 정점에 연결할 때 최소의 비용
		int[] minCost = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		
		// 최대 비용으로 초기값 설정 : 정점의 최소 비용 보관을 위해 최대값으로 설정
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		// 시작정점 세팅
		minCost[0] = 0;
		int ans = 0;  // 최소신장트리의 간선의 비용을 담을 변수
		for (int n = 0; n < N; n++) {
			int min = Integer.MAX_VALUE, minVertex = -1;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minCost[i]) {
					min = minCost[i];
					minVertex = i;
				}
			}
			// 이제 내편으로 (최소신장트리에 포함되었다)
			visited[minVertex] = true;
			ans += min;
			
			// 선택된 정점에 대해서 연결된 간선들의 비용과 최소비용을 가지고 있는 minCost와 비교해서 최소 비용 갱신작업
			for (int i = 0; i < N; i++) {
				if (!visited[i] && data[minVertex][i] != 0 
						&& minCost[i] > data[minVertex][i]) {
					minCost[i] = data[minVertex][i];
				}
			}
		}
		System.out.println(ans);
	}
}



























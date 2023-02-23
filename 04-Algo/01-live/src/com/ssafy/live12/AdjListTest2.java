package com.ssafy.live12;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjListTest2 {
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new ArrayList[V]; 
		// ArrayList가 모두 null인 상태, 각각 원소들에 해당하는 ArrayList들을 만들어서 넣어야한다. 안하면 널포인트예외 발생.
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향 그래프
			adjList[from].add(to);
			adjList[to].add(from);
		}
		print();
	}

	static void print() {
		for (ArrayList list : adjList) { // list : 각 정점의 인접 리스트인 arraylist.
			System.out.println(list);
		}
	}
}

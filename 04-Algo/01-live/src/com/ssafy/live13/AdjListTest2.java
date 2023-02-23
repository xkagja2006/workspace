package com.ssafy.live13;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest2 {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}

	static Node[] adjList;
	static int V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new Node[V]; // head가 모두 null인 상태
		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향 그래프
			// stack 구현과 동일
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[from]);
		}
		print();
		bfs(0);
	}

	static void print() {
		for (Node node : adjList) { //node : 각 정점의 인접리스트의 head
			System.out.println(node);
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
			
			for(Node temp = adjList[current]; temp!= null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
}

package com.ssafy.live08;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

//완전이진트리 : 1차원 배열 구현
public class CompleteBianryTree2<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;

	public CompleteBianryTree2(int size) {
		SIZE = size;
		nodes = new Object[size + 1];
	}

	private boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(T e) {
		if (isFull())
			return;

		nodes[++lastIndex] = e;
	}

	public void bfs1() {
		// 큐에는 탐색노드의 번호 저장
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 루트노드부터. 0번 인덱스는 안쓴다! (노드의 인덱스를 계산할때 편하게 하기 위해)

		int current = 0, size, level = 0;
		while (!queue.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드 처리
			
			size = queue.size();
			System.out.print("level " + level + ":");
			while(--size >= 0) {
				current = queue.poll(); // 현재 탐색해야하는 노드 번호
				System.out.print(nodes[current] + "\t");
				
				//왼쪽자식의 노드번호 : currnet * 2
				if(current * 2 <= lastIndex) queue.offer(current * 2);
				//오른쪽자식
				if(current *2 + 1 <= lastIndex) queue.offer(current *2 + 1);
			}
			level++;
			System.out.println();
		}
	}
	//전위순회
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
		System.out.print(nodes[current] + " ");
		
		//왼쪽자식의 노드번호 : currnet * 2
		if(current * 2 <= lastIndex) dfsByPreOrder(current * 2);
		//오른쪽자식
		if(current *2 + 1 <= lastIndex) dfsByPreOrder(current *2 + 1);
	}

	//중위순회
	public void dfsByInOrder() {
		System.out.println("dfsByInOrder : ");
		dfsByInOrder(1);
		System.out.println();
	}
	
	public void dfsByInOrder(int current) {
		
		//왼쪽자식의 노드번호 : currnet * 2
		if(current * 2 <= lastIndex) dfsByInOrder(current * 2);

		System.out.print(nodes[current] + " ");
		
		//오른쪽자식
		if(current *2 + 1 <= lastIndex) dfsByInOrder(current *2 + 1);
	} 
	
	// 후위순회
	public void dfsByPostOrder() {
		System.out.println("dfsByPostOrder : ");
		dfsByPostOrder(1);
		System.out.println();
	}
	
	public void dfsByPostOrder(int current) {
		
		//왼쪽자식의 노드번호 : currnet * 2
		if(current * 2 <= lastIndex) dfsByPostOrder(current * 2);
		//오른쪽자식
		if(current *2 + 1 <= lastIndex) dfsByPostOrder(current *2 + 1);
		System.out.print(nodes[current] + " ");
	}
	
	// 후위순회2
	public void dfsByPostOrder2() {
		System.out.println("dfsByPostOrder : ");
		dfsByPostOrder2(1);
		System.out.println();
	}
	
	public void dfsByPostOrder2(int current) {
		if(current > lastIndex) return;
		//왼쪽자식의 노드번호 : currnet * 2
		dfsByPostOrder(current * 2);
		//오른쪽자식
		dfsByPostOrder(current *2 + 1);
		System.out.print(nodes[current] + " ");
	}
	
	public void dfs() {
		// 큐에는 탐색노드의 번호 저장
		Stack<Integer> stack = new Stack<>();
		stack.push(1); // 루트노드부터. 0번 인덱스는 안쓴다! (노드의 인덱스를 계산할때 편하게 하기 위해)

		int current = 0, size, level = 0;
		while (!stack.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드 처리
			
			size = stack.size();
			System.out.print("level " + level + ":");
			while(--size >= 0) {
				current = stack.pop(); // 현재 탐색해야하는 노드 번호
				System.out.print(nodes[current] + " ");
				
				//오른쪽자식 먼저들어가게함
				if(current *2 + 1 <= lastIndex) stack.push(current *2 + 1);
				//왼쪽자식의 노드번호 : currnet * 2
				if(current * 2 <= lastIndex) stack.push(current * 2);
			}
			level++;
			System.out.println();
		}
	}
	
	
	@Override
	public String toString() {
		return "CompleteBianryTree [nodes=" + Arrays.toString(nodes) + ", SIZE=" + SIZE + ", lastIndex=" + lastIndex
				+ "]";
	}
	
	
}

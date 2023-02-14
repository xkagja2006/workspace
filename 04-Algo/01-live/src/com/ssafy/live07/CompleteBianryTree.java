package com.ssafy.live07;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//완전이진트리 : 1차원 배열 구현
public class CompleteBianryTree<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;

	public CompleteBianryTree(int size) {
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

	public void bfs() {

		// 큐에는 탐색노드의 번호 저장
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); // 루트노드부터. 0번 인덱스는 안쓴다! (노드의 인덱스를 계산할때 편하게 하기 위해)

		int current = 0, lvl = 0;
		while (!queue.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드 처리
			System.out.print("레벨 : " + lvl + " ");
			for(int i = 0, size = queue.size(); i < size ; i++) {
				current = queue.poll(); // 현재 탐색해야하는 노드 번호
				System.out.print(nodes[current] + " ");
				
				// 현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
				// 완전 이진 트리 : 자식이 최대 2개인 상황 -> if문 2개로 처리해버리기
				//왼쪽자식의 노드번호 : currnet * 2
				if(current * 2 <= lastIndex) queue.offer(current * 2);
				//오른쪽자식
				if(current *2 + 1 <= lastIndex) queue.offer(current *2 + 1);
			}
			System.out.println();
			++lvl;
		}
	}

	@Override
	public String toString() {
		return "CompleteBianryTree [nodes=" + Arrays.toString(nodes) + ", SIZE=" + SIZE + ", lastIndex=" + lastIndex
				+ "]";
	}
	
	
}

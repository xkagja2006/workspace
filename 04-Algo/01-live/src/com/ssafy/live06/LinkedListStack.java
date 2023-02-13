package com.ssafy.live06;

public class LinkedListStack<T> implements IStack<T> {
	private Node<T> top; // stack의 head

	@Override
	public void push(T e) {
		// top으로 삽입
		top = new Node<T>(e, top);
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		Node<T> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() { // top부터 노드 따라가서 마지막 노드까지의 수
		int res = 0;
		for (Node<T> temp = top; temp != null; temp = temp.link) {
			res++;
		}
		return res;
	}

}

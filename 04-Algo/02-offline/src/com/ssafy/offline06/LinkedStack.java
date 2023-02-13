package com.ssafy.offline06;

public class LinkedStack<E> implements IStack<E> {
	
	public static void main(String[] args) {
		LinkedStack<Integer> s = new LinkedStack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

	class Node<T> {
		T data;
		Node<T> link;

		Node(T data, Node<T> link) {
			this.data = data;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
	}
	
	Node<E> top;

	@Override
	public void push(E data) {
		top = new Node<>(data, top);	//새롭게 만들어진 노드의 링크에 기존의 top이 참조하는것을 가리키게 함. 그리고 이 노드를 top이 가리키게 함.
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("없음");
			return null;
		}
		Node<E> node = top;
		top = top.link;
		node.link = null;
		return node.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("없음");
			return null;
		}
		return top.data;
	}

	@Override
	public int size() {
		int cnt = 0;
		Node<E> node = top;
		while(node != null) {
			cnt++;
			node = node.link;
		}
		return cnt;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}

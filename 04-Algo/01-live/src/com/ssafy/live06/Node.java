package com.ssafy.live06;

public class Node<T> {
	T data;
	Node link;

	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}

}

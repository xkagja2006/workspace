package com.ssafy.offline06;

public interface IStack<E> {
	void push(E data);
	E pop();
	E peek();
	int size();
	boolean isEmpty();
}

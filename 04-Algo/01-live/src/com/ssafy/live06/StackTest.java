package com.ssafy.live06;

public class StackTest {
	public static void main(String[] args) {
		IStack<String> stack = new LinkedListStack<>();
		stack.push("a");
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		stack.push("b");
		stack.push("c");
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size() + "//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

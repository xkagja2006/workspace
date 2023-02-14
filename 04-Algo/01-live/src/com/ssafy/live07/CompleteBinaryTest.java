package com.ssafy.live07;

public class CompleteBinaryTest {
	public static void main(String[] args) {
		int size = 9;
		
		CompleteBianryTree<Character> tree = new CompleteBianryTree<>(size);
		
		for(int i = 0; i < size; ++i) {
			tree.add((char)(65+i));
		}
		System.out.println(tree);
		tree.bfs();
	}
}

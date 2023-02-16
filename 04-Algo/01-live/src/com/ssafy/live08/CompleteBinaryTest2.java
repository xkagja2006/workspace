package com.ssafy.live08;

public class CompleteBinaryTest2 {
	public static void main(String[] args) {
		int size = 9;
		
		CompleteBianryTree2<Character> tree = new CompleteBianryTree2<>(size);
		
		for(int i = 0; i < size; ++i) {
			tree.add((char)(65+i));
		}
		System.out.println(tree);
//		tree.bfs1();
		tree.dfsByPreOrder();
//		tree.dfsByInOrder();
//		tree.dfsByPostOrder();
		tree.dfs();
	}
}

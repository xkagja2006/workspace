package com.ssafy.offline08;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_11286_절댓값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				else return (Math.abs(o1) - Math.abs(o2));
			}
		});
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int cmd = sc.nextInt();
			if(cmd == 0) {
				if(priorityQueue.isEmpty()) System.out.println( 0);
				else System.out.println(priorityQueue.poll());
			}else {
				priorityQueue.add(cmd);
			}
		}
	}
}

package com.ssafy.offline08;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
class compares implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
		return Math.abs(o1) - Math.abs(o2);
	}
}*/

public class num11286 {
	
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		/*
		PriorityQueue<Integer> priorityqueue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
	*/
		
		PriorityQueue<Integer> priorityqueue = new PriorityQueue<>( 
				(Integer o1, Integer o2) -> {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		);
		
		for(int n = 0; n < N; n++) {
			
			int tmp = sc.nextInt();
			if(tmp != 0) priorityqueue.offer(tmp);
			else if (priorityqueue.isEmpty()) System.out.println("0"); 
			else {
				System.out.println(priorityqueue.poll());			
			}
		}
	}
	
}

package com.ssafy.offline06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Queue<Integer> q = new LinkedList<>();
			int T = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				q.offer(n);
			}
			int minus = 1;
			while (true) {
				if(minus == 6) minus = 1;
				int first = q.poll();
				q.offer(first - minus >= 0 ? first - minus : 0);
				
				if(first - minus <= 0) break;
				minus++;
			}
			System.out.print("#" + T + " ");
			for(int i : q) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

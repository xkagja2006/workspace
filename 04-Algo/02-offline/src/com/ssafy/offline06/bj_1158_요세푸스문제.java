package com.ssafy.offline06;

import java.util.LinkedList;
import java.util.Scanner;

public class bj_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		int N = sc.nextInt();
		int R = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int index = 0;
		sb.append("<");
		while (true) {
			index = (index + R)%(list.size()) - 1;
			if(index < 0) index = list.size() - 1;
			int i = list.get(index);
			list.remove(index);
			if(list.size() == 0) sb.append(i + ">");
			else sb.append(i + ", ");
			if (list.isEmpty()) {
				break;
			}
		}
		System.out.println(sb.toString());
	}
}

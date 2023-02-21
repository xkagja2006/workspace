package com.ssafy.live10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyTest {

	private static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// 종료시간 다르면 먼저끝나는것부터. 같으면 먼저 시작한것부터.
			return this.end != o.end ? this.end - o.end : this.start - o.start;
			// 부호가 다른경우는 바뀔수있으니깐 Integer.compare(a,b) 를 사용하자!!!!!!!!!!
		}
		

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Meeting[] m = new Meeting[count];

		for (int i = 0; i < count; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(m);

		List<Meeting> result = new ArrayList<Meeting>();
		result.add(m[0]);

		for (int i = 1; i < count; i++) {
			// 마지막 회의의 종료시간보다 현재회의의 시작시간이 같거나 크다면 양립 가능
			if(result.get(result.size()-1).end <= m[i].start) {
				result.add(m[i]);
			}
		}
		System.out.println(result.size());
		for(Meeting meet : result) {
			System.out.println(meet);
		}
	}
}

package com.ssafy.offline05;
import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {
	static int N = 20;
	static int person = 1;
	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { person, 1 });
		int availableCnt = 0;
		while (N > 0) {
			int[] p = queue.poll();
			availableCnt = (N >= p[1]) ? p[1] : N;
			N -= availableCnt;
			if (N == 0) {
				System.out.printf("마지막 마이쭈를 가져간 사원 %d 가져간 개수 : %d", p[0], availableCnt);
				break;
			} 
			System.out.printf("%d번이 %d개수만큼 가져갑니다. 남은 수 : %d%n", p[0], availableCnt, N);
			p[1]++; 			// 받을 마이쮸 개수 하나 증가
			queue.offer(p);		// 자기 다시 줄 세우기
			queue.offer(new int[] { ++person, 1 }); 	// 다음번호 사람 줄 세우기
		}
	}
}


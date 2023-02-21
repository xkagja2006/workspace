package com.ssafy.live11;

import java.util.Scanner;

public class NQueenTest {
	static int N, col[], answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		
		setQueen(1);
		System.out.println(answer);
	}

	private static void setQueen(int rowNo) {
		if (!isAvailable(rowNo - 1))
			return;

		if (rowNo > N) {
			answer += 1;
			return;
		}

		for (int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueen(rowNo + 1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) { // k : 비교대상 queen의 행
			if (col[k] == col[rowNo] || Math.abs(col[k] - col[rowNo]) == rowNo - k)
				return false;
		}
		return true;
	}
}

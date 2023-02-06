package com.ssafy.offline01;

//4C3 조합의 경우의 수
public class Test07 {
	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		System.out.println(combi(n,k));
	}

	private static int combi(int n, int k) {
		if(n == k || k == 0) return 1;
		return combi(n-1, k-1) + combi(n-1, k);
	}
}

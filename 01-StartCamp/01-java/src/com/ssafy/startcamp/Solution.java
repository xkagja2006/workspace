package com.ssafy.startcamp;
import java.io.FileInputStream;
import java.util.*;

public class Problem02_햄버거다이어트 {
	
	public int find() {
		int sum = 0;
		return sum;
	}

	public static void main(String args[]) throws Exception
	{
		
//		System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			//1. 모든 경우를 구하기
			int caseN = sc.nextInt();
			int maxKcal = sc.nextInt();
			int[] taste = new int[caseN];
			int[] kcal = new int[caseN];
			int maxK = 0;
			int nowK = 0;
			int t = 0;
			for(int i = 0; i < caseN; i++) {
				taste[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			System.out.println(Arrays.toString(taste));
			System.out.println(Arrays.toString(kcal));
			
			//재귀함수 만들기
			
			
		}
	}
}
